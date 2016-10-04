package generics.myster_of_erasure;

import java.lang.reflect.Array;

/**
 * <h1>The action of the boundaries</h1>
 *
 * Note that using {@link Array#newInstance(Class, int)} is the recommended approach for creating arrays in generics.
 *
 * @author Thomson Tang
 * @version Created ：2016-03/10/2016-17:53
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }
}
