package generics.compensating_for_erasure;

import java.lang.reflect.Array;

/**
 * For new code, you should pass in a type token.
 *
 * @author Thomson Tang
 * @version Created ：2016-04/10/2016-22:25
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int size) {
        this.array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }
}
