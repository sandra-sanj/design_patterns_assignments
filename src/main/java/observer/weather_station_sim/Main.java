package observer.weather_station_sim;

public class Main {
    public static void main(String[] args) throws Exception {
        WeatherStation weatherStation = new WeatherStation();

        // observers
        Observer observer1 = new ObservingObject("observer1", weatherStation);
        Observer observer2 = new ObservingObject("observer2", weatherStation);
        Observer observer3 = new ObservingObject("observer3", weatherStation);
        Observer observer4 = new ObservingObject("observer4", weatherStation);
        Observer observer5 = new ObservingObject("observer5", weatherStation);

        Thread weatherStationThread = new Thread(weatherStation);
        weatherStationThread.start();

        Thread.sleep(10000);
        weatherStation.removeObserver(observer5);

        Thread.sleep(8000);
        weatherStation.removeObserver(observer4);

        Thread.sleep(8000);
        weatherStation.removeObserver(observer3);

        Thread.sleep(6000);
        weatherStation.removeObserver(observer2);

        Thread.sleep(6000);
        weatherStation.removeObserver(observer1);

    }
}
