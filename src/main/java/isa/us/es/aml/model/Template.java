package isa.us.es.aml.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jdelafuente
 *
 */
public class Template extends AgreementModel {
	

	List<CreationConstraint> creationConstraints;
	
	
	public Template() {
		super();
		creationConstraints = new ArrayList<CreationConstraint>();
	}
	
	public List<CreationConstraint> getCreationConstraints() {
		return creationConstraints;
	}
	public void setCreationConstraints(List<CreationConstraint> creationConstraints) {
		this.creationConstraints = creationConstraints;		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Template " + getID() + " version " + getVersion() + "\n");
		sb.append("\t" + getResponder() + " as Responder" + "\n");
		
		sb.append("\t" + "Metrics:" + "\n");
		
		List<Metric> metrics =  getMetrics();
		for(Metric metric : metrics)
			sb.append("\t\t" + metric.toString() + "\n");
		
		sb.append(getAgreementTerms().toString());
		
		sb.append("\n" + "CreationConstraints" + "\n");
		for(CreationConstraint cc : getCreationConstraints())
			sb.append("\t" + cc.toString() +"\n");
	
		
		sb.append("\n" + "EndTemplate");
		
		return sb.toString();
	}
}
