package org.cmad.blog.api.exception;

public class BlogException extends RuntimeException {
	
	public static final int INVALID_USER_DETAILS = 1;
	public static final int USER_NOT_AVAILABLE = 2;
	
	private int exceptionID;

	public BlogException() {
		// TODO Auto-generated constructor stub
	}
	
	public BlogException(String message) {
		// TODO Auto-generated constructor stub
	}

	public BlogException(int exceptionID2) {
		// TODO Auto-generated constructor stub
	}

	public int getExceptionID() {
		return exceptionID;
	}

	public static String getMessage(final int exceptionID) {

		String ErrMsg = null;

		switch (exceptionID) {
		case INVALID_USER_DETAILS:
			ErrMsg = "User details are not proper.";
			break;
		case USER_NOT_AVAILABLE:
			ErrMsg = "User doesn't exist.";
			break;
		default:
			ErrMsg = "Incorrect Exception ID";
			break;
		}

		return ErrMsg;
	}
}
