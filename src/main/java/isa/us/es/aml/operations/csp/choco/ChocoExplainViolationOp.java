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
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import choco.kernel.model.variables.integer.IntegerVariable;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AbstractDocument;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.AgreementElement;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.document.Range;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.errors.AgreementError;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.errors.Explanation;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.errors.PropertyState;
import com.tfg.adaaslibrary.adaintegration.adaadhoc.ada.operations.ExplainAgreementViolation;
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
import java.util.LinkedList;
import java.util.Map;

public class ChocoExplainViolationOp extends ChocoQuickxplainNoComplianceOp implements
        ExplainAgreementViolation {

    private MonitoringManagementDocument mmd;

    @Override
    public void execute(ChocoAnalyzer an) {
        explanations = new HashMap<AgreementError, Explanation>();
        if (docs.size() == 1 && mmd != null) {
            AbstractDocument doc = docs.get(0);
            if (doc instanceof Agreement) {
                Agreement ag = (Agreement) doc;
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
                //comparamos
                if (agWSI != null && mmd != null && mmd.getWebServiceInformation().equals(agWSI)) {
                    //Si son iguales entonces seguimos
                    //Obtenemos el MMD con el GeneralResponseTime
                    this.mmd = getMMDConGeneralResponseTime(mmd);
                    //Aqu- no hace falta preprocesar el MMD porque ya se hace
                    //en checkAgreementFulfilment, que vamos a llamarla ahora
                    //comprobar si hay problemas
                    ChocoAgreementFulfilmentOp auxOp = new ChocoAgreementFulfilmentOp();
                    auxOp.setMMD(mmd);
                    auxOp.addDocument(ag);
                    an.analyze(auxOp);
                    boolean fulfilled = auxOp.isFulfilled();
                    Collection<ServiceScope> scopes = auxOp.getViolations();
                    if (!fulfilled) {
//						//Ahora si preprocesamos despues de haber llamado
//						//a agreementFulfilment, para as- tener tambi-n aqu-
//						//el MMD preprocesado
//						this.mmd = preprocesarMMD(mmd);
                        //y si los hay, explanations que te crio
                        //Sacamos del MMD las medidas del ServiceMetric y OperationMetric
                        //y creamos los AgreementState
                        Map<ServiceScope, AgreementState> agStates = new HashMap<ServiceScope, AgreementState>();
                        //Cargamos los OperationMetric primero para luego a-adir a cada Scope
                        //las medidas de los ServiceMetric
                        Collection<OperationMetric> operationMetrics = mmd.getOperationMetrics();
                        for (OperationMetric om : operationMetrics) {
                            for (Measure m : om.getMeasures()) {
                                ServiceScope scope = new ServiceScope();
                                scope.setContent(om.getOpName());
                                String varName = om.getMetric();
                                String value = m.getValue();
                                //Si el scope ya existe, sacamos el estado y le
                                //a-adimos la variable y el valor
                                if (agStates.keySet().contains(scope)) {
                                    AgreementState agState = agStates.get(scope);
                                    agState.putVariableValue(varName, value);
                                } else {//Sino existe, lo a-adimos a un state nuevo
                                    AgreementState agState = new AgreementStateImpl();
                                    agState.putVariableValue(varName, value);
                                    agStates.put(scope, agState);
                                }
                            }
                        }
                        //Cargamos los ServiceMetric
                        Collection<ServiceMetric> serviceMetrics = mmd.getServiceMetrics();
                        for (ServiceMetric sm : serviceMetrics) {
                            for (Measure m : sm.getMeasures()) {
                                String varName = sm.getMetric();
                                String value = m.getValue();
                                //Los serviceMetric tienen que ir en cada Scope, as- que
                                //recorremos los scopes y vamos a-adiendo la medida del 
                                //serviceMetric en el state que corresponde al scope
                                for (ServiceScope ss : agStates.keySet()) {
                                    AgreementState st = agStates.get(ss);
                                    st.putVariableValue(varName, value);
                                }
                            }
                        }
                        Collection<AbstractDocument> alternatives = getAlternatives(ag, an, false);
                        for (AbstractDocument alt : alternatives) {
                            Map<ServiceScope, AbstractDocument> views = super.getViews(alt, an);
//							Set<Entry<ServiceScope,AgreementState>> entries = state.entrySet();
                            for (ServiceScope ss : scopes) {
                                AbstractDocument view = views.get(ss);
                                if (view == null) {
                                    //El scope que busc-bamos es el scope por defecto, el
                                    //que engloba a las variables sin scope
                                    //En este caso, asignamos como doc al alternative, que
                                    //contiene todas las variables que haya en el state
                                    //y las que no est-n en el state se borrar-n luego
                                    view = alt;
                                }
                                AgreementState st = agStates.get(ss);
//								AgreementState st = e.getValue();
                                ChocoTranslator trans = new ChocoTranslator(view);
                                trans.translate();
                                Map<String, Variable> chocoVars = trans.getChocoVars();
                                //ahora pasamos a choco las constraints del estado
                                Map<AgreementElement, Constraint> states = state2Choco(chocoVars, st);
                                Map<AgreementElement, Constraint> agreementConstraints = trans.getChocoConstraints();
                                //Como en el documento de esta vista puede haber constraints
                                //que se refieran a variables que no est-n en este state,
                                //tenemos que borrarlas tambi-n
                                Collection<Constraint> col = agreementConstraints.values();
                                Collection<Constraint> constToBeDeleted = new LinkedList<Constraint>();
                                Collection<String> stateVars = st.getVariablesAsString();
                                for (Constraint auxCons : col) {
                                    Boolean deleteThisConstraint = true;
                                    for (Variable v : auxCons.extractVariables()) {
                                        String varName = v.toString().substring(0, v.toString().indexOf(" "));
                                        //Si alguna de las variables de la constraint coincide
                                        //con la variable del state, no la borramos
                                        if (stateVars.contains(varName)) {
                                            deleteThisConstraint = false;
                                        }
                                    }
                                    if (deleteThisConstraint) {
                                        constToBeDeleted.add(auxCons);
                                    }
                                }
                                //ahora las borramos
                                col.removeAll(constToBeDeleted);
                                Collection<Variable> usedVars = extractUsedVars(chocoVars.values(), agreementConstraints);
                                //XXX con esto tenemos los elementos que fallan en la oferta
                                //aun nos faltarian los que fallan en la plantilla
                                //1- opcion
                                Map<AgreementError, Explanation> res = quickxplain(usedVars, states, agreementConstraints);
                                if (level == ExplainAgreementViolation.REFINE_ALL) {
                                    res = refineAgreementErrors(res, states, agreementConstraints);
                                    res = refineExplanations(res, states, agreementConstraints);
                                } else {
                                    if (level == ExplainAgreementViolation.REFINE_OFFER) {
                                        res = refineAgreementErrors(res, states, agreementConstraints);
                                    } else if (level == ExplainAgreementViolation.REFINE_TEMPLATE) {
                                        res = refineExplanations(res, states, agreementConstraints);
                                    }
                                }
                                //Antes de meter los resultados, a cada agreementError
                                //lo a-adimos delante el nombre de su Scope
                                //as- se facilita la identificaci-n del error
                                //en el acuerdo
                                for (AgreementError ae : res.keySet()) {
                                    for (AgreementElement aElem : ae.getElements()) {
                                        String name = aElem.getName();
                                        aElem.setName(ss.getContent() + "-" + name);
                                    }
                                }
                                explanations.putAll(res);
                            }
//							Iterator<Entry<ServiceScope,AgreementState>> it = entries.iterator();
//							
//							while (it.hasNext()){
//								Entry<ServiceScope,AgreementState> e = it.next();
//								AbstractDocument view = views.get(e.getKey());
//								
////								ChocoAgreementFulfilmentOp auxOp = new ChocoAgreementFulfilmentOp();
////								Map<ServiceScope,AgreementState> auxMap = new HashMap<ServiceScope, AgreementState>();
////								auxMap.put(new GeneralServiceScope(), e.getValue());
////								auxOp.setState(auxMap);
////								auxOp.addDocument(view);
////								an.analyze(auxOp);
////								boolean fulfilled = auxOp.isFulfilled();
//								
////								if (!fulfilled){
//									AgreementState st = e.getValue();
//									
//									ChocoTranslator trans = new ChocoTranslator(view);
//									trans.translate();
//									Map<String,Variable> chocoVars = trans.getChocoVars();
//									
//									//ahora pasamos a choco las constraints del estado
//									Map<AgreementElement,Constraint> states = state2Choco(chocoVars, st);
//									
//									
//									Map<AgreementElement, Constraint> agreementConstraints = trans.getChocoConstraints();
//									Collection<Variable> usedVars = extractUsedVars(chocoVars.values(),agreementConstraints);
//									//XXX con esto tenemos los elementos que fallan en la oferta
//									//aun nos faltarian los que fallan en la plantilla
//									//1- opcion
//									Map<AgreementError,Explanation> res = quickxplain(usedVars, states, agreementConstraints);
//									if (level == ExplainAgreementViolation.REFINE_ALL){
//										res = refineAgreementErrors(res, states, agreementConstraints);
//										res = refineExplanations(res, states, agreementConstraints);
//									}
//									else{
//										if (level == ExplainAgreementViolation.REFINE_OFFER){
//											res = refineAgreementErrors(res, states, agreementConstraints);
//										}
//										else if (level == ExplainAgreementViolation.REFINE_TEMPLATE){
//											res = refineExplanations(res, states, agreementConstraints);
//										}
//									}
//									explanations.putAll(res);
////								}
//							}
                        }
                    }
                }
            }
        }
    }

    private Map<AgreementElement, Constraint> state2Choco(Map<String, Variable> vars,
            AgreementState st) {
        Map<AgreementElement, Constraint> res = new HashMap<AgreementElement, Constraint>();
        Collection<PropertyState> stateVars = st.getStates();
//		Constraint[] stateCons = new Constraint[stateVars.size()];
        for (PropertyState prop : stateVars) {
            //por cada variable
            String var = prop.getName();
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
            res.put(prop, c);
        }
        return res;
    }

    @Override
    public Map<AgreementError, Explanation> explainViolation() {
        return this.explanations;
    }

    @Override
    public void setMMD(MonitoringManagementDocument mmd) {
        this.mmd = mmd;
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
