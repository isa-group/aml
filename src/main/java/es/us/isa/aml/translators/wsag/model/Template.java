/**
 *
 */
package es.us.isa.aml.translators.wsag.model;

/**
 * @author jdelafuente
 *
 */
public class Template extends Document {

    /**
     * These are OPTIONAL elements that provide constraints on the values that
     * the various terms may take in a concrete agreement.
     */
    private CreationConstraints creationConstraints;

    public Template() {
        super();
        creationConstraints = new CreationConstraints();
    }

    /**
     * @return the creationConstraints
     */
    public CreationConstraints getCreationConstraints() {
        return creationConstraints;
    }

    /**
     * @param creationConstraints the creationConstraints to set
     */
    public void setCreationConstraints(CreationConstraints creationConstraints) {
        this.creationConstraints = creationConstraints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding = \"UTF-8\"?>").append("\n");
        sb.append("<wsag:Template wsag:TemplateId=\"").append(getId()).append("\"").append("\n")
                .append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"").append("\n")
                .append("xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\"").append("\n")
                .append("xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"").append("\n")
                .append("xmlns:iag=\"http://www.isa.us.es/schemas/iagree\"").append("\n")
                .append("xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\"").append("\n")
                .append("agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\">").append("\n");
        sb.append("\t" + "<wsag:Name>").append(getName()).append("</wsag:Name>").append("\n");
        sb.append(getContext().toString());
        sb.append(getTerms().toString());
        sb.append(getCreationConstraints().toString());
        sb.append("</wsag:Template>");

        return sb.toString();
    }

}
