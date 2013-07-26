package fundamentals.stacksAndQueues;

import standardlib.StdIn;
import standardlib.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/24/13
 */
public class Stack<Item> implements Iterable<Item> {
    private int N; //size of stack
    private Node first; //top node of stack

    //helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * create an empty stack.
     */
    public Stack() {
        first = null;
        N = 0;
        assert check();
    }

    /**
     * Is the stack empty.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * @return the number of items in the stack.
     */
    public int size() {
        return N;
    }

    /**
     * Add item to the stack.
     *
     * @param item
     */
    public void push(Item item) {
        Node originalFirst = first;
        first = new Node();
        first.item = item;
        first.next = originalFirst;
        N++;
        assert check();
    }

    /**
     * Delete and return the item most recently added to the stack.
     *
     * @return the item most recently added to stack
     */
    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("stack underflow");
        Item item = first.item;
        first = first.next;
        N--;
        assert check();
        return item;
    }

    /**
     * @return the item most recently added to the stack
     */
    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("stack underflow");
        return first.item;
    }

    /**
     * @return string representation.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this)
            sb.append(item + " ");
        return sb.toString();
    }

    //check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null)
                return false;
        } else if (N == 1) {
            if (first == null)
                return false;
            if (first.next != null)
                return false;
        } else {
            if (first.next == null)
                return false;
        }

        int numberOfNodes = 0;
        for (Node n = first; n != null; n = n.next) {
            numberOfNodes++;
        }
        return numberOfNodes == N;
    }


    /**
     * @return an iterator to the stack that iterates through the items in LIFO order.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack.)");
    }
}
