package generics.compensating_for_erasure;

/**
 * 泛型化数组
 *
 * @author Thomson Tang
 * @version Created ：2016-04/10/2016-21:24
 */

class Generic<T> {

}

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
//        gia = (Generic<Integer>[]) new Object[SIZE]; //Compiles, but produces ClassCastException
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
//        gia[1] = new Object();  //Compile-time error
//        gia[2] = new Generic<Double>(); //Compile-time error, type mismatch
    }
}
