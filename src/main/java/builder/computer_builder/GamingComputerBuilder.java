package builder.computer_builder;

public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        this.computer.setProcessor("powerful processor");
    }

    @Override
    public void buildRAM() {
        this.computer.setRamSize("32 GB");
    }

    @Override
    public void buildHardDrive() {
        this.computer.setHardDrive("512 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        this.computer.setGraphicsCard("powerful graphics card");
    }

    @Override
    public void buildOperatingSystem() {
        this.computer.setOperatingSystem("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
