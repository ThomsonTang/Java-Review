package generics.compensating_for_erasure;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-04/10/2016-22:37
 */
public class GenericArrayTest2 {

    @org.junit.Test(expected = ClassCastException.class)
    public void testRep() {
        GenericArray<Integer> integerGenericArray = new GenericArray<>(10);
        Integer[] rep = integerGenericArray.rep();
    }
}