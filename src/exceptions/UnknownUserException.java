package exceptions;

public class UnknownUserException extends Exception {

	public UnknownUserException() {}

	public UnknownUserException(String arg0) {
		super(arg0);
	}

	public UnknownUserException(Throwable arg0) {
		super(arg0);
	}

	public UnknownUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UnknownUserException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
