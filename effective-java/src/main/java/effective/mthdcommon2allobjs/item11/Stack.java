package effective.mthdcommon2allobjs.item11;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Override clone judiciously
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/18/13
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INIT_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INIT_CAPACITY];
    }

    public void push(Object element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object element = elements[--size];
        elements[size] = null;
        return element;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    public Stack clone() {
        try {
            Stack result = (Stack)super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
