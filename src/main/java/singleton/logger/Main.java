package singleton.logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFileName("log.txt");
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");
        logger.close();

        Logger logger2 = Logger.getInstance();
        logger2.setFileName("logger2.txt");
        logger2.write("Logging...");
        logger2.write("Data logging...");
        logger2.close();

        logger.write("Trying to log...");
    }
}
