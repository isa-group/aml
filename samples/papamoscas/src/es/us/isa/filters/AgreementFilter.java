package es.us.isa.filters;

import com.google.gson.Gson;
import es.us.isa.aml.AgreementManager;
import es.us.isa.classes.Property;
import es.us.isa.util.Helper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Antonio Gamez <agamez2@us.es>
 * @version 1.0
 */

public class AgreementFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(AgreementFilter.class.getName());
    public static Gson g = new Gson();
    private AgreementManager agr = Helper.getInstance().getAgreementManager();
    private String clientId;
    //ENDPOINT del server del agreements
    private String serverURL;
    private ServletContext context;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        context = fConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        clientId = req.getParameter("user");
        serverURL = "http://" + req.getServerName() + "/api/v4/agreements";
        requestDone(req);
        if (authorizeRequest(req)) {
            // Contar tiempo en realizar la peticion
            Long timestamp = System.currentTimeMillis();

            chain.doFilter(request, response);
            timestamp = System.currentTimeMillis() - timestamp;
            responseDone(timestamp);
            LOG.log(Level.INFO, "Request accepted");
        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.sendRedirect("/error.html");
            LOG.log(Level.INFO, "Request rejected");
        }
    }

    private void responseDone(Long timestamp) {
        // TODO Auto-generated method stub

        String json2 = doGetInternal("/" + clientId + "/properties/Requests");
        g = new Gson();
        Property p2 = g.fromJson(json2, Property.class);

        String json = doGetInternal("/" + clientId + "/properties/AVGResponseTime");
        g = new Gson();
        Property p = g.fromJson(json, Property.class);

        // Solo si existe la propiedad avgresponsetime y requests
        if (!(json.equals("ERROR")) || (json2.equals("ERROR"))) {
            // REVISAR FORMULA QUE CALCULA TIEMPO MEDIO
            long l = p.getValue() != null ? Double.valueOf(p.getValue().toString()).longValue() : 0;
            Long avgT = new Long(l);
            long i = p2.getValue() != null ? Double.valueOf(p2.getValue().toString()).longValue() : 0;
            Long numReq = new Long(i);
            avgT = (avgT * (numReq - 1) + timestamp) / numReq;
            p.setValue(avgT.toString());
            doPostInternal("/" + clientId + "/properties/AVGResponseTime", p);
        } else {
            // Si no existe la propiedad Request
        }
    }

    @Override
    public void destroy() {

    }

    private boolean authorizeRequest(HttpServletRequest req) {
        Boolean isAuth = false;

        String json = doGetInternal("/" + clientId + "/guarantees/RequestTerm");
        g = new Gson();
        Boolean gua = g.fromJson(json, Boolean.class);

        if (!json.equals("ERROR")) {
            isAuth = gua;
        } else {
            // Si no existe la propiedad Request
            return false;
        }

        if (isAuth) {
            String resourcePath = req.getRequestURI();
            String[] resources = resourcePath.split("/");
            if (resources.length == 5) {
                if (resources[4].equals("analyticsFT") || resources[4].equals("analyticsSL")) {
                    String json2 = doGetInternal("/" + clientId + "/guarantees/AnalyticsRequestTerm");
                    g = new Gson();
                    Boolean ret = g.fromJson(json2, Boolean.class);

                    if (!json2.equals("ERROR")) {
                        isAuth = ret;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return isAuth;

		/*
         *
		 * AgreementOffer offer =
		 * agr.getStoreManager().getAgreementOffer(clientId); if (offer != null)
		 * { return offer.evaluateGT("RequestTerm"); } return false;
		 */

    }

    private void requestDone(HttpServletRequest req) {

        // Actualiza el valor de AnalyticsRequests
        String resourcePath = req.getRequestURI();
        String[] resources = resourcePath.split("/");
        if (resources.length == 5) {
            if (resources[4].equals("analyticsFT") || resources[4].equals("analyticsSL")) {
                String json = doGetInternal("/" + clientId + "/properties/AnalyticsRequests");
                g = new Gson();
                Property p = g.fromJson(json, Property.class);

                if (!json.equals("ERROR")) {
                    int i = p.getValue() != null ? Double.valueOf(p.getValue().toString()).intValue() : 0;
                    Integer numReq = new Integer(i);
                    numReq++;
                    p.setValue(numReq);
                    doPostInternal("/" + clientId + "/properties/AnalyticsRequests", p);
                } else {
                    // Si no existe la propiedad Request
                }
            }
        }

        // Actualiza el valor de Requests
        String json = doGetInternal("/" + clientId + "/properties/Requests");
        g = new Gson();
        Property p = g.fromJson(json, Property.class);

        if (!json.equals("ERROR")) {
            int i = p.getValue() != null ? Double.valueOf(p.getValue().toString()).intValue() : 0;
            Integer numReq = new Integer(i);
            numReq++;
            p.setValue(numReq);
            doPostInternal("/" + clientId + "/properties/Requests", p);
        } else {
            // Si no existe la propiedad Request
        }

    }

    // unicamente hay que añadir la url despues de agreements

    private void doPostInternal(String url, Property p) {

        String userAgent = "Mozilla/5.0 (X11; Linux x86_64; rv:26.0) Gecko/20100101 Firefox/26.0";

        try {

            URL api = new URL(serverURL + url);
            HttpURLConnection connection = (HttpURLConnection) api.openConnection();
            //connection.addRequestProperty("User-Agent", userAgent);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setRequestProperty("Accept", "application/json");
            g = new Gson();
            String respuesta1 = g.toJson(p);
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());

            wr.write(respuesta1);

            wr.flush();

            int HttpResult = connection.getResponseCode();

            if (HttpResult == HttpURLConnection.HTTP_OK) {

            }

			
			/*
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream());

			out.write(respuesta1);
			out.flush();
						out.close();

			*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String doGetInternal(String url) {
        String a = "ERROR";
        try {


            URL api = new URL(serverURL + url);

            StringBuffer out = new StringBuffer();

            BufferedReader in = new BufferedReader(new InputStreamReader(api.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.append(inputLine);
            }
            a = out.toString();
            in.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return a;

    }

}