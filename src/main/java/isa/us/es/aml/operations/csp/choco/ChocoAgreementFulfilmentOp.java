/**
 * This file is part of ADA.
 *
 * ADA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * ADA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ADA. If not, see <http://www.gnu.org/licenses/>.
 */
package isa.us.es.aml.operations.csp.choco;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.solver.ContradictionException;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.utils.Utils;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AbstractDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.Range;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.AgreementFulfilmentOperation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.salmon.Measure;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.salmon.MonitoringManagementDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.salmon.OperationMetric;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.salmon.ServiceMetric;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.salmon.WebServiceInformation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag.values.AgreementState;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag.values.AgreementStateImpl;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.Agreement;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.ServiceDescriptionTerm;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.ServiceScope;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.Term;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.domain.ConstantConverter;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.wsag10.domain.DefaultConstantConverter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class ChocoAgreementFulfilmentOp extends ChocoOperation
        implements AgreementFulfilmentOperation {

    private MonitoringManagementDocument mmd;
    private Collection<ServiceScope> violations;
    private boolean result;

    @Override
    public boolean isFulfilled() {
        return result;
    }

    @Override
    public void execute(ChocoAnalyzer an) {
        //XXX como se ve, suponemos que el agreement no
        //realmente es como la operacion de compliance pero,
        //en lugar de ser una oferta compliance con una plantilla
        //es un estado compliance con una oferta
        //por defecto, false
        result = true;
        violations = new LinkedList<ServiceScope>();
        Agreement ag = checkPreconditions();
        if (ag != null) {
            //Comprobamos que el MMD corresponde con el WS-ag
            //mirando si ambos WSI son iguales.
            //Primero conseguimos el WSI del acuerdo
            WebServiceInformation agWSI = null;
            Collection<Term> terms = ag.getAllTerms();
            for (Term t : terms) {
                if (t instanceof ServiceDescriptionTerm) {
                    ServiceDescriptionTerm sdt = (ServiceDescriptionTerm) t;
                    agWSI = sdt.getWebServiceInformation();
                }
            }
            //y las comparamos
            if (agWSI != null && mmd != null && mmd.getWebServiceInformation().equals(agWSI)) {
                //Si son iguales entonces seguimos
                //Obtenemos el MMD con el GeneralResponseTime
                this.mmd = getMMDConGeneralResponseTime(mmd);
                this.mmd = preprocesarMMD(mmd);
                //Sacamos del MMD las medidas del ServiceMetric y OperationMetric
                //y creamos los AgreementState
                //El ServiceScope ser- la operaci-n(new GeneralServiceScope() para los serviceMetric)
                Map<ServiceScope, AgreementState> states = new HashMap<ServiceScope, AgreementState>();
                //Tenemos que llevar un control de las variables que han sido monitorizadas
                //para as- poder quitar las constraints del acuerdo que tengan variables no monitorizadas
                Collection<String> monitorisedVars = new LinkedList<String>();
                //Cargamos los OperationMetric primero para luego a-adir a cada Scope
                //las medidas de los ServiceMetric
                Collection<OperationMetric> operationMetrics = mmd.getOperationMetrics();
                for (OperationMetric om : operationMetrics) {
                    String varName = om.getMetric();
                    for (Measure m : om.getMeasures()) {
                        if (!monitorisedVars.contains(varName)) {
                            monitorisedVars.add(varName);
                        }
                        ServiceScope scope = new ServiceScope();
                        scope.setContent(om.getOpName());
                        String value = m.getValue();
                        //Si el scope ya existe, sacamos el estado y le
                        //a-adimos la variable y el valor
                        if (states.keySet().contains(scope)) {
                            AgreementState agState = states.get(scope);
                            agState.putVariableValue(varName, value);
                        } else {//Sino existe, lo a-adimos a un state nuevo
                            AgreementState agState = new AgreementStateImpl();
                            agState.putVariableValue(varName, value);
                            states.put(scope, agState);
                        }
                    }
                }
                //Cargamos los ServiceMetric
                Collection<ServiceMetric> serviceMetrics = mmd.getServiceMetrics();
                for (ServiceMetric sm : serviceMetrics) {
                    String varName = sm.getMetric();
                    for (Measure m : sm.getMeasures()) {
                        if (!monitorisedVars.contains(varName)) {
                            monitorisedVars.add(varName);
                        }
                        String value = m.getValue();
                        //Los serviceMetric tienen que ir en cada Scope, as- que
                        //recorremos los scopes y vamos a-adiendo la medida del 
                        //serviceMetric en el state que corresponde al scope
                        for (ServiceScope ss : states.keySet()) {
                            AgreementState st = states.get(ss);
                            st.putVariableValue(varName, value);
                        }
                    }
                }
                Collection<AbstractDocument> alternatives = getAlternatives(ag, an, false);
                for (AbstractDocument alt : alternatives) {
                    Map<ServiceScope, AbstractDocument> views = super.getViews(alt, an);
                    Iterator<Entry<ServiceScope, AgreementState>> it = states.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry<ServiceScope, AgreementState> e = it.next();
                        ServiceScope ss = e.getKey();
                        AbstractDocument doc = views.get(ss);
                        if (doc == null) {
                            //El scope que busc-bamos es el scope por defecto, el
                            //que engloba a las variables sin scope
                            //En este caso, asignamos como doc al alternative, que
                            //contiene todas las variables que haya en el state
                            //y las que no est-n en el state se borrar-n luego
                            doc = alt;
                        }
                        AgreementState specificState = e.getValue();
                        ChocoTranslator trans = new ChocoTranslator(doc);
                        trans.translate();
                        Map<String, Variable> vars = trans.getChocoVars();
                        //1. todas las variables deben haber sido monitorizadas
//						Collection<String> stateVars = specificState.getVariablesAsString();
//						Collection<String> agreementVars = vars.keySet();
//						if ( (agreementVars.containsAll(stateVars)) && stateVars.containsAll(agreementVars) ){
                        //ahora creamos la megaConstraint del estado
                        Constraint[] stateCons = state2Choco(vars, specificState);
                        Constraint stateConstraint = Choco.and(stateCons);
                        Collection<Constraint> col = trans.getChocoConstraints().values();
                        //Ya tenemos las constraints del acuerdo, ahora quitamos las que se refieren
                        //a variables no monitorizadas. Para ello llevamos una lista auxiliar con
                        //las constraints que tendremos que borrar
                        Collection<Constraint> constToBeDeleted = new LinkedList<Constraint>();
                        for (Constraint auxCons : col) {
                            for (Variable v : auxCons.extractVariables()) {
                                //habr- que borrar las constraint que tengan alguna
                                //variable sin monitorizar, siempre que no sean una constante
                                String varName = v.toString().substring(0, v.toString().indexOf(" "));
                                if (!monitorisedVars.contains(varName) && !varName.equalsIgnoreCase("cst")) {
                                    if (!constToBeDeleted.contains(auxCons)) {
                                        constToBeDeleted.add(auxCons);
                                    }
                                }
                            }
                        }
                        //Para poder analizar borramos las constraints en las que alguna
                        //de sus variables no est- en el estado, ya que no tendr-an valor
                        Collection<String> stateVars = specificState.getVariablesAsString();
                        for (Constraint auxCons : col) {
                            Boolean deleteThisConstraint = false;
                            for (Variable v : auxCons.extractVariables()) {
                                String varName = v.toString().substring(0, v.toString().indexOf(" "));
                                //Si alguna de las variables (distinta de cst, que son 
                                //las constantes) no est- en el state, borramos esta constraint
                                if (!varName.equalsIgnoreCase("cst") && !stateVars.contains(varName)) {
                                    deleteThisConstraint = true;
                                }
                            }
                            if (deleteThisConstraint) {
                                constToBeDeleted.add(auxCons);
                            }
                        }
                        //ahora borramos las constraints
                        col.removeAll(constToBeDeleted);
                        Constraint[] agreementAnd = col.toArray(new Constraint[0]);
                        Constraint agreementConstraint = Choco.and(agreementAnd);
                        //debemos comprobar la consistencia de acuerdo y estado antes
                        //de ver si son compliance
                        Boolean isAgConsistent = checkConstraintConsistency(agreementConstraint);
                        Boolean isStateConsistent = checkConstraintConsistency(stateConstraint);
                        boolean auxResult = false;
                        if (isAgConsistent && isStateConsistent) {
                            //es compliant el estado con la oferta firmada?
                            auxResult = Utils.isCompliantConstraint(stateConstraint, agreementConstraint);
                        }
                        if (!auxResult) {
                            violations.add(ss);
                        }
                        result = auxResult && result;
//						}
                    }
                }
            }
        }
    }

    private Constraint[] state2Choco(Map<String, Variable> vars,
            AgreementState st) {
        Collection<String> stateVars = st.getVariablesAsString();
        Constraint[] stateCons = new Constraint[stateVars.size()];
        int i = 0;
        for (String var : stateVars) {
            //por cada variable
            int valueType = st.getVariableValueType(var);
            Constraint c = null;
            IntegerVariable v = (IntegerVariable) vars.get(var);
            if (valueType == AgreementState.INT_VAL) {
                int val = st.getIntegerValue(var);
                c = Choco.eq(v, val);
            } else if (valueType == AgreementState.RANGE_VAL) {
                Range r = st.getRangeValue(var);
                c = Choco.and(Choco.geq(v, r.getMin()), Choco.leq(v, r.getMax()));
            } else if (valueType == AgreementState.ENUM_VAL) {
                ConstantConverter conv = DefaultConstantConverter.getInstance();
                Collection<String> vals = st.getEnumValue(var);
                Constraint[] auxCons = new Constraint[vals.size()];
                int j = 0;
                for (String s : vals) {
                    int aux = conv.convertToInteger(s);
                    auxCons[j] = Choco.eq(v, aux);
                    j++;
                }
                c = Choco.or(auxCons);
            }
            stateCons[i] = c;
            i++;
        }
        return stateCons;
    }

    private Agreement checkPreconditions() {
        // XXX partimos de la base de que
        //el documento que recibimos es un acuerdo
        int size = docs.size();
        if (size == 1) {
            AbstractDocument doc = docs.get(0);
            if (doc instanceof Agreement) {
                Agreement ag = (Agreement) doc;
                return ag;
            }
        }
        return null;
    }

    private Boolean checkConstraintConsistency(Constraint c) {
        Boolean isConsistent = Boolean.FALSE;
        CPModel model = new CPModel();
        model.addConstraint(c);
        CPSolver solver = new CPSolver();
        solver.read(model);
//		res = !solver.solve();
        try {
            solver.propagate();
            isConsistent = solver.solve();
        } catch (ContradictionException e) {
            isConsistent = false;
        }
        return isConsistent;
    }

    @Override
    public void setMMD(MonitoringManagementDocument mmd) {
        this.mmd = mmd;
    }

    @Override
    public Collection<ServiceScope> getViolations() {
        return violations;
    }
    /*
     * Calcula la media entre todos los averageResponseTime,
     * si los hay, de todas las operaciones para a-adir
     * GeneralResponseTime al MMD como ServiceMetric
     * return el MMD con un ServiceMetric m-s, el GeneralResponseTime
     */

    private MonitoringManagementDocument getMMDConGeneralResponseTime(MonitoringManagementDocument mmd) {
        //Aqu- guardaremos los primeros AverageResponseTime
        //de cada operaci-n para luego hacer la media
        Collection<Integer> averageResponseTimeFirstMeasures = new LinkedList<Integer>();
        //Recorremos los OperationMetric para sacar los AverageResponseTime
        //y a-adirlos a la colecci-n averageResponseTimeFirstMeasures
        for (OperationMetric om : mmd.getOperationMetrics()) {
            if (om.getMetric().equalsIgnoreCase("AverageResponseTime")) {
                //Solo cogemos el primer AverageResponseTime que
                //corresponde al -ltimo medido
                if (!om.getMeasures().isEmpty()) {
                    Measure firstMeasure = om.getMeasures().get(0);
                    averageResponseTimeFirstMeasures.add(Integer.parseInt(firstMeasure.getValue().trim()));
                }
            }
        }
        //Si hab-a alg-n AverageResponseTime, hacemos la media
        if (averageResponseTimeFirstMeasures.size() > 0) {
            //Sacamos la media los primeros AverageResponseTime
            //de cada operaci-n
            Integer media = mediaAritmetica(averageResponseTimeFirstMeasures);
            //Buscamos el ServiceMetric de GeneralResponseTime y a-adimos la medida
            for (ServiceMetric sm : mmd.getServiceMetrics()) {
                if (sm.getMetric().equalsIgnoreCase("GeneralResponseTime")) {
                    Measure generalResponseTimeMeasure = new Measure();
                    generalResponseTimeMeasure.setValue(Integer.toString(media));
                    sm.addMeasure(generalResponseTimeMeasure);
                }
            }
        } else {
            //Si no hab-a, devolvemos el MMD tal como estaba
        }
        return mmd;
    }

    private MonitoringManagementDocument preprocesarMMD(MonitoringManagementDocument mmd) {
        for (OperationMetric om : mmd.getOperationMetrics()) {
            for (Measure measure : om.getMeasures()) {
                Float medida = Float.parseFloat(measure.getValue());
                Float nuevaMedida = medida / new Float(1000);
                Integer medidaSegundos = (Integer) Math.round(nuevaMedida);
                if (medidaSegundos == 0) {
                    medidaSegundos = 1;
                }
                measure.setValue(Integer.toString(medidaSegundos));
            }
        }
        for (ServiceMetric sm : mmd.getServiceMetrics()) {
            for (Measure measure : sm.getMeasures()) {
                Float medida = Float.parseFloat(measure.getValue());
                Float nuevaMedida = medida / new Float(1000);
                Integer medidaSegundos = (Integer) Math.round(nuevaMedida);
                if (medidaSegundos == 0) {
                    medidaSegundos = 1;
                }
                measure.setValue(Integer.toString(medidaSegundos));
            }
        }
        System.out.println(mmd.toString());
        return mmd;
    }

    private Integer mediaAritmetica(Collection<Integer> numeros) {
        if (numeros.size() == 0) {
            return -1;
        }
        Integer media = 0;
        for (Integer numero : numeros) {
            media += numero;
        }
        return media / numeros.size();
    }
}
