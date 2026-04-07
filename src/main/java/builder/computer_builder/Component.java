package builder.computer_builder;

public class Component {

    public enum Type {
        PROCESSOR,
        RAM_SIZE,
        HARD_DRIVE,
        GRAPHICS_CARD,
        OPERATING_SYSTEM,
    }

    private String name;
    private Type type;

    public Component(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
