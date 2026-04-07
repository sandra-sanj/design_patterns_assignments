package builder.computer_builder;

public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        this.computer.setProcessor("basic processor");
    }

    @Override
    public void buildRAM() {
        this.computer.setRamSize("8 GB");
    }

    @Override
    public void buildHardDrive() {
        this.computer.setHardDrive("256 GB HDD");
    }

    @Override
    public void buildGraphicsCard() {
        this.computer.setGraphicsCard("no graphics card");
    }

    @Override
    public void buildOperatingSystem() {
        this.computer.setOperatingSystem("Windows 10");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
