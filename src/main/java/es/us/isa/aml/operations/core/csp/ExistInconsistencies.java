package es.us.isa.aml.operations.core.csp;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.csp.CSPModel;
import es.us.isa.aml.operations.core.CoreOperation;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.util.OperationResponse;
import es.us.isa.aml.util.ReasonerFactory;

/**
 * Core operation that determines if an agreement model contains inconsistencies.
 * 
 * @author jdelafuente
 *
 */
public class ExistInconsistencies extends CoreOperation {

	public ExistInconsistencies() {
		this.reasoner = ReasonerFactory.createCSPReasoner();
	}

	public void analyze(AgreementModel agModel) {
		Translator translator = new Translator(new CSPBuilder());
		CSPModel model = (CSPModel) translator.translate(agModel);

		Boolean solve = this.reasoner.solve(model);
		if (solve != null) {
			result.put("existInconsistencies", !solve);
			OperationResponse res = reasoner.explain(model);
			result.putAll(res);
		} else
			result.put("existInconsistencies", null);
	}

	@Override
	public OperationResponse getResult() {
		return this.result;
	}
}
