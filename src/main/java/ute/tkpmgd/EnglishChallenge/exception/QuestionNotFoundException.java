package ute.tkpmgd.EnglishChallenge.exception;

public class QuestionNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -2713929267961269724L;

	public QuestionNotFoundException() {
        super();
    }

    public QuestionNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public QuestionNotFoundException(final String message) {
        super(message);
    }

    public QuestionNotFoundException(final Throwable cause) {
        super(cause);
    }
}
