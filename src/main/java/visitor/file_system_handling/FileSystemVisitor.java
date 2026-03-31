package visitor.file_system_handling;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}
