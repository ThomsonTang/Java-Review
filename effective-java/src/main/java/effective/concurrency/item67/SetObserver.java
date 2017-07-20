package effective.concurrency.item67;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 20/07/2017.
 */
public interface SetObserver<E> {
    //Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
