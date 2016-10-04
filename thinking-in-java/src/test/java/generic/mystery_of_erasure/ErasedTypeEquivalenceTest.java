package generic.mystery_of_erasure;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * 泛型类{@code ArrayList<String>}和{@code ArrayList<Integer>}的实际类型是相同的，都是{@code ArrayList}
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
