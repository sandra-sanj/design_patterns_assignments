package observer.weather_station_sim;

public class ObservingObject implements Observer {

    private WeatherStation observable;
    private String name;

    public ObservingObject(String name, WeatherStation observable) {
        this.name = name;
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println(this.name + " was notified, temperature is " + observable.getTemperature());
    }
}
