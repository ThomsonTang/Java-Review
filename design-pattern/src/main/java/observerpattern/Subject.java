package observerpattern;

/**
 * The subject interface.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/26/13
 */
public interface Subject {
    /**
     * register an observer
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * remove an observer
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * notify all the registered observers.
     */
    public void notifyObservers();
}
