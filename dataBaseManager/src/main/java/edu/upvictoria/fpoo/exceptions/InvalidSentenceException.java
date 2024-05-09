package edu.upvictoria.fpoo.exceptions;

public class InvalidSentenceException extends RuntimeException {
    public InvalidSentenceException(String message) {
        super(message);
    }

    public InvalidSentenceException() {
        super();
    }
}
