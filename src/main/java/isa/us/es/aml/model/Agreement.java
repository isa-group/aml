package isa.us.es.aml.model;

import java.util.List;



/**
 * @author jdelafuente
 *
 */
public class Agreement extends AgreementModel {
	
	
	public Agreement() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Agreement " + getID() + " version " + getVersion() + "\n");
		sb.append("\t" + getResponder() + " as Responder" + "\n");
		
		sb.append("\t" + "Metrics:" + "\n");
		
		List<Metric> metrics =  getMetrics();
		for(Metric metric : metrics)
			sb.append("\t\t" + metric.toString() + "\n");
		
		sb.append(getAgreementTerms().toString());
		
		sb.append("\n" + "EndAgreement");
		
		return sb.toString();
	}


}
