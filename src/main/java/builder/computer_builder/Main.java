package builder.computer_builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder builder = new OfficeComputerBuilder();
        ComputerDirector director = new ComputerDirector(builder);
        director.constructComputer();
        System.out.println(builder.getComputer());

        ComputerBuilder builder2 = new GamingComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(builder2);
        director2.constructComputer();
        System.out.println(builder2.getComputer());
    }
}
