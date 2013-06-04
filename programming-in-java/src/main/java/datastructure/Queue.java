package datastructure;

/*******************************************************
 * A generic queue, implemented using a linked list.
 ******************************************************/
import java.util.Iterator;

public class Queue<E> implements Iterable<E> {
    private int N; //number of elements on queue.
    private Node first; //beginning of queue.
    private Node last; //end of queue.

    //helper linked list class.
    private class Node {
        private E item;
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
    public E peek() {
        if(isEmpty()) throw new RuntimeException("Queue underflow!");
        return first.item;
    }

    /**
     * Add the item to the queue.
     */
    public void enqueue(E item) {
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
    public E dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue underflow!");
        }
        E item = first.item;
        first = first.next;
        N--;
        if(isEmpty()) last = null;
        return item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(E item : this) {
            sb.append(item + " ");
        }
        return sb.toString();
    }

    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.item;
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
