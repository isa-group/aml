package es.us.isa.aml.model;

/**
 * @author jdelafuente
 *
 */
public class CreationConstraint extends AgreementElement {

    private SLO slo;
    private QualifyingCondition qc;

    public CreationConstraint(String id, SLO slo) {
        super(id);
        this.slo = slo;
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
}
