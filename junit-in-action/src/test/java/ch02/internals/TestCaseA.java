package ch02.internals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A dummy test case to demonstrate how to use test-suit.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 5/31/13
 */
public class TestCaseA {

    @Test
    public void testA1() {
        assertEquals("CaseA.testA1", 1 + 2, 3);
    }
}
