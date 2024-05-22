package excepciones;

public class IncorrectUseOfSentenceException extends RuntimeException {
    public IncorrectUseOfSentenceException(String message) {
        super(message);
    }

    public IncorrectUseOfSentenceException() {
        super();
    }
}
