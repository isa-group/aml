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


public class RecordGuarantee {

    private static RecordGuarantee instance;
    private static Map<String, Map<String, Map<Date, Boolean>>> mapG;

    public RecordGuarantee() {
        mapG = new HashMap();
    }

    public static RecordGuarantee getInstance() {
        if (instance == null) {
            instance = new RecordGuarantee();

        }
        return instance;
    }

    public Map<Date, Boolean> getGuaranteeMark(String clientId, String guaranteeId) {

        return mapG.get(clientId).get(guaranteeId);
    }


    public Boolean existGuarantee(String clientID, String guaranteeId) {
        Boolean bol = false;
        if (mapG.containsKey(clientID)) {
            if (mapG.get(clientID).containsKey(guaranteeId)) {
                bol = true;
            } else {
                bol = false;
            }
        } else {
            bol = false;
        }
        return bol;
    }

    public void putGuanrateeMark(String clientId, String guaranteeId, Boolean b1) {

        Date timestamp = new Date();

        if (mapG.containsKey(clientId)) {
            if (mapG.get(clientId).containsKey(guaranteeId)) {
                //Si la marca ya tiene un valor registrado no hacer nada
                if (!mapG.get(clientId).get(guaranteeId).containsKey(timestamp)) {
                    mapG.get(clientId).get(guaranteeId).put(timestamp, b1);
                }
            } else {
                Map<Date, Boolean> mp1 = new HashMap();
                mp1.put(timestamp, b1);


                mapG.get(clientId).put(guaranteeId, mp1);
            }

        } else {


            Map<Date, Boolean> mp1 = new HashMap();
            mp1.put(timestamp, b1);

            Map<String, Map<Date, Boolean>> mp2 = new HashMap();
            mp2.put(guaranteeId, mp1);


            mapG.put(clientId, mp2);
        }
    }


}
