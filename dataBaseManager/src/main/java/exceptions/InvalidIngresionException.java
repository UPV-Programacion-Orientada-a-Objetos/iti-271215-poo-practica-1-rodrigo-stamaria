package edu.upvictoria.fpoo.exceptions;

public class InvalidIngresionException extends RuntimeException {
    public InvalidIngresionException(String message) {
        super(message);
    }

    public InvalidIngresionException() {
        super();
    }
}
