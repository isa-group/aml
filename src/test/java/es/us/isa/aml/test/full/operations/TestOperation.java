/**
 * 
 */
package es.us.isa.aml.test.full.operations;

import java.io.File;

import es.us.isa.aml.model.AgreementModel;

/**
 * @author jdelafuente
 *
 */
public interface TestOperation {

	public int[] execute(AgreementModel model, File currentFile,
			String expectedResult, StringBuilder log);
	
	public int[] execute(AgreementModel model, AgreementModel model2, File currentFile,
			String expectedResult, StringBuilder log);

}
