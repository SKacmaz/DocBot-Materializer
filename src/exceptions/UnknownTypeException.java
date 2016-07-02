package exceptions;

public class UnknownTypeException extends Exception {

	public UnknownTypeException() {}

	public UnknownTypeException(String message) {
		super(message);
	}

	public UnknownTypeException(Throwable cause) {
		super(cause);
	}

	public UnknownTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownTypeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
