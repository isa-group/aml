/**
 *
 */
package test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.model.CreationConstraint;
import es.us.isa.aml.model.expression.CompoundExpression;
import es.us.isa.aml.util.Util;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author AntonioGamez
 *
 */
public class OtherTests {

    private static final Logger LOG = Logger.getLogger(TestLibLocal.class.getName());
    private static AgreementManager serv;
    private static AgreementTemplate model1;

    @BeforeClass
    public static void init() {
        serv = new AgreementManager(Util.loadFile("src/test/resources/config.json"));

        model1 = serv.createAgreementTemplateFromFile("src/test/resources/samples/iagree-core.at");

    }

    /* @Test
     public void testCloneA() {
     model1.setID("original");
     assertEquals(model1.getID(), "original");
     AgreementOffer modelCopyO = new AgreementOffer(model1);
     AgreementTemplate modelCopyT = new AgreementTemplate(model1);
     assertEquals(modelCopyT.getID(), "original");
     assertEquals(modelCopyO.getID(), "original");
     modelCopyT.setID("modificado");
     modelCopyO.setID("modificado");
     assertEquals(modelCopyT.getID(), "modificado");
     assertEquals(modelCopyO.getID(), "modificado");
     assertEquals(model1.getID(), "original");

     //LOG.log(Level.INFO, "PRINT: {0}", modelCopyT.getAgreementTerms().getGuaranteeTerms());
     System.out.println("\n\n");
     //LOG.log(Level.INFO, "PRINT: {0}", modelCopyO.getAgreementTerms().getGuaranteeTerms());
     }*/
    /* @Test
     public void testCloneB() {
     model1.setID("original");
     assertEquals(model1.getID(), "original");
     AgreementModel modelCopy = model1.clone();
     assertEquals(modelCopy.getID(), "original");
     modelCopy.setID("modificado");
     assertEquals(modelCopy.getID(), "modificado");
     assertEquals(model1.getID(), "original");
     }*/
    @Test
    public void testModifyGT() {
        assertNotNull(model1.getContext());
        assertNotNull(model1.getAgreementTerms());
        assertNotNull(model1.getCreationConstraints());
        for (CreationConstraint c : model1.getCreationConstraints()) {
            assertNotNull(c);
            CompoundExpression ce = (CompoundExpression) c.getSlo().getExpression();
            assertNotNull(ce.getExpresion1());
            assertNotNull(ce.getExpresion2());
            assertNotNull(ce.getExpressions());
            assertNotNull(ce.getOperator());

        }
    }
}
