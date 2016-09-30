package generic.mystery_of_erasure;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-30/09/2016-08:40
 */
public class ErasedTypeEquivalenceTest {

    @Test
    public void testEquivalence() {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        assertEquals(c1, c2);
    }
}
