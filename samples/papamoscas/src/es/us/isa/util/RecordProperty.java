package es.us.isa.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Applied Software Engineering Research Group (ISA Group)
 * University of Sevilla, Spain
 *
 * @author Manuel Arenillas <marenillas@us.es>
 * @version 1.0
 */


public class RecordProperty {
    private static RecordProperty instance;
    private static Map<String, Map<String, Map<Date, Object>>> mapP;

    public RecordProperty() {
        mapP = new HashMap();
    }

    public static RecordProperty getInstance() {
        if (instance == null) {
            instance = new RecordProperty();

        }
        return instance;
    }

    public Map<Date, Object> getPropertyMark(String clientId, String propertyId) {

        return mapP.get(clientId).get(propertyId);
    }

    public Boolean existProperty(String clientID, String propertyId) {
        Boolean bol = false;
        if (mapP.containsKey(clientID)) {
            if (mapP.get(clientID).containsKey(propertyId)) {
                bol = true;
            } else {
                bol = false;
            }
        } else {
            bol = false;
        }
        return bol;
    }

    public void putPropertyMark(String clientId, String propertyId, Object b1) {
        Date timestamp = new Date();

        if (mapP.containsKey(clientId)) {
            if (mapP.get(clientId).containsKey(propertyId)) {
                //Si la marca ya tiene un valor registrado no hacer nada
                if (!mapP.get(clientId).get(propertyId).containsKey(timestamp)) {
                    mapP.get(clientId).get(propertyId).put(timestamp, b1);
                }
            } else {
                Map<Date, Object> mp1 = new HashMap();
                mp1.put(timestamp, b1);


                mapP.get(clientId).put(propertyId, mp1);
            }

        } else {


            Map<Date, Object> mp1 = new HashMap();
            mp1.put(timestamp, b1);

            Map<String, Map<Date, Object>> mp2 = new HashMap();
            mp2.put(propertyId, mp1);


            mapP.put(clientId, mp2);
        }
    }


}
