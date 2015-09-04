/**
 *
 */
package es.us.isa.tests.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author jdelafuente
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestExpression.class,
    TestIAgreeModel.class,
    TestCSPModel.class,
    TestOperations.class,
    TestAzureCompliance.class,
    TestStore.class
})

public class TestSuite {
    /* empty class */
}
