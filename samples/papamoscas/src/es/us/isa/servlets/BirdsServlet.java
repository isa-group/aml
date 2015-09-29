package es.us.isa.servlets;


/*Importanciones antes de manu
import com.google.appengine.repackaged.com.google.common.collect.Lists;
import com.google.appengine.repackaged.com.google.gson.ExclusionStrategy;
import com.google.appengine.repackaged.com.google.gson.FieldAttributes;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;
 */


import com.google.appengine.api.datastore.*;
import com.google.appengine.labs.repackaged.com.google.common.collect.Lists;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.us.isa.classes.Bird;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * Applied Software Engineering Research Group (ISA Group)
 * University of Sevilla, Spain
 *
 * @author Antonio Gamez <agamez2@us.es>
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 2.0
 *          Añadido analiticas
 */

public class BirdsServlet extends HttpServlet {
    public static Gson g = new Gson();
    public static DatastoreService db = DatastoreServiceFactory.getDatastoreService();
    public List<Bird> birdList = new LinkedList<>();


    public void init() {
        Bird b1 = new Bird("1", "papamosca", "roble", (float) 0.1, (float) 10.0, 10, 3);
        Bird b2 = new Bird("2", "vencejo", "pino", (float) 0.15, (float) 9.0, 7, 5);
        Bird b3 = new Bird("3", "papamosca", "pino", (float) 0.1, (float) 10.0, 10, 3);
        Bird b4 = new Bird("4", "vencejo", "roble", (float) 0.15, (float) 9.0, 7, 5);
        birdList.add(b1);
        birdList.add(b2);
        birdList.add(b3);
        birdList.add(b4);
        for (Bird b : birdList) {
            saveBirdToDatastore(b);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        g = new Gson();
        resp.setCharacterEncoding("UTF-8");
        init();
        g = new Gson();
        String json = "";
        List<Query.Filter> filterList = new ArrayList<>();
        String resourcePath = req.getPathInfo();
        try {
            if (resourcePath != null && !resourcePath.equals("/")) {
                String[] resources = resourcePath.split("/");
                if (resources.length > 2) {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                } else {
                    String birdId = resources[1];
                    if (birdId.equals("analyticsSL") || birdId.equals("analyticsFT")) {
                        //funciones de analytics
                        Float avgB = new Float(0);
                        if (birdId.equals("analyticsSL")) {
                            avgB = analytics(0);
                        } else {
                            avgB = analytics(1);
                        }
                        json = g.toJson(avgB);


                    } else {
                        if (!req.getParameterMap().isEmpty()) {
                            filterList.add(new Query.FilterPredicate("id", Query.FilterOperator.EQUAL, birdId));
                            handleGetWithParameters(req, resp, filterList, birdId);
                        } else {
                            Query q = new Query("bird").setFilter(new Query.FilterPredicate("id", Query.FilterOperator.EQUAL, birdId));
                            Bird bird = getBirdfromDatastoreQuery(q);
                            if (bird != null) {
                                json = g.toJson(bird);
                            } else {
                                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            }
                        }
                    }


                }
            } else {
                if (!req.getParameterMap().isEmpty()) {
                    handleGetWithParameters(req, resp, filterList, null);
                } else {
                    Query q = new Query("bird");
                    List<Bird> birdList = getListfromDatastoreQuery(q);
                    if (!birdList.isEmpty()) {
                        json = g.toJson(birdList);
                    } else {
                        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    }
                }
            }
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    private Float analytics(Integer i) {
        if (i.equals(0)) {
            try {
                Thread.sleep((long) Math.random() * 500 + 750);
            } catch (InterruptedException e) {
            }
        }
        Query q = new Query("bird");
        List<Bird> birdList = getListfromDatastoreQuery(q);
        Float a = new Float(0);
        for (Bird b : birdList) {
            a = +b.getLegDiameter();
        }


        return a / birdList.size();
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        g = new Gson();
        resp.setCharacterEncoding("UTF-8");
        try {
            String resourcePath = req.getPathInfo();

            if (resourcePath != null && !resourcePath.equals("/")) {
                String[] resources = resourcePath.split("/");
                if (resources.length > 2) {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                } else {
                    String birdId = resources[1];
                    Query q = new Query("bird").setFilter(new Query.FilterPredicate("id", Query.FilterOperator.EQUAL, birdId));
                    PreparedQuery pq = db.prepare(q);
                    try {
                        Entity e = pq.asSingleEntity();
                        if (e != null && e.getProperty("id").equals(birdId)) {
                            db.delete(e.getKey());
                            Bird b = jsonToBird(req);
                            saveBirdToDatastore(b);
                            resp.setStatus(HttpServletResponse.SC_OK);

                        } else {
                            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    }
                }
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        g = new Gson();
        resp.setCharacterEncoding("UTF-8");
        try {
            String resourcePath = req.getPathInfo();
            if (resourcePath != null && !resourcePath.equals("/")) {
                String[] resources = resourcePath.split("/");
                if (resources.length > 2) {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                } else {
                    String birdId = resources[1];
                    Query q = new Query("bird").setFilter(new Query.FilterPredicate("id", Query.FilterOperator.EQUAL, birdId));
                    PreparedQuery pq = db.prepare(q);
                    try {
                        Entity e = pq.asSingleEntity();
                        if (e != null) {
                            db.delete(e.getKey());
                            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                        } else {
                            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        }
                    } catch (Exception e) {
                        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    }
                }
            } else {
                Query q = new Query("bird");
                PreparedQuery pq = db.prepare(q);
                for (Entity e : pq.asIterable()) {
                    db.delete(e.getKey());
                }
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        g = new Gson();
        resp.setCharacterEncoding("UTF-8");
        String resourcePath = req.getPathInfo();
        try {
            if (resourcePath != null && !resourcePath.equals("/")) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } else {
                StringBuilder sb = new StringBuilder();
                BufferedReader br = req.getReader();
                String jsonString;
                while ((jsonString = br.readLine()) != null) {
                    sb.append(jsonString);
                }
                jsonString = sb.toString();
                Bird b = g.fromJson(jsonString, Bird.class);
                if (!checkIfBirdExists(b)) {
                    saveBirdToDatastore(b);
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                } else {
                    resp.setStatus(HttpServletResponse.SC_CONFLICT);
                }
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    private void handleGetWithParameters(HttpServletRequest req, HttpServletResponse resp, List<Query.Filter> filterList, String birdId) throws IOException {
        Query q = new Query("bird");
        String json = "";
        @SuppressWarnings("unchecked") Enumeration<String> parameterNames = req.getParameterNames();
        filterList.add(new Query.FilterPredicate("id", Query.FilterOperator.NOT_EQUAL, ""));    // true
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] paramValues = req.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                switch (paramName) {
                    case "fields":
                        final List<String> fields = Lists.newArrayList(paramValue.split(","));
                        filterList.add(new Query.FilterPredicate("id", Query.FilterOperator.NOT_EQUAL, ""));    // true
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        ExclusionStrategy exclusion = new ExclusionStrategy() {
                            @Override
                            public boolean shouldSkipField(FieldAttributes f) {
                                boolean a = f.getDeclaringClass() == Bird.class;
                                boolean b = !fields.contains(f.getName());
                                return a && b;
                            }

                            @Override
                            public boolean shouldSkipClass(Class<?> arg0) {
                                return false;
                            }
                        };
                        gsonBuilder.setExclusionStrategies(exclusion);
                        g = gsonBuilder.create();
                        break;
                    case "specie":
                        String specie = paramValue.split(",")[0];
                        filterList.add(new Query.FilterPredicate("specie", Query.FilterOperator.EQUAL, specie.toLowerCase()));
                        break;
                    case "place":
                        String place = paramValue.split(",")[0];
                        filterList.add(new Query.FilterPredicate("place", Query.FilterOperator.EQUAL, place.toLowerCase()));
                        break;
                    default:
                        if (birdId == null) {
                            Query qq = new Query("bird");
                            List<Bird> birdList = getListfromDatastoreQuery(q);
                            if (!birdList.isEmpty()) {
                                json = g.toJson(birdList);
                            } else {
                                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            }
                        } else {
                            Query qq = new Query("bird").setFilter(new Query.FilterPredicate("id", Query.FilterOperator.EQUAL, birdId));
                            Bird bird = getBirdfromDatastoreQuery(qq);
                            if (bird != null) {
                                json = g.toJson(bird);
                            } else {
                                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            }
                        }

                }
            }
        }
        if (json.isEmpty()) {
            try {
                Query.CompositeFilter ff = new Query.CompositeFilter(Query.CompositeFilterOperator.AND, filterList);
                q.setFilter(ff);
                List<Bird> birdList = getListfromDatastoreQuery(q);
                if (!birdList.isEmpty()) {
                    json = g.toJson(birdList);
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (Exception e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    private void saveBirdToDatastore(Bird b) {
        Entity e = new Entity("bird", b.getId());
        e.setProperty("id", b.getId());
        e.setProperty("specie", b.getSpecie());
        e.setProperty("place", b.getPlace());
        e.setProperty("legDiameter", new Float(b.getLegDiameter()));
        e.setProperty("wingSize", new Float(b.getWingSize()));
        e.setProperty("eggs", new Integer(b.getEggs()));
        e.setProperty("hatches", new Integer(b.getHatches()));
        db.put(e);
    }

    private Bird jsonToBird(HttpServletRequest req) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = req.getReader();
        String jsonString;
        while ((jsonString = br.readLine()) != null) {
            sb.append(jsonString);
        }
        jsonString = sb.toString();
        Bird b = g.fromJson(jsonString, Bird.class);
        saveBirdToDatastore(b);
        return b;
    }

    private List<Bird> getListfromDatastoreQuery(Query q) {
        List<Bird> birdList = new LinkedList<>();
        PreparedQuery pq = db.prepare(q);
        for (Entity ent : pq.asIterable()) {
            Bird b = new Bird(ent.getProperty("id").toString(), ent.getProperty("specie").toString(), ent.getProperty("place").toString(), new Float(ent.getProperty("legDiameter").toString()), new Float(ent.getProperty("wingSize").toString()), new Integer(ent.getProperty("eggs").toString()), new Integer(ent.getProperty("hatches").toString()));
            birdList.add(b);
        }
        return birdList;
    }

    private Bird getBirdfromDatastoreQuery(Query q) {
        try {
            PreparedQuery pq = db.prepare(q);
            Entity ent = pq.asSingleEntity();
            Bird b = new Bird(ent.getProperty("id").toString(), ent.getProperty("specie").toString(), ent.getProperty("place").toString(), new Float(ent.getProperty("legDiameter").toString()), new Float(ent.getProperty("wingSize").toString()), new Integer(ent.getProperty("eggs").toString()), new Integer(ent.getProperty("hatches").toString()));
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    private Boolean checkIfBirdExists(Bird b) {
        Query q = new Query("bird").setFilter(new Query.FilterPredicate("id", Query.FilterOperator.EQUAL, b.getId()));
        return getBirdfromDatastoreQuery(q) != null;
    }
}