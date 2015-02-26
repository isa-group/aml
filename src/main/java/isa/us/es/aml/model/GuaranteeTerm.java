package isa.us.es.aml.model;


/**
 * @author jdelafuente
 *
 */
public class GuaranteeTerm extends AgreementElement implements Comparable<GuaranteeTerm> {
	
	private Actor actor;
	private SLO slo;
	
	public GuaranteeTerm(String id, Actor actor, SLO slo) {
		super(id);
		this.actor = actor;
		this.slo = slo;
	}
	
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public SLO getSlo() {
		return slo;
	}

	public void setSlo(SLO slo) {
		this.slo = slo;
	}
	
	@Override
	public String toString() {
		return getId() + ": " + getActor() + " guarantees " + getSlo().toString() + ";";
	}

	@Override
	public int compareTo(GuaranteeTerm o) {
		return this.getId().compareTo(o.getId());
	}

}
