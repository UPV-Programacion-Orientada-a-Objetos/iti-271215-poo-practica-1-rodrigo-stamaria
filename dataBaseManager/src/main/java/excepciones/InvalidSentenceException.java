package excepciones;

public class InvalidSentenceException extends RuntimeException {
    public InvalidSentenceException(String message) {
        super(message);
    }

    public InvalidSentenceException() {
        super();
    }
}
