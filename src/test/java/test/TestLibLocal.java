///**
// *
// */
//package test;
//
//import es.us.isa.aml.AgreementManager;
//import es.us.isa.aml.model.AgreementModel;
//import es.us.isa.aml.util.Util;
//import java.util.logging.Logger;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// * @author jdelafuente
// *
// */
//public class TestLibLocal {
//
//    private static final Logger LOG = Logger.getLogger(TestLibLocal.class.getName());
//    private static AgreementManager serv;
//    private static AgreementModel model1;
//    private static AgreementModel model2;
//    private static AgreementModel model3;
//
//    @BeforeClass
//    public static void init() {
//        serv = new AgreementManager(Util.loadFile("src/test/resources/config.json"));
//
//        model1 = serv.createAgreementTemplate(Util.loadFile("src/test/resources/samples/iagree/AmazonS3-medium.at"));
//        //model2 = serv.createAgreementTemplate(Util.loadFile("src/test/resources/samples/iagree/AmazonS3.at"));
//        //model3 = serv.createAgreementTemplate(Util.loadFile("src/test/resources/samples/iagree/AmazonS3_inc.at"));
//
//    }
//
//    @Test
//    public void testIsValid() {
//
//        /*LOG.log(Level.INFO, "Showing model: \n{0}", model1);
//         LOG.log(Level.INFO, "Showing model: \n{0}", model2);
//         LOG.log(Level.INFO, "Showing model: \n{0}", model3);
//
//         LOG.log(Level.INFO, "model1a: {0}", serv.isValid(model1));
//         LOG.log(Level.INFO, "model2a: {0}", serv.isValid(model2));
//         LOG.log(Level.INFO, "model3a: {0}", serv.isValid(model3));
//
//         LOG.log(Level.INFO, "model1b: {0}", model1.isValid());
//         LOG.log(Level.INFO, "model2b: {0}", model2.isValid());
//         LOG.log(Level.INFO, "model3b: {0}", model3.isValid());*/
//        assertFalse(serv.isValid(model1));
//       // assertTrue(serv.isValid(model2));
//       // assertFalse(serv.isValid(model3));
//
//       //assertFalse(model1.isValid());
//       // assertTrue(model2.isValid());
//       // assertFalse(model3.isValid());
//    }
//
//}
