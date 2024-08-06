package excepciones;

public class ExistentComponentException extends RuntimeException {
    public ExistentComponentException(String message) {
        super(message);
    }

    public ExistentComponentException() {
        super();
    }
}
