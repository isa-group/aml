/**
 * 
 */
package es.us.isa.aml.translators.wsag.model;

/**
 * @author jdelafuente
 *
 */
public class Agreement extends Document {

	@Override
	public String toString() {
		return "<wsag:Agreement wsag:AgreementId=\""
				+ getId()
				+ "\" "
				+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
				+ "xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n"
				+ "xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n"
				+ "xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n"
				+ "agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\">"
				+ "\n" + "\t" + "<wsag:Name>" + getName() + "</wsag:Name>"
				+ "\n" + getContext().toString() + "\n" + getTerms().toString()
				+ "</wsag:Terms>" + "\n" + "</wsag:Agreement>";
	}

}
