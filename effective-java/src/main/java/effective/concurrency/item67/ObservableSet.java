package effective.concurrency.item67;

import java.util.Set;

import effective.classesandinterfaces.item16.ForwardingSet;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 19/07/2017.
 */
public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set) {
        super(set);
    }
}
