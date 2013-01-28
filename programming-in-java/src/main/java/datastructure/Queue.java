package datastructure;

/*******************************************************
 * A generic queue, implemented using a linked list.
 ******************************************************/
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private int N; //number of elements on queue.
    private Node first; //beginning of queue.
    private Node last; //end of queue.

    //helper linked list class.
    private class Node {
        private Item item;
        private Node node;
    }

    /**
     * Create an empty queue.
     */
    public Queue() {
        first = null;
        last = null;
    }

    /**
     * Is the queue empty
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in the queue.
     */
    public int size() {
        return N;
    }

    /**
     * return the item least recently added to the queue.
     * throw an exception if the queue is empty.
     */
    public Item peek() {
        if(isEmpty()) throw new RuntimeException("Queue underflow!");
        return first.item;
    }

    /**
     * Add the item to the queue.
     */
    public void enqueue(Item item) {
        Node x = new Node();
        x.item = item;
        if(isEmpty()) {
            first = x;
            last = x;
        } else {
            last.next = x;
            last = x;
        }
        N++;
    }

    /**
     * Remove and return the item on the queue least recently added.
     * Throw an exception if the queue is empty.
     */
    public Item dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue underflow!");
        }
        Item item = first.item;
        first = first.next;
        N--;
        if(isEmpty()) last = null;
        return item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Item item : this) {
            sb.append(item + " ");
        }
        return sb.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        while(!StdIn.isEmpty()) {
            
        }
    }

}
