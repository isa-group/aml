/**
 *
 */
package es.us.isa.aml.parsers.agreements.wsag;

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
import es.us.isa.aml.model.Responder;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.ServiceRole;
import es.us.isa.aml.model.expression.Expression;
import es.us.isa.aml.util.DocType;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author jdelafuente
 *
 */
public class WsagParserHelper {

    private final Document doc;
    private AgreementModel model;

    public WsagParserHelper(Document doc) {
        this.doc = doc;

    }

    public AgreementModel getModel() {
        createModel();
        return model;
    }

    public void createModel() {
        Node template = doc.getElementsByTagName("wsag:Template").item(0);
        Node offer = doc.getElementsByTagName("wsag:AgreementOffer").item(0);
        Double version = null;

        if (template != null) {
            model = new AgreementTemplate();
            Element temp = (Element) template;
            version = Double.valueOf(temp.getAttribute("wsag:TemplateId"));
            model.setVersion(version);
        } else {
            model = new AgreementOffer();
            Element agoffer = (Element) offer;
            version = Double.valueOf(agoffer.getAttribute("wsag:AgreementOfferId"));
            model.setVersion(version);
        }

        Node name = doc.getElementsByTagName("wsag:Name").item(0);
        if (name != null) {
            model.setID(name.getTextContent());
        }

        setContext();
        setAgreementTerms();
        if (model.getDocType() == DocType.TEMPLATE) {
            setCreationConstraints();
        }
    }

    public void setContext() {
        Context context = new Context();

        Node responder = doc.getElementsByTagName("wsag:AgreementResponder")
                .item(0);
        if (responder != null && responder instanceof Element) {
            Element resp = (Element) responder;
            Responder r = new Responder();
            r.setId(resp.getAttribute("id"));
            r.setRoleType(ServiceRole.valueOf(responder.getTextContent()));
            context.setResponder(r);
        }

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
                    String[] args = domain.replace("[", "").replace("]", "")
                            .split("\\.\\.");
                    Integer min = Integer.valueOf(args[0]);
                    Integer max = Integer.valueOf(args[1]);
                    d = new Range(min, max);
                } else {
                    String[] args = domain.replace("{", "").replace("}", "")
                            .split(", ");
                    List<Object> values = new ArrayList<>();
                    for (String s : args) {
                        values.add(s);
                    }
                    d = new Enumerated(values);
                }
                m.setDomain(d);
                context.getMetrics().put(id, m);
            }
        }

        model.setContext(context);
    }

    public void setAgreementTerms() {
        Node node_terms = doc.getElementsByTagName("wsag:Terms").item(0);
        NodeList nList = node_terms.getChildNodes();
        Node node_allterms = null;
        for (int i = 0; i < nList.getLength(); i++) {
            Node attemp = (Node) (nList.item(i));
            if (attemp.getNodeType() == Node.ELEMENT_NODE) {
                node_allterms = attemp;
                break;
            }
        }

        NodeList terms = node_allterms.getChildNodes();
        for (int i = 0; i < terms.getLength(); i++) {
            Node node_term = (Node) (terms.item(i));
            if (node_term instanceof Element) {
                Element term = (Element) node_term;

                if (term.getTagName().equals("wsag:ServiceDescriptionTerm")) {

                    String serviceName = term.getAttribute("wsag:ServiceName");
                    model.getAgreementTerms().getService().setServiceName(serviceName);

                    String serviceReference = term.getAttribute("iag:ServiceReference");
                    model.getAgreementTerms().getService().setServiceReference(serviceReference);

                    NodeList offer_items = term.getChildNodes();
                    for (int j = 0; j < offer_items.getLength(); j++) {
                        Node node_oi = (Node) (offer_items.item(j));
                        if (node_oi instanceof Element) {
                            Element offer_item = (Element) node_oi;
                            String id = offer_item.getAttribute("name");
                            String value = null;
                            if (!offer_item.getTextContent().isEmpty()) {
                                value = offer_item.getTextContent();
                            }

                            String metric_id = offer_item
                                    .getAttribute("iag:Metric");
                            Metric m = model.getContext().getMetrics()
                                    .get(metric_id);

                            ConfigurationProperty p = new ConfigurationProperty(
                                    id, m);

                            if (value != null) {
                                Expression exp = Expression.parse(value);
                                p.setExpression(exp);
                            }

                            model.getAgreementTerms().getService()
                                    .getConfigurationProperties().add(p);
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

                            String metric_id = variable
                                    .getAttribute("iag:Metric");
                            Metric m = model.getContext().getMetrics()
                                    .get(metric_id);

                            MonitorableProperty p = new MonitorableProperty(id,
                                    m);

                            model.getAgreementTerms()
                                    .getMonitorableProperties().add(p);
                        }
                    }

                } else if (term.getTagName().equals("wsag:GuaranteeTerm")) {
                    if (term instanceof Element) {
                        Element gt_element = (Element) term;
                        String id = gt_element.getAttribute("wsag:Name");
                        String ob = gt_element.getAttribute("wsag:Obligated");
                        GuaranteeTerm gt = new GuaranteeTerm(id);
                        gt.setServiceRole(ServiceRole.valueOf(ob));

                        NodeList nList2 = gt_element.getChildNodes();
                        for (int j = 0; j < nList2.getLength(); j++) {
                            Node node_prop = (Node) (nList2.item(j));
                            if (node_prop instanceof Element) {
                                Element prop = (Element) node_prop;
                                if (prop.getTagName().equals(
                                        "wsag:QualifyingCondition")) {
                                    Expression cond = Expression.parse(prop
                                            .getTextContent());
                                    QualifyingCondition qc = new QualifyingCondition(
                                            cond);
                                    gt.setQc(qc);
                                } else if (prop.getTagName().equals(
                                        "wsag:ServiceLevelObjective")) {
                                    Expression exp = Expression.parse(prop
                                            .getTextContent());
                                    SLO slo = new SLO(exp);
                                    gt.setSlo(slo);
                                }
                            }
                        }

                        model.getAgreementTerms().getGuaranteeTerms().add(gt);
                    }

                }

            }
        }
    }

    public void setCreationConstraints() {
        Node ccs = doc.getElementsByTagName("wsag:CreationConstraints").item(0);
        NodeList nList = ccs.getChildNodes();
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = (Node) (nList.item(i));
            if (node instanceof Element) {
                Element constraint = (Element) node;
                Node node_id = constraint.getElementsByTagName("Name").item(0);
                String id = node_id.getTextContent();

                Node node_expr = constraint.getElementsByTagName("Content")
                        .item(0);
                String str_expr = node_expr.getTextContent();

                CreationConstraint cc = null;

                if (str_expr.contains("IMPLIES")) {
                    String[] args = str_expr.split(" IMPLIES ");
                    String str_qc = args[0];
                    String str_slo = args[1];

                    Expression qc_cond = Expression.parse(str_qc);
                    QualifyingCondition qc = new QualifyingCondition(qc_cond);

                    Expression slo_expr = Expression.parse(str_slo);
                    SLO slo = new SLO(slo_expr);
                    cc = new CreationConstraint(id, slo);
                    cc.setQc(qc);

                } else {
                    Expression slo_expr = Expression.parse(str_expr);
                    SLO slo = new SLO(slo_expr);
                    cc = new CreationConstraint(id, slo);
                }

                if (cc != null) {
                    ((AgreementTemplate) model).getCreationConstraints()
                            .add(cc);
                }
            }
        }

    }

	//
    // public String getCreationConstraints() {
    //
    // String result = "";
    //
    // Element cc = (Element) doc.getElementsByTagName(
    // "wsag:CreationConstraints").item(0);
    //
    // if (cc != null && !cc.getTextContent().isEmpty()) {
    // result += Util
    // .withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.CREATION_CONSTRAINTS]);
    //
    // NodeList nList = cc.getElementsByTagName("wsag:Constraint");
    //
    // for (int i = 0; i < nList.getLength(); i++) {
    // Element constraint = (Element) nList.item(i);
    // result += "\n\t"
    // + constraint.getElementsByTagName("Name").item(0)
    // .getTextContent() + ":";
    //
    // String content = constraint.getElementsByTagName("Content")
    // .item(0).getTextContent();
    //
    // if (content.contains("IMPLIES")) {
    // String[] aux = content.split("IMPLIES");
    // String exp1 = aux[0].trim();
    // if (exp1.contains("True") || exp1.contains("False")) {
    // exp1 = exp1.replace("\"", "");
    // exp1 = exp1.replace("True", "true").replace("False",
    // "false");
    // }
    // String exp2 = aux[1].trim();
    // if (exp2.contains("True") || exp2.contains("False")) {
    // exp2 = exp2.replace("\"", "");
    // exp2 = exp2.replace("True", "true").replace("False",
    // "false");
    // }
    //
    // if (exp2.contains("OR")) {
    // // exp2 = getBelongsExp(exp2);
    // }
    //
    // result += Util.decodeEntities(exp2) + ";" + "\n";
    //
    // result += "\t\t"
    // + Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF])
    // + " (" + Util.decodeEntities(exp1) + ");\n";
    //
    // } else if (content.contains("OR")) {
    // result += "\t"; //+ getBelongsExp(content) + ";\n";
    // } else {
    // result += "\t" + Util.decodeEntities(content.trim())
    // + ";\n";
    // }
    // }
    // }
    //
    // return result;
    // }
}
