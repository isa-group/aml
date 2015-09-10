/**
 * 
 */
package es.us.isa.aml.generator;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.RoleType;
import es.us.isa.aml.util.DocType;

/**
 * @author jdelafuente
 *
 */
public class BasicAgreementGenerator extends AgreementGenerator {

	@Override
	public AgreementOffer generateAgreementOfferFromTemplate(
			String consumerName, AgreementTemplate template) {
		AgreementOffer ao = new AgreementOffer();
		ao.setDocType(DocType.OFFER);
		ao.setID(template.getID() + "_" + consumerName);
		ao.setVersion(template.getVersion());
		ao.setContext(template.getContext().clone());
		ao.getContext().setTemplateId(template.getID());
		ao.getContext().setTemplateVersion(template.getVersion());
		ao.getContext().setInitiator(
				new Actor(consumerName, Role.Consumer, RoleType.Initiator));
		ao.setAgreementTerms(template.getAgreementTerms().clone());
		return ao;
	}

	@Override
	public Agreement generateAgreementFromAgreementOffer(String consumerName,
			AgreementOffer offer) {
		Agreement ag = new Agreement();
		ag.setDocType(DocType.AGREEMENT);
		ag.setID(offer.getID() + "_ag");
		ag.setVersion(offer.getVersion());
		ag.setContext(offer.getContext().clone());
		ag.getContext().setInitiator(
				new Actor(consumerName, Role.Consumer, RoleType.Initiator));
		ag.setAgreementTerms(offer.getAgreementTerms().clone());
		return ag;
	}

}
