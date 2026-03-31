package proxy.protected_document;

public class AccessDeniedException extends Exception {

    public AccessDeniedException(String accessDenied) {
        super(accessDenied);
    }
}
