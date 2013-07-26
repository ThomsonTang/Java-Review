package fundamentals.stacksAndQueues;

import standardlib.StdIn;
import standardlib.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic stack implementation with a fixed-size array.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/23/13
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a; //holds the items
    private int N; //number of items in stack

    //create an empty stack with given capacity.
    public ResizingArrayStack() {
        a = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public int size() {
        return N;
    }

    //resize the underlying array holding the elements.
    public void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    //delete and return the item most recently added.
    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("stack underflow");
        Item item = a[N - 1];
        a[N - 1] = null;
        N--;
        //shrink size of array is necessary.
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = N;
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }

        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
