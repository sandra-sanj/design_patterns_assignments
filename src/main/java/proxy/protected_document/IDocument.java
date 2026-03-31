package proxy.protected_document;

import java.time.LocalDate;

public interface IDocument {
    int getId();
    LocalDate getCreationDate();
    String getContent(User user);
}
