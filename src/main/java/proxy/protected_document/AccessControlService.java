package proxy.protected_document;

import java.util.*;

public class AccessControlService {
    private static AccessControlService instance;

    private Map<String, Set<Integer>> accessRights = new HashMap<>();

    private AccessControlService() {

    }

    static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public boolean isAllowed(String username, int documentId) {
        Set<Integer> documents = this.accessRights.get(username);
        if (documents == null || !documents.contains(documentId)) {
            return false;
        }
        return true;
    }

    public void addAccessRights(User user, IDocument document) {
        Set<Integer> documents = this.accessRights.get(user.getUsername());
        if (documents == null) {
            documents = new HashSet<>();
        }
        documents.add(document.getId());
        this.accessRights.put(user.getUsername(), documents);
    }
}
