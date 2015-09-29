package es.us.isa.servlets;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.translator.Translator;
import es.us.isa.util.Helper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Antonio Gamez <agamez2@us.es>
 * @version 1.0
 */

public class PlanPurschaseServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(PlanPurschaseServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AgreementManager agr = Helper.getInstance().getAgreementManager();
        Translator t = Helper.getInstance().getIAgreeTranslator();

        try {
            String clientId = req.getParameter("clientId").toLowerCase();
            String templateId = req.getParameter("templateId");
            String ws = req.getParameter("ws");
            ws = URLDecoder.decode(ws, "UTF-8");
            String urlstr = ws + templateId;

            StringBuffer sbf = new StringBuffer();
            // Access the page
            try {
                URL url = new URL(urlstr);
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String inputLine;
                StringBuffer b = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    b.append(inputLine);
                }
                in.close();
                String tmpl = b.toString();

                try {
                    agr.createAgreementTemplate(tmpl).generateAgreementOffer(clientId).generateAgreement(clientId).register(clientId);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("no registra");
                }
                System.out.println(agr.getStoreManager().getAgreementMap());

            } catch (IOException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("/endPortal.html?clientId=" + clientId+"&planId="+templateId);

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            LOG.log(Level.WARNING, null, e);
        }
    }
}
