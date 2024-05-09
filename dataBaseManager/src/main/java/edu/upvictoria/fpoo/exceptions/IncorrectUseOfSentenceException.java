package edu.upvictoria.fpoo.exceptions;

public class IncorrectUseOfSentenceException extends RuntimeException {
    public IncorrectUseOfSentenceException(String message) {
        super(message);
    }

    public IncorrectUseOfSentenceException() {
        super();
    }
}
