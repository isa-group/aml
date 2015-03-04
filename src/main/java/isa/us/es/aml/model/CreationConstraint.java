package isa.us.es.aml.model;

/**
 * @author jdelafuente
 *
 */
public class CreationConstraint extends AgreementElement {

    private SLO slo;

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
}
