package bridge.devices_remote_controls_extension.remotes;

// From Refactoring Guru
// https://refactoring.guru/design-patterns/bridge/java/example

public interface Remote {
    void power();

    void volumeDown();

    void volumeUp();

    void channelDown();

    void channelUp();
}
