package holding;

import java.util.LinkedList;

/**
 * Making a stack from LinkedList.
 *
 * @author ThomsonTang
 * @version 12/28/13
 */
public class LinkedListStack<T> {
    private LinkedList<T> storage = new LinkedList<>();

    public void push(T v) {
        storage.addFirst(v);
    }

    public T pop() {
        return storage.removeFirst();
    }

    public T top() {
        return storage.getFirst();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public int size() {
        return storage.size();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
