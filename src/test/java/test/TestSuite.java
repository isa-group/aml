/**
 *
 */
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author jdelafuente
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestExpression.class,
    TestIAgreeParser.class,
    TestConfig.class,
    TestLibLocal.class,
    TestStore.class
})

public class TestSuite {
    /* empty class */
}
