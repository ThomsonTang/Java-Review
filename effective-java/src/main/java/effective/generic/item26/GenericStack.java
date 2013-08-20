package effective.generic.item26;

import java.lang.Integer;
import java.lang.Iterable;
import java.lang.Number;
import java.util.*;

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

    //Wildcard type for parameter that serves as an E producer
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    //Wildcard type for parameter that serves as an E consumer
    public void popAll(Collection<? super E> des) {
        des.add(pop());
    }

    public static void main(String[] args) {
//        GenericStack<String> stack = new GenericStack<String>();
//        args = new String[]{"first", "second", "third"};
//        for (String arg : args) {
//            stack.push(arg);
//        }
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop().toUpperCase());
//        }

        GenericStack<Number> numberGenericStack = new GenericStack<Number>();
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        Iterable<Integer> integers = integerList;

        numberGenericStack.pushAll(integers);

        List<Object> list = new ArrayList<Object>();
        numberGenericStack.popAll(list);
    }
}
