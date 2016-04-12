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
 ******************************************************************************
 */
package es.us.isa.aml.test.core;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.operations.core.csp.ExistInconsistencies;
import es.us.isa.aml.operations.core.csp.WhyAreNotCompliant;
import es.us.isa.aml.operations.noCore.ExistCondInconsTerms;
import es.us.isa.aml.operations.noCore.ExistDeadTerms;
import es.us.isa.aml.operations.core.OperationResult;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jdelafuente
 *
 */
public class TestAzureCompliance {

    private static AgreementManager service;
    private static AgreementTemplate TSCTemplate;
    private static AgreementOffer TSCCompliant;

    @BeforeClass
    public static void init() {
        service = new AgreementManager();
        TSCTemplate = service
                .createAgreementTemplateFromFile("src/test/resources/core-pack/TSCTemplate.at");
        TSCCompliant = service
                .createAgreementOfferFromFile("src/test/resources/core-pack/TSCCompliant.ao");
    }

    @Test
    public void testValidation() {
        assertTrue(TSCTemplate.isValid());
        //System.out.println("isValid?: "+TSCCompliant.isValid());
        assertTrue(TSCCompliant.isValid()); //has dead terms
    }

    @Test
    public void testInconsistencyOperation() {
        ExistInconsistencies op = new ExistInconsistencies();
        op.analyze(TSCTemplate);
        assertFalse(op.getResult().getExistInconsistencies());

        op.analyze(TSCCompliant);
        assertFalse(op.getResult().getExistInconsistencies());
    }

    @Test
    public void testDeadTermsOperation() {
        ExistDeadTerms op = new ExistDeadTerms();
        op.analyze(TSCTemplate);
        assertFalse(op.getResult().getExistDeadTerms());

        op.analyze(TSCCompliant);
        assertFalse(op.getResult().getExistDeadTerms());
    }

    @Test
    public void testCondInconsistentOperation() {
        ExistCondInconsTerms op = new ExistCondInconsTerms();
        op.analyze(TSCTemplate);
        assertFalse(op.getResult().getExistCondInconsTerms());

        op.analyze(TSCCompliant);
        assertFalse(op.getResult().getExistCondInconsTerms());
    }

    @Test
    public void testAreCompliant1() {
        AreCompliant op = new AreCompliant();
        op.analyze(TSCTemplate, TSCCompliant);
        OperationResult resp = op.getResult();
        assertTrue(resp.getCompliant());
    }

    @Test
    public void testWhyAreNotCompliant1() {
        WhyAreNotCompliant op = new WhyAreNotCompliant();
        op.analyze(TSCTemplate, TSCCompliant);
        OperationResult resp = op.getResult();
        assertTrue(resp.getCompliant());
    }
}
