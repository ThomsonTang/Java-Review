package fundamentals.stacksAndQueues;

import standardlib.StdIn;
import standardlib.StdOut;

import java.util.Iterator;

/**
 * Generic stack implementation with a fixed-size array.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/23/13
 */
public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] a; //holds the items
    private int N; //number of items in stack

    //create an empty stack with given capacity.
    public FixedCapacityStack(int capacity) {
        a = (Item[])new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<Item> {

        private int i = N - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            return a[i--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStack<String> stack = new FixedCapacityStack<String>(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (stack.isEmpty())
                StdOut.println("Bad Input!");
            else
                StdOut.println(stack.pop() + " ");
        }

        StdOut.println();
        StdOut.print("left on stack:");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
