package visitor.file_system_handling;

public class File implements FileSystemElement {
    private String name;
    private double megabytes;

    public File(String name, double megabytes) {
        this.name = name;
        this.megabytes = megabytes;
    }

    public String getName() {
        return name;
    }

    public double getMegabytes() {
        return megabytes;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("Filename: %s; Size: %s mb", name, megabytes);
    }
}
