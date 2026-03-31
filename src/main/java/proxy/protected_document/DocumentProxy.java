package proxy.protected_document;

import java.time.LocalDate;

public class DocumentProxy implements IDocument {
    private IDocument realDocument;

    public DocumentProxy(IDocument realDocument) {
        this.realDocument = realDocument;
    }

    @Override
    public int getId() {
        return this.realDocument.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return this.realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) {
        try {
            if (AccessControlService.getInstance().isAllowed(user.getUsername(), this.getId())) {
                return this.realDocument.getContent(user);
            } else {
                throw new AccessDeniedException("Access denied");
            }
        } catch (AccessDeniedException e) {
            return e.getMessage();
        }
    }
}
