package fundamentals.stacksAndQueues;

import standardlib.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Bag class represents a bag(or multiset) of generic items. It supports insertion
 * and iterating over the items in arbitrary order.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @date 12/26/13
 */
public class Bag<Item> implements Iterable<Item> {
    private int N; //number of elements in bag
    private Node<Item> first;

    //helper linked list class
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    // initialize
    public Bag() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    /**
     * Add the item to the bag.
     * @param item the item to add to this bag.
     */
    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
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
        Bag<String> bag = new Bag<>();
        for (int i = 0; i < 10; i++) {
            bag.add(i + "");
        }

        StdOut.println("size: " + bag.size());

        Iterator<String> iterator = bag.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            StdOut.print(s + ", ");
        }

        for (String s : bag) {
            StdOut.print(s + ", ");
        }
        StdOut.println();
    }
}
