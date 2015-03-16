package es.us.isa.aml.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class GuaranteeTerm extends AgreementElement implements
        Comparable<GuaranteeTerm> {

    private Actor actor;
    private SLO slo;
    private String serviceScope;
    private QualifyingCondition qc;
    private List<Compensation> compensations;

    public GuaranteeTerm(String id, Actor actor, SLO slo) {
        super(id);
        this.actor = actor;
        this.slo = slo;
        serviceScope = "";
        qc = null;
        compensations = new ArrayList<>();
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
