package bridge.devices_remote_controls_extension;

// From Refactoring Guru
// https://refactoring.guru/design-patterns/bridge/java/example

import bridge.devices_remote_controls_extension.devices.Device;
import bridge.devices_remote_controls_extension.devices.Radio;
import bridge.devices_remote_controls_extension.devices.Tv;
import bridge.devices_remote_controls_extension.remotes.AdvancedRemote;
import bridge.devices_remote_controls_extension.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}