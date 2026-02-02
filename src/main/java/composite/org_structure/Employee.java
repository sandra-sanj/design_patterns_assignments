package composite.org_structure;

public class Employee extends Component{
    private int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    @Override
    public void printData() {
        System.out.println(this.name + ", salary: " + this.getSalary());
    }

    @Override
    public void printDataXML(int tabs) {

        super.printTabs(tabs);
        System.out.println("<employee>");
        tabs++;

        super.printTabs(tabs);
        System.out.println("<name>" + this.name + "</name>");

        super.printTabs(tabs);
        System.out.println("<salary>" + this.getSalary() + "</salary>");

        tabs--;
        super.printTabs(tabs);
        System.out.println("</employee>");
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }
}
