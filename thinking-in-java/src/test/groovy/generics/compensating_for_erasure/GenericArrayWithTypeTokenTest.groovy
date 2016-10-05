package generics.compensating_for_erasure

import org.junit.Test

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-04/10/2016-22:29
 */
class GenericArrayWithTypeTokenTest{
    @Test
    void testRep() {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10)
        Integer[] ia = gai.rep()
    }
}
