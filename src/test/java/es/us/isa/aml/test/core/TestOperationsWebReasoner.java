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

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.operations.core.OperationResult;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.operations.core.csp.ExistInconsistencies;
import es.us.isa.aml.operations.core.csp.WhyAreNotCompliant;
import es.us.isa.aml.operations.noCore.ExistCondInconsTerms;
import es.us.isa.aml.operations.noCore.ExistDeadTerms;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.ReasonerType;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jdelafuente
 *
 */
public class TestOperationsWebReasoner {

    private static AgreementManager service;
    private static AgreementTemplate model1, model2, model3, model4, model5, azureTemplate, TSCTemplate;
    private static AgreementOffer model6, azureOffer1, azureOffer2, azureOffer3, azureOffer4, TSCCompliant;

    @BeforeClass
    public static void init() {
        service = new AgreementManager();

        Config.getInstance().setCSPReasoner(ReasonerType.CSPWebReasoner);

        model1 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/iagree-core.at");
        model2 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/inconsistent.at");
        model3 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/dead-terms.at");
        model4 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/cond-inconsistent.at");
        model5 = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/compliant-template.at");
        model6 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/compliant-offer.ao");
        azureOffer1 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/azure-compliantOffer.ao");
        azureOffer2 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/azure-non-Compliant1.ao");
        azureOffer3 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/azure-non-Compliant2.ao");
        azureOffer4 = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/azure-non-Compliant3.ao");
        azureTemplate = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/azure-template.at");
        TSCTemplate = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/TSCTemplate.at");
        TSCCompliant = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/TSCCompliant.ao");
    }

    @Test
    public void testValidation() {
        assertTrue(model1.isValid());
        assertFalse(model2.isValid());
        assertFalse(model3.isValid());
        assertFalse(model4.isValid());
        assertTrue(model5.isValid());
        assertTrue(model6.isValid());
        assertTrue(azureOffer1.isValid());
        assertTrue(azureOffer2.isValid());
        assertTrue(azureOffer3.isValid());
        assertTrue(azureOffer4.isValid());
        assertTrue(azureTemplate.isValid());
        assertTrue(TSCTemplate.isValid());
        assertTrue(TSCCompliant.isValid());
    }

    @Test
    public void testInconsistencyOperation() {
        ExistInconsistencies op = new ExistInconsistencies();
        op.analyze(model1);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(model2);
        assertTrue(op.getResult().getExistInconsistencies());

        op.analyze(model3);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(model4);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(model5);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(model6);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(azureOffer1);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(azureOffer2);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(azureOffer3);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(azureOffer4);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(azureTemplate);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(TSCTemplate);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(TSCCompliant);
        assertFalse(op.getResult().getExistInconsistencies());
    }

    @Test
    public void testDeadTermsOperation() {
        ExistDeadTerms op = new ExistDeadTerms();
        op.analyze(model1);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(model2);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(model3);
        assertTrue(op.getResult().getExistDeadTerms());

        op.analyze(model4);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(model5);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(model6);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(azureOffer1);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(azureOffer2);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(azureOffer3);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(azureOffer4);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(azureTemplate);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(TSCTemplate);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(TSCCompliant);
        assertFalse(op.getResult().getExistDeadTerms());
    }

    @Test
    public void testCondInconsistentOperation() {
        ExistCondInconsTerms op = new ExistCondInconsTerms();
        op.analyze(model1);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(model2);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(model3);
        // TODO here cond incons should be false
        assertTrue(op.getResult().getExistCondInconsTerms());

        op.analyze(model4);
        assertTrue(op.getResult().getExistCondInconsTerms());

        op.analyze(model5);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(model6);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(azureOffer1);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(azureOffer2);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(azureOffer3);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(azureOffer4);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(azureTemplate);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(TSCTemplate);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(TSCCompliant);
        assertFalse(op.getResult().getExistCondInconsTerms());
    }

    @Test
    public void testAreCompliant1() {
        AreCompliant op = new AreCompliant();
        op.analyze(model5, model6);
        assertTrue(op.getResult().getCompliant());
    }

    @Test
    public void testAreCompliant2() {
        AreCompliant op = new AreCompliant();
        op.analyze(azureTemplate, azureOffer1);
        assertTrue(op.getResult().getCompliant());
    }

    @Test
    public void testAreCompliant3() {
        AreCompliant op = new AreCompliant();
        op.analyze(azureTemplate, azureOffer2);
        assertFalse(op.getResult().getCompliant());
    }

    @Test
    public void testAreCompliant4() {
        AreCompliant op = new AreCompliant();
        op.analyze(azureTemplate, azureOffer3);
        assertFalse(op.getResult().getCompliant());
    }

    @Test
    public void testAreCompliant5() {
        AreCompliant op = new AreCompliant();
        op.analyze(azureTemplate, azureOffer4);
        assertFalse(op.getResult().getCompliant());
    }

    @Test
    public void testAreCompliant6() {
        AreCompliant op = new AreCompliant();
        op.analyze(TSCTemplate, TSCCompliant);
        assertTrue(op.getResult().getCompliant());
    }

    @Test
    public void testWhyAreNotCompliant1() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(azureTemplate, azureOffer1);
        assertTrue(op.getResult().getCompliant());
    }

    @Test
    public void testWhyAreNotCompliant2() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(azureTemplate, azureOffer2);
        OperationResult result = op.getResult();
        assertFalse(result.getCompliant());
        assertTrue(result.getConflictType().equalsIgnoreCase("contradictory offer term"));
        assertTrue(result.getAffectedTerms().get(0).equalsIgnoreCase("G1: MUP >= 999;"));
    }

    @Test
    public void testWhyAreNotCompliant3() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(azureTemplate, azureOffer3);
        OperationResult res = op.getResult();
        assertFalse(res.getCompliant());
        assertTrue(res.getConflicts().toString().equalsIgnoreCase("[G1: MUP >= 9999;]"));
        assertTrue(res.getConflictType().equalsIgnoreCase("more restrictive offer term"));
        assertTrue(res.getAffectedTerms().get(0).equalsIgnoreCase("G1: MUP >= 999;"));
    }

    @Test
    public void testWhyAreNotCompliant4() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(azureTemplate, azureOffer4);
        OperationResult res = op.getResult();
        assertFalse(res.getCompliant());
        assertTrue(res.getConflicts().toString().equalsIgnoreCase("[ASSIG_Price: Price == 10000;]"));
        assertTrue(res.getConflictType().equalsIgnoreCase("contradictory offer term"));
        assertTrue(res.getAffectedTerms().get(0).equalsIgnoreCase("C2: Price == 1192 * MPI;"));
    }

    @Test
    public void testWhyAreNotCompliant5() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(TSCTemplate, TSCCompliant);
        OperationResult res = op.getResult();
        assertTrue(res.getCompliant());
    }
}
