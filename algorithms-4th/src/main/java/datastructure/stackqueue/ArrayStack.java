package datastructure.stackqueue;

public class ArrayStack implements Stack {
    private Object[] theArray;
    private int topOfStack;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        theArray = new Object[DEFAULT_CAPACITY];
        topOfStack = -1;
    }

    public boolean isEmpty() {
        return topOfStack == -1;
    }

    public void push(Object obj) {
        if(!isFull()) {
            theArray[++topOfStack] = obj;
        }
    }

    public Object pop() {
        if(!isEmpty()) {
            return theArray[topOfStack--];
        } else {
            return null;
        }
    }
    
    public Object top() {
        if(!isEmpty()) {
            return theArray[topOfStack];
        } else {
            return null;
        }
    }

    public boolean isFull() {
        return (topOfStack == theArray.length);
    }
}
