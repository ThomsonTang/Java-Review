package effective.concurrency.item67;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import effective.classesandinterfaces.item16.ForwardingSet;

/**
 * This class use a concurrent collection known as {@link java.util.concurrent.CopyOnWriteArrayList} provided in
 * JDK1.5.
 *
 * @author Thomson Tang
 * @version Created: 23/07/2017.
 */
public class BetterObservableSet<E> extends ForwardingSet<E> {
    // Thread-safe observable set with CopyOnWriteArrayList
    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

    public BetterObservableSet(Set<E> set) {
        super(set);
    }

    private void notifyElementAdded(E element) {
        for (SetObserver<E> observer : observers) {
            observer.added(this, element);
        }
    }

    public void addObserver(SetObserver<E> observer) {
        observers.add(observer);
    }

    public boolean removeObserver(SetObserver<E> observer) {
        return observers.remove(observer);
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementAdded(element);
        }
        return added;
    }
}
