package es.us.isa.aml.test.core;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.Store;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.util.Util;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author AntonioGamez
 *
 */
public class TestStore {

    @Test
    public void testCreation1() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        //MODO_1:
        String path1 = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template1 = m.createAgreementTemplateFromFile(path1);
        Assert.assertNotNull(template1);
    }

    @Test
    public void testCreation2() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        //MODO_2:
        String path2 = "src/test/resources/core-pack/iagree-core.at";
        String content2 = Util.loadFile(path2);
        AgreementTemplate template2 = m.createAgreementTemplate(content2);
        Assert.assertNotNull(template2);
    }

    @Test
    public void testRegistration1() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        //MODO_1:
        String path1 = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template1 = m.createAgreementTemplateFromFile(path1);
        m.registerTemplate(template1);
        AgreementTemplate template1R = m.getAgreementTemplate();
        Assert.assertNotNull(template1R);
    }

    @Test
    public void testRegistration2a() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        //MODO_2a:
        String path2a = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template2a = m.createAgreementTemplateFromFile(path2a);
        s.register(template2a);
        AgreementTemplate template2aR = s.getAgreementTemplate(template2a.getID());
        Assert.assertNotNull(template2aR);
    }

    @Test
    public void testRegistration2b() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        //MODO_2b:
        String path2b = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template2b = m.createAgreementTemplateFromFile(path2b);
        s.register("hola", template2b);
        AgreementTemplate template2bR = s.getAgreementTemplate("hola");
        Assert.assertNotNull(template2bR);
    }

    @Test
    public void testRegistration3a() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        //MODO_3a
        String path3a = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template3a = m.createAgreementTemplateFromFile(path3a);
        s.register(template3a);
        AgreementTemplate template3aR = s.getAgreementTemplate(template3a.getID());
        Assert.assertNotNull(template3aR);
    }

    @Test
    public void testRegistration3b() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        //MODO_3b
        String path3b = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template3b = m.createAgreementTemplateFromFile(path3b);
        s.register("hola", template3b);
        AgreementTemplate template3bR = s.getAgreementTemplate("hola");
        Assert.assertNotNull(template3bR);
    }

    @Test
    public void testAll() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        String path = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template = m.createAgreementTemplateFromFile(path);

        s.register("plantilla", template);

        s.register("oferta", s.getAgreementTemplate("plantilla").generateAgreementOffer("cliente"));
        
        AgreementOffer offer = s.getAgreementOffer("oferta");

        Assert.assertNotNull(template);
        Assert.assertNotNull(offer);

    }

}
