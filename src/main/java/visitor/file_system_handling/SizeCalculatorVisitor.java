package visitor.file_system_handling;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(File file) {
        this.totalSize += file.getMegabytes();
    }

    @Override
    public void visit(Directory directory) {
        for (File file : directory.getFiles()) {
            visit(file);
        }

        for (Directory subDirectory : directory.getDirectories()) {
            visit(subDirectory);
        }
    }

    public double getTotalSize() {
        return this.totalSize;
    }

    public void printTotalSize() {
        System.out.printf("Total size: %.1f mb\n", this.totalSize);
    }
}
