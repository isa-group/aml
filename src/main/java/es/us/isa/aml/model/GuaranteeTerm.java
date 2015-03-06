package es.us.isa.aml.model;

/**
 * @author jdelafuente
 *
 */
public class GuaranteeTerm extends AgreementElement implements Comparable<GuaranteeTerm> {

    private Actor actor;
    private SLO slo;
    private QualifyingCondition qc;

    public GuaranteeTerm(String id, Actor actor, SLO slo) {
        super(id);
        this.actor = actor;
        this.slo = slo;
    }

    public GuaranteeTerm(String id, Actor actor, SLO slo, QualifyingCondition qc) {
        super(id);
        this.actor = actor;
        this.slo = slo;
        this.qc = qc;
    }

    public Actor getActor() {
        return this.actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public SLO getSlo() {
        return this.slo;
    }

    public void setSlo(SLO slo) {
        this.slo = slo;
    }

    public QualifyingCondition getQc() {
        return qc;
    }

    public void setQc(QualifyingCondition qc) {
        this.qc = qc;
    }

    @Override
    public int compareTo(GuaranteeTerm o) {
        return getId().compareTo(o.getId());
    }

}
