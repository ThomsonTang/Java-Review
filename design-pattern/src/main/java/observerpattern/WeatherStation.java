package observerpattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/26/13
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        DisplayElement conditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(23, 44, 56);
        weatherData.setMeasurements(32, 48, 67);
        weatherData.setMeasurements(89, 67, 86);

        WeatherData2 weatherData2 = new WeatherData2();
        DisplayElement conditionsDisplay2 = new CurrentConditionsDisplay2(weatherData2);
        weatherData2.setMeasurements(23, 44, 56);
        weatherData2.setMeasurements(32, 48, 67);
        weatherData2.setMeasurements(89, 67, 86);
    }
}
