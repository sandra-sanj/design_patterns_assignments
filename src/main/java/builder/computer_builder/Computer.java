package builder.computer_builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Component> components;

    public Computer() {
        this.components = new ArrayList<>();
    }

    public String getProcessor() {
        return this.getComponentName(Component.Type.PROCESSOR);
    }

    public void setProcessor(String processor) {
        this.setComponent(processor, Component.Type.PROCESSOR);
    }

    public String getRamSize() {
        return this.getComponentName(Component.Type.RAM_SIZE);
    }

    public void setRamSize(String ramSize) {
        this.setComponent(ramSize, Component.Type.RAM_SIZE);
    }

    public String getHardDrive() {
        return this.getComponentName(Component.Type.HARD_DRIVE);
    }

    public void setHardDrive(String hardDrive) {
        this.setComponent(hardDrive, Component.Type.HARD_DRIVE);
    }

    public String getGraphicsCard() {
        return this.getComponentName(Component.Type.GRAPHICS_CARD);
    }

    public void setGraphicsCard(String graphicsCard) {
        this.setComponent(graphicsCard, Component.Type.GRAPHICS_CARD);
    }

    public String getOperatingSystem() {
        return this.getComponentName(Component.Type.OPERATING_SYSTEM);
    }

    public void setOperatingSystem(String operatingSystem) {
        this.setComponent(operatingSystem, Component.Type.OPERATING_SYSTEM);
    }

    private String getComponentName(Component.Type type) {
        return this.components.stream()
                .filter(component -> component.getType().equals(type))
                .map(Component::getName)
                .findFirst()
                .orElse(null);
    }

    private void setComponent(String componentName, Component.Type type) {
        this.components.removeIf(component -> component.getType().equals(type));
        this.components.add(new Component(componentName, type));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component component : components) {
            sb.append(component.getType());
            sb.append(": ");
            sb.append(component.getName());
            sb.append("\n");
        }
        return sb.toString();
    }
}
