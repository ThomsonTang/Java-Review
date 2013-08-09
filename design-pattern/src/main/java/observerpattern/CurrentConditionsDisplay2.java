package observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/29/13
 */
public class CurrentConditionsDisplay2 implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees, " + humidity + "% humidity.");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData2) {
            WeatherData2 weatherData2 = (WeatherData2) o;
            this.temperature = weatherData2.getTemperature();
            this.humidity = weatherData2.getHumidity();
            display();
        }
    }
}
