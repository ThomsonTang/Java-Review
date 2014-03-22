package holding;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test case for LinkedListStack.
 *
 * @author ThomsonTang
 * @date 12/28/13
 */
public class LinkedListStackTest {
    private LinkedListStack<String> stack;

    @Before
    public void initial() {
        stack = new LinkedListStack<>();
    }

    @Test
    public void testStackMethod() {
        stack.push("thomson");
        stack.push("clover");

        assertEquals("size: ", 2, stack.size());
        assertEquals("pop: ", "clover", stack.pop());
        assertEquals("top: ", "thomson", stack.top());
        assertFalse("not empty: ", stack.isEmpty());
        assertEquals("pop again: ", "thomson", stack.pop());
        assertTrue("is empty: ", stack.isEmpty());
    }
}
