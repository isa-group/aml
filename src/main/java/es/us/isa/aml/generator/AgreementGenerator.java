/**
 * 
 */
package es.us.isa.aml.generator;

import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;

/**
 * @author jdelafuente
 *
 */
public abstract class AgreementGenerator {

	public abstract AgreementOffer generateAgreementOfferFromTemplate(
			String consumerName, AgreementTemplate template);

	public abstract Agreement generateAgreementFromAgreementOffer(String consumerName, AgreementOffer offer);

}
