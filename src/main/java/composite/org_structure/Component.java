package composite.org_structure;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public void printData() {
        System.out.println(this.name);
    };

    public abstract void printDataXML(int tabs);

    public void printTabs(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("  ");
        }
    }

    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract Component getChild(int index);
}
