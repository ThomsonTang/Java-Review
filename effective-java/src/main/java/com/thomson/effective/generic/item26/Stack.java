package com.thomson.effective.generic.item26;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Object-based collection - a prime candidate for generics.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/16/13
 */
public class Stack {
    private static final int DEFAULT_INITITAL_CAPACITY = 16;

    private Object[] elements;
    private int size = 0;

    public Stack() {
        elements = new Object[DEFAULT_INITITAL_CAPACITY];
    }

    public void push(Object element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object element = elements[--size];
        elements[size] = null; //eliminate obsolete reference
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
