package observer.weather_station_sim;

public class WeatherStation extends Observable implements Runnable {

    private int maxTemperature = 40;
    private int minTemperature = -20;
    private int temperature;

    public WeatherStation() {
        this.temperature = (int) (Math.random() * (this.maxTemperature - this.minTemperature)) + this.minTemperature;
    }

    @Override
    public void run() {
        try {
            do {
                System.out.println();
                this.changeTemperature();
                notifyObservers();

                int sleepTime = (int) (Math.random() * (3000 - 1000)) + 1000;
                Thread.sleep(sleepTime);

            } while (!getObservers().isEmpty());

        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }

    public int getTemperature() {
        return this.temperature;
    }

    private void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void changeTemperature() {
        int newTemperature = this.getTemperature();
        if (Math.random() <= 0.50) {
            newTemperature++;
        } else {
            newTemperature--;
        }

        if (newTemperature > this.maxTemperature || newTemperature < this.minTemperature) {
            return;
        }

        if (newTemperature != this.getTemperature()) {
            this.setTemperature(newTemperature);
            System.out.println("Temperature has changed to " + this.getTemperature());
        }
    }
}
