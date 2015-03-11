///**
// *
// */
//package test;
//
//import es.us.isa.aml.AgreementManager;
//import es.us.isa.aml.model.AgreementModel;
//import es.us.isa.aml.model.AgreementOffer;
//import es.us.isa.aml.model.AgreementTemplate;
//import es.us.isa.aml.model.CreationConstraint;
//import es.us.isa.aml.model.expression.CompoundExpression;
//import es.us.isa.aml.util.Util;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// * @author AntonioGamez
// *
// */
//public class OtherTests {
//
//    private static final Logger LOG = Logger.getLogger(TestLibLocal.class.getName());
//    private static AgreementManager serv;
//    private static AgreementTemplate model1;
//    private static AgreementTemplate model2;
//    private static AgreementTemplate model3;
//    private static AgreementTemplate modeldead;
//
//    @BeforeClass
//    public static void init() {
//        serv = new AgreementManager(Util.loadFile("src/test/resources/config.json"));
//
//        model1 = (AgreementTemplate) serv.createAgreementTemplate(Util.loadFile("src/test/resources/samples/iagree/AmazonS3-medium.at"));
//        model2 = (AgreementTemplate) serv.createAgreementTemplate(Util.loadFile("src/test/resources/samples/iagree/AmazonS3.at"));
//        model3 = (AgreementTemplate) serv.createAgreementTemplate(Util.loadFile("src/test/resources/samples/iagree/AmazonS3_inc.at"));
//        modeldead = (AgreementTemplate) serv.createAgreementTemplate(Util.loadFile("src/test/resources/samples/iagree/AmazonS3-dead.at"));
//
//    }
//
//    @Test
//    public void testIsValid() {
//
////        LOG.log(Level.INFO, "Showing model: \n{0}", model1);
////        LOG.log(Level.INFO, "Showing model: \n{0}", model2);
////        LOG.log(Level.INFO, "Showing model: \n{0}", model3);
////
////        LOG.log(Level.INFO, "model1a: {0}", serv.isValid(model1));
////        LOG.log(Level.INFO, "model2a: {0}", serv.isValid(model2));
////        LOG.log(Level.INFO, "model3a: {0}", serv.isValid(model3));
////
////        LOG.log(Level.INFO, "model1b: {0}", model1.isValid());
////        LOG.log(Level.INFO, "model2b: {0}", model2.isValid());
////        LOG.log(Level.INFO, "model3b: {0}", model3.isValid());
//        assertFalse(serv.isValid(model1));
//        //assertTrue(serv.isValid(model2));
//        assertFalse(serv.isValid(model3));
//
//        assertFalse(model1.isValid());
////        assertTrue(model2.isValid());
//        assertFalse(model3.isValid());
//
//    }
//
//    @Test
//    public void testCloneA() {
//        model1.setID("original");
//        assertEquals(model1.getID(), "original");
//        AgreementModel modelCopyO = new AgreementOffer(model1);
//        AgreementModel modelCopyT = new AgreementTemplate(model1);
//        assertEquals(modelCopyT.getID(), "original");
//        assertEquals(modelCopyO.getID(), "original");
//        modelCopyT.setID("modificado");
//        modelCopyO.setID("modificado");
//        assertEquals(modelCopyT.getID(), "modificado");
//        assertEquals(modelCopyO.getID(), "modificado");
//        assertEquals(model1.getID(), "original");
//
//        //LOG.log(Level.INFO, "PRINT: {0}", modelCopyT.getAgreementTerms().getGuaranteeTerms());
//        System.out.println("\n\n");
//        //LOG.log(Level.INFO, "PRINT: {0}", modelCopyO.getAgreementTerms().getGuaranteeTerms());
//    }
//
//    @Test
//    public void testCloneB() {
//        model1.setID("original");
//        assertEquals(model1.getID(), "original");
//        AgreementModel modelCopy = model1.clone();
//        assertEquals(modelCopy.getID(), "original");
//        modelCopy.setID("modificado");
//        assertEquals(modelCopy.getID(), "modificado");
//        assertEquals(model1.getID(), "original");
//    }
//
//    @Test
//    public void testModifyGT() {
//        System.out.println("----------------------------\n\n\n");
//        for (CreationConstraint c : modeldead.getCreationConstraints()) {
//            System.out.println(c);
//            CompoundExpression ce = (CompoundExpression) c.getSlo().getExpression();
//            System.out.println(ce.getExpresion1());
//            System.out.println(ce.getExpresion2());
//            System.out.println(ce.getExpressions());
//            System.out.println(ce.getOperator());
//            System.out.println("-----");
//        }
//    }
//}
