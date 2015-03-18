package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class GuaranteeTerm extends AgreementElement implements
		Comparable<GuaranteeTerm> {

	private ServiceRole actor;
	private SLO slo;
	private String serviceScope;
	private QualifyingCondition qc;
	private List<Compensation> compensations = new ArrayList<Compensation>();
	
	public GuaranteeTerm(String id) {
		super(id);
	}

	public GuaranteeTerm(String id, ServiceRole actor, SLO slo) {
		super(id);
		this.actor = actor;
		this.slo = slo;
	}


	public GuaranteeTerm(String id, ServiceRole actor, SLO slo,
			QualifyingCondition qc, List<Compensation> compensations,
			String serviceScope) {
		super(id);
		this.actor = actor;
		this.slo = slo;
		this.serviceScope = serviceScope;
		this.qc = qc;
		this.compensations = compensations;
	}

	public ServiceRole getServiceRole() {
		return this.actor;
	}

	public void setServiceRole(ServiceRole actor) {
		this.actor = actor;
	}

	public SLO getSlo() {
		return this.slo;
	}

	public void setSlo(SLO slo) {
		this.slo = slo;
	}

	public String getServiceScope() {
		return serviceScope;
	}

	public void setServiceScope(String serviceScope) {
		this.serviceScope = serviceScope;
	}

	public QualifyingCondition getQc() {
		return qc;
	}

	public void setQc(QualifyingCondition qc) {
		this.qc = qc;
	}

	public List<Compensation> getCompensations() {
		return compensations;
	}

	public void setCompensations(List<Compensation> compensations) {
		this.compensations = compensations;
	}

	@Override
	public int compareTo(GuaranteeTerm o) {
		return getId().compareTo(o.getId());
	}
}
