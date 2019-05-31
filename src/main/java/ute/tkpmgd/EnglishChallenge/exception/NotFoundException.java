package ute.tkpmgd.EnglishChallenge.exception;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = -2713929267961269724L;

	public NotFoundException() {
        super();
    }

    public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException(final Throwable cause) {
        super(cause);
    }
}
