/**
 *
 */
package test;

import java.util.logging.Logger;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.reasoners.CplexHandler;
import es.us.isa.aml.reasoners.CplexReasoner;
import es.us.isa.aml.util.Util;

/**
 * @author AntonioGamez
 *
 */
public class OtherTests {

    private static final Logger LOG = Logger.getLogger(TestLibLocal.class.getName());
    private static AgreementManager serv;
    private static AgreementTemplate model1;

    public static void main(String[] args) {
        serv = new AgreementManager(Util.loadFile("src/main/resources/defaultConfig.json"));

//        model1 = serv.createAgreementTemplateFromFile("src/test/resources/samples/test.opl");
        
        
         String content = Util.loadFile("src/test/resources/samples/test.opl");
         CplexHandler ch = new CplexHandler();
         ch.init();
         String solve = ch.solve(content);
         System.out.println(solve);
        

    }

//    @Test
//    public void testModifyGT() {
//        assertNotNull(model1.getContext());
//        assertNotNull(model1.getAgreementTerms());
//        assertNotNull(model1.getCreationConstraints());
//        for (CreationConstraint c : model1.getCreationConstraints()) {
//            assertNotNull(c);
//            CompoundExpression ce = (CompoundExpression) c.getSlo().getExpression();
//            assertNotNull(ce.getExpression1());
//            assertNotNull(ce.getExpression2());
//            assertNotNull(ce.getExpressions());
//            assertNotNull(ce.getOperator());
//
//        }
//    }
//
//    @Test
//    public void testRegisterFromFolder() {
//        assertTrue(serv.getStoreManager().getAgreementMap().keySet().isEmpty());
//        serv.getStoreManager().registerFromFolder("src/test/resources/samples", false);
//        assertFalse(serv.getStoreManager().getAgreementMap().keySet().isEmpty());
//    }
}
