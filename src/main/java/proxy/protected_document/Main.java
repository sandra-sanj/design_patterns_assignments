package proxy.protected_document;

import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");

        IDocument publicDocument = new Document("Public content.");
        IDocument protectedDocument = new Document("Very secret content.");
        IDocument protectedDocumentProxy = new DocumentProxy(protectedDocument);
        IDocument protectedDocument2 = new Document("Another secret document content.");
        IDocument protectedDocumentProxy2 = new DocumentProxy(protectedDocument2);

        // library
        Library library = new Library();
        library.add(publicDocument.getId(), publicDocument);
        library.add(protectedDocumentProxy.getId(), protectedDocumentProxy);
        library.add(protectedDocument2.getId(), protectedDocumentProxy2);

        // grant access
        AccessControlService.getInstance().addAccessRights(user1, protectedDocumentProxy);
        AccessControlService.getInstance().addAccessRights(user3, protectedDocumentProxy);
        AccessControlService.getInstance().addAccessRights(user3, protectedDocumentProxy2);

        // access tests
        for (User user : Arrays.asList(user1, user2, user3)) {
            for (Map.Entry<Integer, IDocument> entry : library.getLibrary().entrySet()) {
                IDocument document = entry.getValue();
                System.out.printf("%s trying to access document %s:\n", user.getUsername(), document.getId());
                System.out.println(document.getContent(user));
            }
            System.out.println();
        }
    }
}
