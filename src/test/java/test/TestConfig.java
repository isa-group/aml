///**
// *
// */
//package test;
//
//import es.us.isa.aml.util.Config;
//import es.us.isa.aml.util.Util;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;
//
///**
// * @author jdelafuente
// *
// */
//public class TestConfig {
//
//    @Test
//    public void testLoadConfig() {
//        Map<String, String> mapTest = new HashMap<>();
//        mapTest.put("CSPReasoner", "CPLEX");
//        mapTest.put("defaultInputFormat", "IAGREE");
//
//        loadData();
//
//        assertEquals(mapTest.get("CSPReasoner"), Config.getProperty("CSPReasoner"));
//        assertEquals(mapTest.get("defaultInputFormat"), Config.getProperty("defaultInputFormat"));
//
//        Config.setProperty("hola", "prueba");
//        assertEquals(Config.getProperty("hola"), "prueba");
//
//        loadData(); //reset to original properties
//
//        assertEquals(Config.getProperty("hola"), "");
//
//    }
//
//    @Test(expected = Exception.class)
//    public void testLoadConfigBadJson() throws IOException, NullPointerException {
//        String json = "{'CSPReasoner':'cplex','otraCosa':'algo',{}}";
//        Config.getProperty("CSPReasoner");
//
//    }
//
//    private void loadData() {
//        //String json = "{" + " \"CSPReasoner\": \"cplex\"," + "\"otraCosa\": \"algo\"" + "}";
//        try {
//            String json = Util.loadFile("src/test/resources/config.json");
//            Config.loadConfig(json);
//        } catch (IOException ex) {
//            Logger.getLogger(TestConfig.class.getName()).log(Level.WARNING, null, ex);
//        }
//    }
//
//}
