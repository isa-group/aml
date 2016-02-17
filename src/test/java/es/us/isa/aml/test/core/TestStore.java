/**
 * *****************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA Research Group - University of Sevilla, 2015 Licensed under
 * GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 * *****************************************************************************
 */
package es.us.isa.aml.test.core;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.Store;
import es.us.isa.aml.generator.BasicAgreementGenerator;
import es.us.isa.aml.model.Agreement;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.util.Util;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

/**
 * @author AntonioGamez
 *
 */
public class TestStore {

    @Test
    public void testCreation1() {
        AgreementManager m = new AgreementManager();

        // MODE_1:
        String path1 = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template1 = m.createAgreementTemplateFromFile(path1);
        assertNotNull(template1);
    }

    @Test
    public void testCreation2() {
        AgreementManager m = new AgreementManager();

        // MODE_2:
        String path2 = "src/test/resources/core-pack/iagree-core.at";
        String content2 = Util.loadFile(path2);
        AgreementTemplate template2 = m.createAgreementTemplate(content2);
        assertNotNull(template2);
    }

    @Test
    public void testRegistration1() {
        AgreementManager m = new AgreementManager();

        // MODE_1:
        String path1 = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template1 = m.createAgreementTemplateFromFile(path1);
        m.registerTemplate(template1);
        AgreementTemplate template1R = m.getAgreementTemplate();
        assertNotNull(template1R);
    }

    @Test
    public void testRegistration2a() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        // MODE_2a:
        String path2a = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template2a = m.createAgreementTemplateFromFile(path2a);
        s.register(template2a);
        AgreementTemplate template2aR = s.getAgreementTemplate(template2a.getID());
        assertNotNull(template2aR);
    }

    @Test
    public void testRegistration2b() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        // MODE_2b:
        String path2b = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template2b = m.createAgreementTemplateFromFile(path2b);
        s.register("test", template2b);
        AgreementTemplate template2bR = s.getAgreementTemplate("test");
        assertNotNull(template2bR);
    }

    @Test
    public void testRegistration3a() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        // MODE_3a
        String path3a = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template3a = m.createAgreementTemplateFromFile(path3a);
        s.register(template3a);
        AgreementTemplate template3aR = s.getAgreementTemplate(template3a.getID());
        assertNotNull(template3aR);
    }

    @Test
    public void testRegistration3b() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        // MODE_3b
        String path3b = "src/test/resources/core-pack/iagree-core.at";
        AgreementTemplate template3b = m.createAgreementTemplateFromFile(path3b);
        s.register("test", template3b);
        AgreementTemplate template3bR = s.getAgreementTemplate("test");
        assertNotNull(template3bR);
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

        assertNotNull(template);
        assertNotNull(offer);

    }

    @Test
    public void generateAgreementFromCompliantOffer() {
        AgreementManager m = new AgreementManager();
        Store s = m.getStoreManager();

        String pathT = "src/test/resources/core-pack/governify-multiplan.at";
        AgreementTemplate template = m.createAgreementTemplateFromFile(pathT);

        String pathO = "src/test/resources/core-pack/governify-proPlan.ao";
        AgreementOffer offer = m.createAgreementOfferFromFile(pathO);

        s.register("template", template);
        s.register("offer", offer);

        Agreement agreement = new BasicAgreementGenerator().generateAgreementFromCompliantAgreementOffer("client", offer, template);

        assertNotNull(template);
        assertNotNull(offer);
        assertNotNull(agreement);

    }

}
