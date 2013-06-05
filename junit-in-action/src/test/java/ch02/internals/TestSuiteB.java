package ch02.internals;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A demonstrate of test-suite.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/31/13
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {TestCaseB.class})
public class TestSuiteB {
}
