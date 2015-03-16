/**
 * 
 */
package es.us.isa.aml.parsers.agreements.wsag;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.us.isa.aml.parsers.agreements.iagree.iAgreeParser;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class WsagParserHelper {
	
	private Document doc;
	
	public WsagParserHelper(Document doc) {
		this.doc = doc;
	}

	public String getContext() {
		String result = "";

		Node nodeTempName = doc.getElementsByTagName("wsag:TemplateName").item(
				0);
		if (nodeTempName != null) {
			String templateName = nodeTempName.getTextContent();
			result += " for " + templateName;
		}

		Node nodeTempId = doc.getElementsByTagName("wsag:TemplateId").item(0);
		if (nodeTempId != null) {
			String templateId = nodeTempId.getTextContent();
			result += " "
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.VERSION])
					+ " " + templateId + "\n";
		}

		Node responder = doc.getElementsByTagName("wsag:AgreementResponder")
				.item(0);
		if (responder != null)
			result += "\t"
					+ responder.getTextContent()
					+ " "
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.AS])
					+ " "
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.RESPONDER])
					+ "\n";

		Node dateFormat = doc.getElementsByTagName("twsag4people:DateFormat")
				.item(0);
		if (dateFormat != null)
			result += "\tDateFormat: " + dateFormat.getTextContent() + "\n";

		Node GMTZone = doc.getElementsByTagName("wsag:GMTZone").item(0);
		if (GMTZone != null)
			result += "\tGMTZone: " + GMTZone.getTextContent() + "\n";

		Node GlobalPeriod = doc.getElementsByTagName(
				"twsag4people:GlobalPeriod").item(0);
		if (GlobalPeriod != null)
			result += "\tGlobalPeriod: " + GlobalPeriod.getTextContent() + "\n";

		return result;
	}

	public String getMetrics() {
		String result = Util
				.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.METRICS])
				+ ':' + "\n";

		NodeList nList = doc.getElementsByTagName("met:metric");

		for (int i = 0; i < nList.getLength(); i++) {
			Element node = (Element) nList.item(i);
			String nodeId = node.getAttribute("id");
			String nodeType = node.getAttribute("type");
			if (!nodeId.equals("boolean")) {

				if (nodeType.equals("integer")) {
					result += "\t\t" + nodeId + ": " + nodeType;
					String min = node.getAttribute("min");
					String max = node.getAttribute("max");
					result += "[" + min + ".." + max + "]\n";
				} else if (nodeType.equals("enumerated")) {
					result += "\t\t" + nodeId + ":  set"; // Si es "enumerated"
															// hay que usar
															// "set"
					NodeList values = node.getElementsByTagName("met:value");
					Element value = (Element) values.item(0);
					if (value != null)
						result += " {" + value.getAttribute("value");
					for (int j = 1; j < values.getLength(); j++) {
						value = (Element) values.item(j);
						result += ", " + value.getAttribute("value");
					}
					result += "}\n";
				}
			}
		}
		return result;
	}

	public String getAgreementTerms() {
		Element service = (Element) doc.getElementsByTagName("wsag:Terms")
				.item(0);
		String result = Util
				.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.AGREEMENT_TERMS])
				+ "\n\t"
				+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.SERVICE])
				+ " " + service.getAttribute("wsag:Name") + " ";

		Node serviceReference = doc.getElementsByTagName(
				"wsag:ServiceReference").item(0);
		if (serviceReference != null) {
			result += Util
					.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.AVAL_AT])
					+ " \"" + serviceReference.getTextContent() + "\"";
		}

		Node globalDescription = doc.getElementsByTagName(
				"wsag:ServiceDescriptionTerm").item(0);
		if (globalDescription != null) {
			result += "\n\t\t"
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.GLOBALDESCRIPTION]);

			NodeList nList = doc.getElementsByTagName("OfferItem");

			for (int i = 0; i < nList.getLength(); i++) {
				Element node = (Element) nList.item(i);

				result += "\n\t\t\t" + node.getAttribute("name") + ':';

				String type = node.getAttribute("wsag:Metric");
				String[] aux = type.split(":");
				result += " " + aux[1];

				String value = node.getTextContent();

				if (aux[1].equals("boolean"))
					value = value.toLowerCase();

				if (!node.getTextContent().isEmpty()) {
					result += " "
							+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.EQ])
							+ " " + value + ';';
				}
			}
		}

		Node monitorableProps = doc.getElementsByTagName(
				"wsag:ServiceProperties").item(0);
		if (monitorableProps != null) {
			result += "\n\n\t"
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.MONITORABLEPROPERTIES])
					+ "\n\t\t";

			NodeList nList = doc.getElementsByTagName("wsag:Variable");
			if (nList != null) {

				result += Util
						.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.GLOBAL]) + ':';

				for (int i = 0; i < nList.getLength(); i++) {
					Element node = (Element) nList.item(i);

					result += "\n\t\t\t" + node.getAttribute("wsag:Name") + ':';

					String type = node.getAttribute("wsag:Metric");
					String[] aux = type.split(":");
					result += " " + aux[1];
				}
			}

			NodeList guaranteeTerms = doc
					.getElementsByTagName("wsag:GuaranteeTerm");
			if (guaranteeTerms != null) {
				result += "\n\n\t\t"
						+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.GUARANTEE_TERMS]);
				for (int i = 0; i < guaranteeTerms.getLength(); i++) {

					Element node = (Element) guaranteeTerms.item(i);

					if (!node.getParentNode().getNodeName().equals("wsag:All")) {

						String gName = node.getAttribute("wsag:Name");
						String name = gName.substring(0, gName.indexOf("."));

						if (!result.contains(name)) {
							result += "\n\t\t\t"
									+ name
									+ ':'
									+ "\t"
									+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONE_OR_MORE])
									+ " "
									+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.OF]);
						}

						result += "\n\t\t\t\t" + node.getAttribute("wsag:Name")
								+ ':';
					} else {
						result += "\n\t\t\t" + node.getAttribute("wsag:Name")
								+ ':';
					}

					String csl = node
							.getElementsByTagName("wsag:CustomServiceLevel")
							.item(0).getTextContent();
					if (csl.contains("True") || csl.contains("False")) {
						csl = csl.replace("\"", "");
						csl = csl.replace("True", "true").replace("False",
								"false");
					}

					Node qualifCond = node.getElementsByTagName(
							"wsag:QualifyingCondition").item(0);

					if (qualifCond != null) {
						String qc = qualifCond.getTextContent();
						if (qc.contains("True") || qc.contains("False")) {
							qc = qc.replace("\"", "");
							qc = qc.replace("True", "true").replace("False",
									"false");
						}
						qc = qc.trim().replace("(", "").replace(")", "");

						if (qc.contains("OR")) {
							//qc = getBelongsExp(qc);
						}

						result += "\t"
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.PROVIDER])
								+ " "
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.GUARANTEES])
								+ " "
								+ Util.decodeEntities(csl)
								+ ";\n"
								+ "\t\t\t\t"
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF])
								+ " (" + qc + ");\n";
					} else {
						result += "\t"
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.PROVIDER])
								+ " "
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.GUARANTEES])
								+ " " + Util.decodeEntities(csl) + ";\n";
					}

					NodeList compensation = node
							.getElementsByTagName("wsag:BusinessValueList");

					for (int j = 0; j < compensation.getLength(); j++) {

						Element comp = (Element) compensation.item(j);

						String compType = "";

						Node nCompTypePenalty = comp.getElementsByTagName(
								"wsag:Penalty").item(0);
						Node nCompTypeReward = node.getElementsByTagName(
								"wsag:Reward").item(0);

						if (nCompTypePenalty != null) {
							compType = "penalty";
						} else if (nCompTypeReward != null) {
							compType = "reward";
						}

						Node nTimeInterval = comp.getElementsByTagName(
								"wsag:TimeInterval").item(0);
						String interval = nTimeInterval.getTextContent();

						result += "\t\t\t\t"
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.WITH])
								+ " " + interval + " " + compType + "\n";

						NodeList valueExprs = comp
								.getElementsByTagName("wsag:ValueExpr");

						for (int k = 0; k < valueExprs.getLength(); k++) {
							Element valueExpr = (Element) valueExprs.item(k);
							result += "\t\t\t\t\t"
									+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.OF])
									+ " "
									+ Util.decodeEntities(valueExpr
											.getTextContent()) + ';' + "\n";
						}

						result += "\t\t\t\tend\n";
					}
				}
			}
		}

		return result;
	}

	public String getCreationConstraints() {

		String result = "";

		Element cc = (Element) doc.getElementsByTagName(
				"wsag:CreationConstraints").item(0);

		if (cc != null && !cc.getTextContent().isEmpty()) {
			result += Util
					.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.CREATION_CONSTRAINTS]);

			NodeList nList = cc.getElementsByTagName("wsag:Constraint");

			for (int i = 0; i < nList.getLength(); i++) {
				Element constraint = (Element) nList.item(i);
				result += "\n\t"
						+ constraint.getElementsByTagName("Name").item(0)
								.getTextContent() + ":";

				String content = constraint.getElementsByTagName("Content")
						.item(0).getTextContent();

				if (content.contains("IMPLIES")) {
					String[] aux = content.split("IMPLIES");
					String exp1 = aux[0].trim();
					if (exp1.contains("True") || exp1.contains("False")) {
						exp1 = exp1.replace("\"", "");
						exp1 = exp1.replace("True", "true").replace("False",
								"false");
					}
					String exp2 = aux[1].trim();
					if (exp2.contains("True") || exp2.contains("False")) {
						exp2 = exp2.replace("\"", "");
						exp2 = exp2.replace("True", "true").replace("False",
								"false");
					}

					if (exp2.contains("OR")) {
//						exp2 = getBelongsExp(exp2);
					}

					result += Util.decodeEntities(exp2) + ";" + "\n";

					result += "\t\t"
							+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF])
							+ " (" + Util.decodeEntities(exp1) + ");\n";

				} else if (content.contains("OR")) {
					result += "\t"; //+ getBelongsExp(content) + ";\n";
				} else {
					result += "\t" + Util.decodeEntities(content.trim())
							+ ";\n";
				}
			}
		}

		return result;
	}

}
