package bridge.devices_remote_controls_extension.devices;

// From Refactoring Guru
// https://refactoring.guru/design-patterns/bridge/java/example

public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();
}
