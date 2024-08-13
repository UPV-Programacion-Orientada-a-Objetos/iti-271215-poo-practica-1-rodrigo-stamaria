package excepciones;

public class InexistentComponentException extends RuntimeException {
    public InexistentComponentException(String message) {
        super(message);
    }

    public InexistentComponentException() {
        super();
    }
}
