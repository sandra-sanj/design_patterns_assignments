package visitor.file_system_handling;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
