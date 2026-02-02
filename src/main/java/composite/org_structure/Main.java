package composite.org_structure;

public class Main {
    public static void main(String[] args) {

        Component dep1 = new Department("dep1");
        Component dep2 = new Department("dep2");
        Component dep3 = new Department("dep3");
        Component dep4 = new Department("dep4");
        Component dep5 = new Department("dep5");

        Component emp1 = new Employee("emp1", 2000);
        Component emp2 = new Employee("emp2", 3000);
        Component emp3 = new Employee("emp3", 3200);
        Component emp4 = new Employee("emp4", 2900);
        Component emp5 = new Employee("emp5", 5000);
        Component emp6 = new Employee("emp6", 2200);
        Component emp7 = new Employee("emp7", 1800);
        Component emp8 = new Employee("emp8", 3500);

        dep1.add(emp1);
        dep1.add(emp2);

        dep1.add(dep2);
        dep2.add(emp3);
        dep2.add(emp4);
        dep2.add(emp5);

        dep1.add(dep3);
        dep3.add(emp6);
        dep3.add(emp7);

        dep1.add(dep4);
        dep4.add(emp8);

        dep1.add(dep5);

        dep1.printData();
        dep2.printData();
        dep3.printData();
        dep4.printData();
        dep5.printData();

        System.out.println("<organization>");
        dep1.printDataXML(1);
        System.out.println("</organization>");
    }
}
