/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.reasoners.cspwebreasoner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import es.us.isa.aml.util.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISA Group
 */
public class CSPWebReasonerUtils {

    private static final Logger LOG = Logger.getLogger(CSPWebReasonerUtils.class.getName());

    public static Problem pollService(String url, Problem problem) throws TimeoutException {
        return pollService(url, problem, Config.getInstance().getFrequency(), Config.getInstance().getTimeout());
    }

    public static Problem pollService(String url, Problem problem, long timeout) throws TimeoutException {
        return pollService(url, problem, timeout, Config.getInstance().getFrequency());
    }

    public static Problem pollService(String url, Problem problem, long timeOut, long frequency) throws TimeoutException {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Problem result = null;
        Boolean success = false;
        long startTime = System.currentTimeMillis() / 1000;
        try {
            Gson gson = new Gson();
            String credentialParams = "?credential=" + Config.getInstance().getCredential() + "&" + Config.getInstance().getApikeyVariable() + "=" + Config.getInstance().getApikeyValue();
            String jsonString = CSPWebReasonerUtils.sendPostRequest(url + credentialParams, gson.toJson(problem));
            JsonObject json = gson.fromJson(jsonString, JsonObject.class);
            String taskId = json.get("taskId").getAsString();
            while (!success && ((System.currentTimeMillis() / 1000) - startTime) < timeOut) {
                ScheduledFuture<String> future = scheduler.schedule(new PollingTask(url + "/" + taskId + credentialParams), frequency, TimeUnit.SECONDS);
                String response = future.get(timeOut, TimeUnit.SECONDS);
                result = new Gson().fromJson(response, Problem.class);
                if (result.getSolution() != null) {
                    LOG.log(Level.INFO, "[PollingService] Problem ID: {0} has been solved", taskId);
                    success = true;
                }
            }
        } catch (TimeoutException ex) {
            throw new TimeoutException("The operation could not be completed due to a timeout.");
        } catch (InterruptedException | ExecutionException | JsonSyntaxException ex) {
            Logger.getLogger(CSPWebReasonerUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CSPWebReasonerUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            scheduler.shutdown();
        }

        if (!success) {
            throw new TimeoutException("The operation could not be completed due to a timeout.");
        }

        return result;
    }

// HTTP POST request
    public static String sendGetRequest(String url) throws Exception {

        javax.net.ssl.HttpsURLConnection
                .setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {

                    @Override
                    public boolean verify(String hostname,
                            javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("localhost")) {
                            return true;
                        }
                        return false;
                    }
                });

        URL obj = new URL(url);
        // HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // add request header
        con.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }

        return response.toString();
    }

    // HTTP POST request
    public static String sendPostRequest(String url, String content) throws Exception {

        javax.net.ssl.HttpsURLConnection
                .setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {

                    @Override
                    public boolean verify(String hostname,
                            javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("localhost")) {
                            return true;
                        }
                        return false;
                    }
                });

        URL obj = new URL(url);
        // HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.addRequestProperty("Content-Type", "application/json; charset=utf8");

        // add request header
        con.setRequestMethod("POST");

        // String data = URLEncoder.encode(content.replaceAll("\\+",
        // "%2B"),"UTF-8");
        String data = URLEncoder.encode(content, "UTF-8");
        con.setRequestProperty("Content-Length",
                Integer.toString(content.length()));

        // Send post request
        con.setDoOutput(true);
        try {
            OutputStream os = con.getOutputStream();
            os.write(content.getBytes());
            os.flush();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }

        return response.toString();
    }

    static class PollingTask implements Callable<String> {

        String url;

        public PollingTask(String url) {
            this.url = url;
        }

        @Override
        public String call() throws Exception {
            try {
                String response = sendGetRequest(url);
                return response;
            } catch (Exception ex) {
                Logger.getLogger(CSPWebReasonerUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
}
