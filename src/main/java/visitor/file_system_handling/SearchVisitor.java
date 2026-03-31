package visitor.file_system_handling;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private List<File> matchedFiles = new ArrayList<>();
    private String subString;

    public SearchVisitor(String subString) {
        this.subString = subString;
    }

    @Override
    public void visit(File file) {
        this.getSubStringMatchAddMatchedFile(file);
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

    private void getSubStringMatchAddMatchedFile(File file) {
        if (file.getName().contains(this.subString)) {
            this.matchedFiles.add(file);
        }
    }

    public List<File> getMatchedFiles() {
        return this.matchedFiles;
    }

    public void printMatchedFiles() {
        System.out.println("Found files:");
        for (File file : this.matchedFiles) {
            System.out.println(file);
        }
    }
}
