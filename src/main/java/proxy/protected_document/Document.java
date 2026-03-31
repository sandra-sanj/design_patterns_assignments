package proxy.protected_document;

import java.time.LocalDate;

public class Document implements IDocument {
    private static int previousId = 0;
    private int id;
    private LocalDate creationDate;
    private String content;

    public Document(String content) {
        this.id = previousId++;
        this.creationDate = LocalDate.now();
        this.content = content;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    @Override
    public String getContent(User user) {
        return this.content;
    }

}
