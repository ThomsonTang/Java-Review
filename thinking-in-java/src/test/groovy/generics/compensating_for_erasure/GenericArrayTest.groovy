package generics.compensating_for_erasure

import org.junit.Test

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-04/10/2016-21:38
 */
class GenericArrayTest {

    @Test
    void testGenericArrayGet() {
        GenericArray<Integer> array = new GenericArray<Integer>(10)
        Integer[] ia = array.rep()
        java.lang.Object[] oa = array.rep()
    }
}
