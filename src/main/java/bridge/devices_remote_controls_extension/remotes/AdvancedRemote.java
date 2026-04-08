package bridge.devices_remote_controls_extension.remotes;

import bridge.devices_remote_controls_extension.devices.Device;

// From Refactoring Guru
// https://refactoring.guru/design-patterns/bridge/java/example

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
