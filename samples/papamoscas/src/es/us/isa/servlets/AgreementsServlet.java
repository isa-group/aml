package es.us.isa.servlets;

import com.google.gson.Gson;
import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.GuaranteeTerm;
import es.us.isa.aml.model.MonitorableProperty;
import es.us.isa.aml.translator.Translator;
import es.us.isa.classes.Guarantee;
import es.us.isa.classes.Property;
import es.us.isa.util.Helper;
import es.us.isa.util.RecordGuarantee;
import es.us.isa.util.RecordProperty;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Antonio Gamez <agamez2@us.es>
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 2.0 Añadido GET y POST a properties y guarantees Añadido record,
 *          histoarico de la evolucion de las distitnas properties y guarantees
 */

public class AgreementsServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AgreementsServlet.class.getName());
    public static Gson g = new Gson();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        addCorsHeader(resp);
        AgreementManager agr = Helper.getInstance().getAgreementManager();
        Translator t = Helper.getInstance().getIAgreeTranslator();

        String resourcePath = req.getPathInfo();
        String agreement = "";

        try {
            if (resourcePath != null && !resourcePath.equals("/")) {
                String[] resources = resourcePath.split("/");
                String clientId;
                if (resources.length > 2) {

                    // Gestion de peticiones properties y guaranties
                    // Cuandos las url tienen entre 2 y 5 recursos intermedios
                    if (resources.length > 5) {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Check URI");
                    } else {
                        clientId = resources[1];

                        if (agr.getStoreManager().getAgreementMap().containsKey(clientId)) {
                            // agreement=agr.getStoreManager().getAgreementMap().get(clientId).getAgreementTerms().getMonitorableProperties().get(0).getMetric().toString();
                            agreement = respPropertiesGuaranties(resources, agr, resp);
                        } else {
                            resp.sendError(HttpServletResponse.SC_NO_CONTENT, "No data");
                        }
                    }

                } else {
                    clientId = resources[1];
                    if (agr.getStoreManager().getAgreementMap().containsKey(clientId)) {

                        agreement = t.translate(agr.getStoreManager().getAgreementMap().get(clientId)).toString();
                    } else {
                        resp.sendError(HttpServletResponse.SC_NO_CONTENT, "No data");
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                List<AgreementModel> models = new LinkedList<>(agr.getStoreManager().getAgreementMap().values());

                Collections.sort(models, new Comparator<AgreementModel>() {
                    @Override
                    public int compare(AgreementModel o1, AgreementModel o2) {
                        return o1.getDocType().toString().compareToIgnoreCase(o2.getDocType().toString());
                    }
                });

                for (AgreementModel am : models) {
                    sb.append(t.translate(am)).append("\n-------------------------------------------------------\n");
                }
                agreement = sb.toString();

            }
            resp.setStatus(HttpServletResponse.SC_FOUND);
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(agreement);

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            LOG.log(Level.WARNING, null, e);
        }

    }

    public String respPropertiesGuaranties(String url[], AgreementManager agr, HttpServletResponse resp) {

        String respuesta1 = new String();
        String clientId = url[1];

        try {
            // PROPIERTIES
            if (url[2].equals("properties")) {
                if (url.length < 4) {
                    List<Property> listP = new LinkedList();
                    for (MonitorableProperty mp : agr.getStoreManager().getAgreementMap().get(clientId).getAgreementTerms().getMonitorableProperties()) {
                        Property p1 = new Property(mp.getId().toString(), mp.getValue(), mp.getMetric().toString(), mp.getScope().toString());
                        listP.add(p1);
                        // respuesta.append("ID -> "+mp.getId().toString()).append("\n");
                        // respuesta.append("SCOPE -> "+mp.getScope().toString()).append("\n");
                        // respuesta.append("VALUE -> "+mp.getValue()).append("\n");
                        // respuesta.append("METRIC -> "+mp.getMetric().toString()).append("\n");
                        // respuesta.append("EXPRESION -> "+mp.getExpression().toString()).append("\n-------------------------------------------------------\n");
                    }
                    g = new Gson();
                    respuesta1 = g.toJson(listP);

                } else {
                    if (url.length < 5) {
                        boolean existePropiedad = false;
                        for (MonitorableProperty mp : agr.getStoreManager().getAgreementMap().get(clientId).getAgreementTerms().getMonitorableProperties()) {
                            if (mp.getId().equals(url[3])) {
                                existePropiedad = true;
                                Property p2 = new Property(mp.getId().toString(), mp.getValue(), mp.getMetric().toString(), mp.getScope().toString());
                                g = new Gson();
                                respuesta1 = g.toJson(p2);
                                // respuesta.append(mp.getValue().toString());
                            }
                        }
                        if (!existePropiedad) {

                            resp.sendError(HttpServletResponse.SC_NO_CONTENT, "No data");

                        }

                    } else {
                        // History
                        if (url[4].equals("record")) {

                            if (RecordProperty.getInstance().existProperty(clientId, url[3])) {
                                Map<Date, Object> mapP = RecordProperty.getInstance().getPropertyMark(clientId, url[3]);
                                g = new Gson();
                                respuesta1 = g.toJson(mapP);
                            } else {
                                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found");
                            }

                        } else {
                            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Check URI");

                        }
                    }

                }
            } else {

                // GUARANTEES

                if (url[2].equals("guarantees")) {

                    if (url.length < 4) {
                        List<Guarantee> listG = new LinkedList();

                        for (GuaranteeTerm gt : agr.getStoreManager().getAgreementMap().get(clientId).getAgreementTerms().getGuaranteeTerms()) {
                            Guarantee g1 = new Guarantee(gt.getId().toString(), gt.getServiceRole().toString(), gt.getSlo().getExpression().toString().trim());
                            listG.add(g1);

                            // respuesta.append("ID -> "+gt.getId().toString()).append("\n");
                            // respuesta.append("SCOPE -> "+gt.getServiceScope()).append("\n");
                            // respuesta.append("Rol que garantiza el acuerdo -> "+gt.getServiceRole().toString()).append("\n");
                            // respuesta.append("EXPRESION -> "+gt.getSlo().getExpression().toString()).append("\n-------------------------------------------------------\n");
                        }
                        g = new Gson();
                        respuesta1 = g.toJson(listG);

                    } else {
                        if (url.length < 5) {
                            boolean existeGarantia = false;
                            for (GuaranteeTerm gt : agr.getStoreManager().getAgreementMap().get(clientId).getAgreementTerms().getGuaranteeTerms()) {
                                if (gt.getId().equals(url[3])) {
                                    existeGarantia = true;
                                    AgreementOffer offer = agr.getStoreManager().getAgreementOffer(clientId);
                                    g = new Gson();
                                    respuesta1 = g.toJson(offer.evaluateGT(gt.getId().toString()));

                                    // respuesta.append(offer.evaluateGT(gt.getId().toString()).toString());
                                }
                            }
                            if (!existeGarantia) {
                                resp.sendError(HttpServletResponse.SC_NO_CONTENT, "No data");

                            }

                        } else {
                            // History y Expresion
                            if (url[4].equals("record")) {

                                if (RecordGuarantee.getInstance().existGuarantee(clientId, url[3])) {

                                    Map<Date, Boolean> mapG = RecordGuarantee.getInstance().getGuaranteeMark(clientId, url[3]);
                                    g = new Gson();
                                    respuesta1 = g.toJson(mapG);
                                } else {
                                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found");
                                }

                            } else {

                                if (url[4].equals("expression")) {
                                    String expr = "null";
                                    for (GuaranteeTerm gt : agr.getStoreManager().getAgreementMap().get(clientId).getAgreementTerms().getGuaranteeTerms()) {
                                        if (gt.getId().equals(url[3])) {
                                            expr = gt.getSlo().getExpression().toString().trim();
                                            break;
                                        }

                                    }
                                    g = new Gson();
                                    respuesta1 = g.toJson(expr);

                                } else {

                                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Check URI");

                                }
                            }
                        }

                    }

                } else {
                    // ERROR
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Check URI");

                }

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

            e.printStackTrace();
        }

        return respuesta1;

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        addCorsHeader(resp);
        AgreementManager agr = Helper.getInstance().getAgreementManager();

        String resourcePath = req.getPathInfo();

        try {
            if (resourcePath != null && !resourcePath.equals("/")) {
                String[] resources = resourcePath.split("/");
                String clientId;
                String propertyId;
                Property propiedad;
                if (resources.length == 4) {
                    clientId = resources[1];
                    propertyId = resources[3];

                    if (!resources[2].equals("properties")) {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Check URI");

                    } else {

                        AgreementOffer offer = agr.getStoreManager().getAgreementOffer(clientId);

                        if (offer != null) {
                            if (offer.getProperty(propertyId).getExpression() == null) {
                                resp.sendError(HttpServletResponse.SC_NO_CONTENT, "No data");
                            }

                            propiedad = jsonToProperty(req);
                            offer.setProperty(propertyId, propiedad.getValue());
                            actRecordGuarantee(offer, clientId, propertyId);
                            actRecordProperty(offer, clientId, propiedad.getValue(), propertyId);

                        } else {
                            resp.sendError(HttpServletResponse.SC_NO_CONTENT, "No data");
                        }

                    }

                }
            }

        } catch (IOException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

            e.printStackTrace();

        }

    }

    private void actRecordGuarantee(AgreementOffer offer, String clientId, String propertyId) {
        RecordGuarantee rG = RecordGuarantee.getInstance();

        for (GuaranteeTerm gt : offer.getAgreementTerms().getGuaranteeTerms()) {
            if (gt.getId().equals(propertyId)) {
                rG.putGuanrateeMark(clientId, gt.getId(), offer.evaluateGT(gt.getId()));

            }
        }
    }

    private void actRecordProperty(AgreementOffer offer, String clientId, Object b1, String propertyId) {
        RecordProperty rP = RecordProperty.getInstance();

        for (MonitorableProperty mp : offer.getAgreementTerms().getMonitorableProperties()) {
            if (mp.getId().equals(propertyId)) {
                rP.putPropertyMark(clientId, mp.getId(), b1);
            }
        }

    }

    private Property jsonToProperty(HttpServletRequest req) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = req.getReader();
        String jsonString;
        while ((jsonString = br.readLine()) != null) {
            sb.append(jsonString);
        }
        jsonString = sb.toString();
        Property p = g.fromJson(jsonString, Property.class);
        return p;
    }

    private void addCorsHeader(HttpServletResponse response) {
        // TODO: externalize the Allow-Origin
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
    }

}
