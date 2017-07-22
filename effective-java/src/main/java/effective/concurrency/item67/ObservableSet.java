package effective.concurrency.item67;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import effective.classesandinterfaces.item16.ForwardingSet;

/**
 * This class implements an <strong>observable</strong> set wrapper. It allows clients to subscribe to notification When
 * elements are added to the set. This is the Observer pattern. For brevity's sake, the class does not provide
 * notifications when elements are removed from the set, but it would be a simple matter to provide them. This class is
 * implemented atop the reusable {@link effective.classesandinterfaces.item16.ForwardingSet} from the Item 16.
 *
 * @author Thomson Tang
 * @version Created: 19/07/2017.
 */
public class ObservableSet<E> extends ForwardingSet<E> {
    private final List<SetObserver<E>> observers = new ArrayList<>();

    // Broken - invokes alien method from synchronized block!
    private void notifyElementAdded(E element) {
        synchronized (observers) {
            for (SetObserver<E> observer : observers) {
                observer.added(this, element);
            }
        }
    }

    public ObservableSet(Set<E> set) {
        super(set);
    }

    // Observers subscribe to notifications
    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    // Observers unsubscribe to notifications
    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementAdded(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element); // calls notifyElementAdded
        }
        return result;
    }
}
