package generics.compensating_for_erasure;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created ：2016-04/10/2016-21:35
 */
public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int size) {
        this.array = (T[]) new Object[size];
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
