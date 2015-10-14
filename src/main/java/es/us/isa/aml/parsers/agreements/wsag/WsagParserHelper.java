/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.parsers.agreements.wsag;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.us.isa.aml.model.Actor;
import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.ConfigurationProperty;
import es.us.isa.aml.model.Context;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.Domain;
import es.us.isa.aml.model.Enumerated;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.Metric;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.model.QualifyingCondition;
import es.us.isa.aml.model.Range;
import es.us.isa.aml.model.Role;
import es.us.isa.aml.model.RoleType;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.expression.Atomic;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.model.expression.LogicalExpression;
import es.us.isa.aml.model.expression.LogicalOperator;
import es.us.isa.aml.model.expression.RelationalExpression;
import es.us.isa.aml.model.expression.RelationalOperator;
import es.us.isa.aml.model.expression.Var;
import es.us.isa.aml.translator.builders.wsag.model.AgreementRole;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;

/**
 * @author jdelafuente
 *
 */
public class WsagParserHelper {

	private final Document doc;
	private File[] metrics;
	private AgreementModel model;

	private Boolean new_version;

	public WsagParserHelper(Document doc, File[] metrics) {
		this.doc = doc;
		this.metrics = metrics;
	}

	public AgreementModel getModel() {
		createModel();
		return model;
	}

	public void createModel() {
		Node template = doc.getElementsByTagName("wsag:Template").item(0);
		Node offer = doc.getElementsByTagName("wsag:AgreementOffer").item(0);
		Node agreement = doc.getElementsByTagName("wsag:Agreement").item(0);
		Double version = null;

		if (template != null) {
			model = new AgreementTemplate();
			Element temp = (Element) template;
			version = Double.valueOf(temp.getAttribute("wsag:TemplateId"));
			model.setVersion(version);
		} else if (offer != null) {
			model = new AgreementOffer();
			Element agoffer = (Element) offer;
			String offer_id = agoffer.getAttribute("wsag:AgreementOfferId");
			if (offer_id.isEmpty()) {
				new_version = false;
				version = Double.valueOf(agoffer
						.getAttribute("wsag:AgreementId"));
			} else {
				new_version = true;
				version = Double.valueOf(offer_id);
			}
			model.setVersion(version);
		} else if (agreement != null) {
			model = new Agreement();
			Element ag = (Element) agreement;
			version = Double.valueOf(ag.getAttribute("wsag:AgreementId"));
			model.setVersion(version);
		}

		Node name = doc.getElementsByTagName("wsag:Name").item(0);
		if (name != null) {
			model.setID(name.getTextContent().trim());
		}

		setContext();
		setAgreementTerms();
		if (model.getDocType() == DocType.TEMPLATE) {
			setCreationConstraints();
		}
	}

	public void setContext() {
		Context context = new Context();

		Node temp_id = doc.getElementsByTagName("wsag:TemplateId").item(0);
		if (temp_id != null && temp_id instanceof Element) {
			Element templateId = (Element) temp_id;
			String str_tempId = templateId.getTextContent().trim();
			if (str_tempId.isEmpty()) {
				// TODO throw exception
			} else {
				context.setTemplateVersion(Double.valueOf(str_tempId));
			}
		}

		Node temp_name = doc.getElementsByTagName("wsag:TemplateName").item(0);
		if (temp_name != null && temp_name instanceof Element) {
			Element tempName = (Element) temp_name;
			context.setTemplateId(tempName.getTextContent().trim());
		}

		AgreementRole provider = null;
		Node serviceProvider = doc.getElementsByTagName("wsag:ServiceProvider")
				.item(0);
		if (serviceProvider != null && serviceProvider instanceof Element) {
			provider = AgreementRole.valueOf(serviceProvider.getTextContent()
					.trim());
		}

		Node initiator = doc.getElementsByTagName("wsag:AgreementInitiator")
				.item(0);
		if (initiator != null && initiator instanceof Element) {
			Actor a = new Actor();
			new_version = true;
			a.setId(initiator.getTextContent().trim());
			if (provider == AgreementRole.Initiator)
				a.setRole(Role.Provider);
			else
				a.setRole(Role.Consumer);
			a.setRoleType(RoleType.Initiator);
			context.setInitiator(a);
		}

		Node responder = doc.getElementsByTagName("wsag:AgreementResponder")
				.item(0);
		if (responder != null && responder instanceof Element) {
			Actor a = new Actor();
			new_version = true;
			a.setId(responder.getTextContent().trim());
			if (provider == AgreementRole.Responder)
				a.setRole(Role.Provider);
			else
				a.setRole(Role.Consumer);
			a.setRoleType(RoleType.Responder);
			context.setResponder(a);
		}

		if (new_version) {
			Node node_metrics = doc.getElementsByTagName("iag:Metrics").item(0);
			NodeList metrics = node_metrics.getChildNodes();
			for (int i = 0; i < metrics.getLength(); i++) {
				Node node_metric = (Node) (metrics.item(i));
				if (node_metric.getNodeType() == Node.ELEMENT_NODE) {
					Element metric = (Element) node_metric;
					String id = metric.getAttribute("id");
					String type = metric.getAttribute("type");
					String domain = metric.getAttribute("domain");

					Metric m = new Metric(id);
					m.setType(type);

					Domain d = new Domain();
					if (domain.contains("..")) {
						String[] args = domain.replace("[", "")
								.replace("]", "").split("\\.\\.");
						Integer min = Integer.valueOf(args[0]);
						Integer max = Integer.valueOf(args[1]);
						d = new Range(min, max);
					} else {
						String[] args = domain.replace("{", "")
								.replace("}", "").split(", ");
						d = new Enumerated(args);
					}
					m.setDomain(d);
					context.getMetrics().put(id, m);
				}
			}
		}

		model.setContext(context);
	}

	public void setAgreementTerms() {
		Node node_terms = doc.getElementsByTagName("wsag:Terms").item(0);

		String name = ((Element) node_terms).getAttribute("wsag:Name");
		model.getAgreementTerms().getService().setServiceName(name);

		NodeList nList = node_terms.getChildNodes();
		Node node_allterms = null;
		for (int i = 0; i < nList.getLength(); i++) {
			Node attemp = (Node) (nList.item(i));
			if (attemp.getNodeType() == Node.ELEMENT_NODE) {
				node_allterms = attemp;
				break;
			}
		}

		setTerms(node_allterms);
	}

	private void setTerms(Node node_allterms) {
		NodeList terms = node_allterms.getChildNodes();
		for (int i = 0; i < terms.getLength(); i++) {
			Node node_term = (Node) (terms.item(i));
			if (node_term instanceof Element) {
				Element term = (Element) node_term;

				if (term.getTagName().equals("wsag:ServiceDescriptionTerm")) {

					if (new_version) {
						String serviceReference = term
								.getAttribute("iag:ServiceReference");
						model.getAgreementTerms().getService()
								.setEndpointReference(serviceReference);
					}

					NodeList offer_items = term.getChildNodes();
					for (int j = 0; j < offer_items.getLength(); j++) {
						Node node_oi = (Node) (offer_items.item(j));
						if (node_oi instanceof Element) {
							Element offer_item = (Element) node_oi;
							String id = offer_item.getAttribute("name");

							ConfigurationProperty p = new ConfigurationProperty(
									id);

							if (new_version) {
								String metric_id = offer_item
										.getAttribute("iag:Metric");
								Metric m = model.getContext().getMetrics()
										.get(metric_id);
								p.setMetric(m);
							} else {
								String metric = offer_item
										.getAttribute("wsag:Metric");
								String[] aux = metric.split(":");
								String path = aux[0] + ".xml";
								String metric_id = aux[1];

								setMetric(metric_id, path);
								p.setMetric(model.getContext().getMetrics()
										.get(metric_id));
							}

							if (!offer_item.getTextContent().trim().isEmpty()) {
								Expression exp = Expression.parse(offer_item
										.getTextContent().trim());
								p.setExpression(exp);
							}

							model.getAgreementTerms().getService()
									.getConfigurationProperties()
									.put(p.getId(), p);
						}
					}
				} else if (term.getTagName().equals("wsag:ServiceProperties")) {

					NodeList variables = term
							.getElementsByTagName("wsag:Variable");
					for (int j = 0; j < variables.getLength(); j++) {
						Node node_v = (Node) (variables.item(j));
						if (node_v instanceof Element) {
							Element variable = (Element) node_v;
							String id = variable.getAttribute("wsag:Name");

							MonitorableProperty p = new MonitorableProperty(id);

							if (new_version) {
								String metric_id = variable
										.getAttribute("iag:Metric");
								Metric m = model.getContext().getMetrics()
										.get(metric_id);
								p.setMetric(m);
							} else {
								String metric = variable
										.getAttribute("wsag:Metric");
								String[] aux = metric.split(":");
								String path = aux[0] + ".xml";
								String metric_id = aux[1];

								setMetric(metric_id, path);
								p.setMetric(model.getContext().getMetrics()
										.get(metric_id));
							}
							if (new_version
									&& variable.getElementsByTagName(
											"wsag:Location").item(0) != null) {
								Node location = variable.getElementsByTagName(
										"wsag:Location").item(0);
								p.setExpression(Expression.parse(location
										.getTextContent()));
							}

							model.getAgreementTerms()
									.getMonitorableProperties()
									.put(p.getId(), p);
						}
					}

				} else if (term.getTagName().equals("wsag:GuaranteeTerm")) {
					if (term instanceof Element) {
						Element gt_element = (Element) term;
						String id = gt_element.getAttribute("wsag:Name");
						String ob = gt_element.getAttribute("wsag:Obligated");

						ob = ob.replaceAll("\\bServiceProvider\\b", "Provider");
						ob = ob.replaceAll("\\bServiceConsumer\\b", "Consumer");

						GuaranteeTerm GT = new GuaranteeTerm(id);
						GT.setRole(Role.valueOf(ob));

						NodeList nList2 = gt_element.getChildNodes();
						for (int j = 0; j < nList2.getLength(); j++) {
							Node node_prop = (Node) (nList2.item(j));
							if (node_prop instanceof Element) {
								Element prop = (Element) node_prop;
								if (prop.getTagName().equals(
										"wsag:QualifyingCondition")) {
									String aux = prop.getTextContent().trim();
									if (aux.contains("NOT")) {
										aux = "NOT ("
												+ aux.substring(aux
														.indexOf("NOT") + 3)
												+ ")";
									}
									Expression cond = Expression.parse(Util
											.decodeEntities(aux));
									QualifyingCondition qc = new QualifyingCondition(
											cond);
									GT.setQc(qc);
								} else if (prop.getTagName().equals(
										"wsag:ServiceLevelObjective")) {
									String aux = prop.getTextContent().trim();
									if (aux.contains("NOT")) {
										aux = "NOT ("
												+ aux.substring(aux
														.indexOf("NOT") + 3)
												+ ")";
									}
									Expression exp = Expression.parse(Util
											.decodeEntities(aux));
									SLO slo = new SLO(exp);
									GT.setSlo(slo);
								}
							}
						}

						model.getAgreementTerms().getGuaranteeTerms()
								.put(GT.getId(), GT);
					}

				} else if (term.getTagName().equals("wsag:ExactlyOne")
						|| term.getTagName().equals("wsag:OneOrMore")) {
					setTerms(term);
				}

			}
		}
	}

	public void setCreationConstraints() {
		NodeList nodeList = doc
				.getElementsByTagName("wsag:CreationConstraints");
		if (nodeList.getLength() > 0) {
			Node ccs = nodeList.item(0);
			NodeList nList = ccs.getChildNodes();
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = (Node) (nList.item(i));
				if (node instanceof Element) {
					Element constraint = (Element) node;

					if (constraint.getTagName().equals("wsag:Constraint")) {
						Node node_id = constraint.getElementsByTagName("Name")
								.item(0);
						String id = node_id.getTextContent().trim();

						Node node_expr = constraint.getElementsByTagName(
								"Content").item(0);
						String str_expr = node_expr.getTextContent().trim();
						if (str_expr.contains("NOT")) {
							str_expr = "NOT ("
									+ str_expr.substring(str_expr
											.indexOf("NOT") + 3) + ")";
						}

						CreationConstraint cc = null;

						if (str_expr.contains("IMPLIES")) {
							String[] args = str_expr.split(" IMPLIES ");
							String str_qc = args[0];
							String str_slo = args[1];

							Expression qc_cond = Expression.parse(Util
									.decodeEntities(str_qc));
							QualifyingCondition qc = new QualifyingCondition(
									qc_cond);

							Expression slo_expr = Expression.parse(Util
									.decodeEntities(str_slo));
							SLO slo = new SLO(slo_expr);
							cc = new CreationConstraint(id, slo);
							cc.setQc(qc);

						} else {
							Expression slo_expr = Expression.parse(Util
									.decodeEntities(str_expr));
							SLO slo = new SLO(slo_expr);
							cc = new CreationConstraint(id, slo);
						}

						if (cc != null) {
							((AgreementTemplate) model)
									.getCreationConstraints().put(cc.getId(),
											cc);
						}
					} else if (constraint.getTagName().equals("wsag:Item")) {
						String prop = constraint.getAttribute("wsag:Name");
						String id = "Cons_" + prop;
						Node itemConstraintNode = constraint
								.getElementsByTagName("wsag:ItemConstraint")
								.item(0);
						Element itemConstraint = (Element) itemConstraintNode;

						Expression min_expr = null;
						Expression max_expr = null;

						// Inclusive constraints
						if (itemConstraint.getElementsByTagName(
								"xs:minInclusive").item(0) != null) {
							Node min = itemConstraint.getElementsByTagName(
									"xs:minInclusive").item(0);
							String str_min_value = ((Element) min)
									.getAttribute("value");
							Integer min_value = Integer.valueOf(str_min_value);

							min_expr = new RelationalExpression(new Var(prop),
									new Atomic(min_value),
									RelationalOperator.GTE);
						}

						if (itemConstraint.getElementsByTagName(
								"xs:maxInclusive").item(0) != null) {
							Node max = itemConstraint.getElementsByTagName(
									"xs:maxInclusive").item(0);
							String str_max_value = ((Element) max)
									.getAttribute("value");
							Integer max_value = Integer.valueOf(str_max_value);

							max_expr = new RelationalExpression(new Var(prop),
									new Atomic(max_value),
									RelationalOperator.LTE);
						}

						// Exclusive constraints
						if (itemConstraint.getElementsByTagName(
								"xs:minExclusive").item(0) != null) {
							Node min = itemConstraint.getElementsByTagName(
									"xs:minExclusive").item(0);
							String str_value = ((Element) min)
									.getAttribute("value");
							Integer value = Integer.valueOf(str_value);

							min_expr = new RelationalExpression(new Var(prop),
									new Atomic(value), RelationalOperator.GT);
						}

						if (itemConstraint.getElementsByTagName(
								"xs:maxExclusive").item(0) != null) {
							Node max = itemConstraint.getElementsByTagName(
									"xs:maxExclusive").item(0);
							String str_value = ((Element) max)
									.getAttribute("value");
							Integer value = Integer.valueOf(str_value);

							max_expr = new RelationalExpression(new Var(prop),
									new Atomic(value), RelationalOperator.LT);
						}

						Expression expr = null;

						if (min_expr != null && max_expr != null)
							expr = new LogicalExpression(min_expr, max_expr,
									LogicalOperator.AND);
						else if (min_expr != null)
							expr = min_expr;
						else if (max_expr != null)
							expr = max_expr;

						SLO slo = new SLO(expr);
						CreationConstraint cc = new CreationConstraint(id, slo);
						((AgreementTemplate) model).getCreationConstraints()
								.put(cc.getId(), cc);

					}
				}
			}
		}
	}

	private void setMetric(String metric_id, String path) {

		File file_metric = null;
		String filename = path;
		if (path.contains("/"))
			filename = path.substring(path.lastIndexOf("/") + 1);
		for (File m : metrics) {
			if (m.getName().equals(filename))
				file_metric = m;
		}

		if (file_metric != null) {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			try {
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file_metric);

				doc.getDocumentElement().normalize();

				NodeList nList2 = doc.getElementsByTagName("met:metric");

				for (int k = 0; k < nList2.getLength(); k++) {
					Node nNode = nList2.item(k);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) nNode;
						if (element.getAttribute("id").equals(metric_id)) {
							Metric m = new Metric(metric_id);
							String type = element.getAttribute("type");
							m.setType(type);
							if (type.equals("enumerated")) {
								Enumerated e = new Enumerated();
								NodeList nList3 = element
										.getElementsByTagName("met:value");
								Object[] values = new Object[nList3.getLength()];
								for (int l = 0; l < nList3.getLength(); l++) {
									Node nNode2 = nList3.item(l);
									if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
										Element element2 = (Element) nNode2;
										values[l] = element2
												.getAttribute("value");
									}
								}
								e.setValues(values);
								m.setDomain(e);
							} else {
								Integer min = Integer.valueOf(element
										.getAttribute("min"));
								Integer max = Integer.valueOf(element
										.getAttribute("max"));
								Range r = new Range(min, max);
								m.setDomain(r);
							}

							model.getContext().getMetrics().put(metric_id, m);
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println();
		}
	}
}
