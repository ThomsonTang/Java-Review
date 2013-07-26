package observerpattern;

/**
 * The Observer interface is implemented by all observers.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/26/13
 */
public interface Observer {
    /**
     * update the state values from the subject when a weather measurement changed.
     * @param temp
     * @param humidity
     * @param pressure
     */
    public void update(float temp, float humidity, float pressure);
}
