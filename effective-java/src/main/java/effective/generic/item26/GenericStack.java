package effective.generic.item26;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Initial attempt to generify stack
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/16/13
 */
public class GenericStack<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private E[] elements;
    //private Object[] elements; //solution 2
    private int size = 0;

    @SuppressWarnings("unchecked")
    public GenericStack() {
        //this.elements = new E[DEFAULT_INITIAL_CAPACITY]; // won't compile

        //solution 1, but it's not typesafe.
        //The elements arry will contain only E instances form push(E).
        //This is sufficient to ensure type safety, but the runtime type of the array
        //won't be E[], it will always be Object[].
        this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        //solution 2
        //push requires elements to be of type E, so cast is correct.
        //@SuppressWarnings("unchecked")
        //E e = (E)elements[--size];

        E e = elements[--size];
        elements[size] = null;
        return e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<String>();
        args = new String[]{"first", "second", "third"};
        for (String arg : args) {
            stack.push(arg);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
