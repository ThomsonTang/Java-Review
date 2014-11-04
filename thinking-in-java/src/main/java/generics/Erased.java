package generics;

/**
 * Compensating for erasure
 *
 * erasure loses the ability to perform certain operations in generic code.
 *
 * @author Thomson Tang
 */
public class Erased<T> {
    private final int SIZE = 100;

    public void f(Object obj) {
        //        if (obj instanceof T) {} // error
        //        T var = new T(); // error
        T[] array = (T[]) new Object[SIZE];
    }
}
