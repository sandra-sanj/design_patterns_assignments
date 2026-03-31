package visitor.file_system_handling;

import java.util.HashSet;
import java.util.Set;

public class Directory implements FileSystemElement {
    private String name;
    private Set<File> files;
    private Set<Directory> directories;

    public Directory(String name) {
        this.name = name;
        this.files = new HashSet<>();
        this.directories = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public Set<File> getFiles() {
        return files;
    }

    public Set<Directory> getDirectories() {
        return directories;
    }

    public void add(File file) {
        this.files.add(file);
    }

    public void remove(File file) {
        this.files.remove(file);
    }

    public void add(Directory directory) {
        this.directories.add(directory);
    }

    public void remove(Directory directory) {
        this.directories.remove(directory);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
