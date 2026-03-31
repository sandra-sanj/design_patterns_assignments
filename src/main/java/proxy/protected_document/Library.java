package proxy.protected_document;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, IDocument> library = new HashMap<>();

    public Map<Integer, IDocument> getLibrary() {
        return library;
    }

    public void add(int identifier, IDocument document) {
        this.library.put(identifier, document);
    }

    public void remove(int identifier) {
        this.library.remove(identifier);
    }
}
