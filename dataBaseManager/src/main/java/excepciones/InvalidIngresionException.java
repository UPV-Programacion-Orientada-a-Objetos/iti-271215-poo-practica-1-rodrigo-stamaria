package excepciones;

public class InvalidIngresionException extends RuntimeException {
    public InvalidIngresionException(String message) {
        super(message);
    }

    public InvalidIngresionException() {
        super();
    }
}
