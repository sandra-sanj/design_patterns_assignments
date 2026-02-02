package composite.org_structure;

import java.util.ArrayList;
import java.util.List;

public class Department extends Component {

    private List<Component> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void printData() {
        System.out.println(this.name);
        System.out.println(this.getEmployees(true).size() + " employees");
        System.out.println(this.getCombinedSalary() + " combined salary");
        System.out.println();
    }

    public void printDataXML(int tabs) {
        super.printTabs(tabs);
        System.out.println("<department>");
        tabs++;

        super.printTabs(tabs);
        System.out.println("<name>" + this.name + "</name>");

        List<Employee> employees = this.getEmployees(false);
        if (!employees.isEmpty()) {
            super.printTabs(tabs);
            System.out.println("<employees>");

            tabs++;
            for (Employee employee : employees) {
                employee.printDataXML(tabs);
            }

            tabs--;
            super.printTabs(tabs);
            System.out.println("</employees>");
        }

        List<Department> departments = this.getDepartments();
        if (!departments.isEmpty()) {
            super.printTabs(tabs);
            System.out.println("<departments>");

            tabs++;
            for (Department department : departments) {
                department.printDataXML(tabs);
            }

            tabs--;
            super.printTabs(tabs);
            System.out.println("</departments>");
        }

        tabs--;
        super.printTabs(tabs);
        System.out.println("</department>");
    }

    @Override
    public void add(Component component) {
        this.children.add(component);
    }

    @Override
    public void remove(Component component) {
        this.children.add(component);
    }

    @Override
    public Component getChild(int index) {
        return this.children.get(index);
    }

    public List<Employee> getEmployees(boolean getChildDepartmentEmployees) {
        List<Employee> employees = new ArrayList<>();

        for (Component component : this.children) {
            if (component instanceof Employee) {
                employees.add((Employee) component);
            } else if (getChildDepartmentEmployees && component instanceof Department) {
                employees.addAll(((Department)component).getEmployees(true));
            }
        }
        return employees;
    }

    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList<>();

        for (Component component : this.children) {
            if (component instanceof Department) {
                departments.add((Department) component);
            }
        }
        return departments;
    }

    public int getCombinedSalary() {
        List<Employee> employees = this.getEmployees(true);

        int salary = 0;
        for (Employee employee : employees) {
            salary += employee.getSalary();
        }
        return salary;
    }
}
