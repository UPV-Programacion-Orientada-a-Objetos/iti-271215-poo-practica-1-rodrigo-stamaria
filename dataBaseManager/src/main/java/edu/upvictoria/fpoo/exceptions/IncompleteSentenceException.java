package edu.upvictoria.fpoo.exceptions;

public class IncompleteSentenceException extends Exception {
    public IncompleteSentenceException(String message) {
        super(message);
    }

    public IncompleteSentenceException() {
        super();
    }
}
