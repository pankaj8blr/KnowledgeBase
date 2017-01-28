package org.cmad.blog.api.exception;

public class UserNotFoundException extends BlogException {

public static final int USER_NOT_FOUND = 1;
public static final int USER_DETAILS_NOT_PROPER = 2;
	
	private int exceptionID;
	
	public UserNotFoundException() {
	}
	
	public UserNotFoundException(int exceptionID) {
		super(exceptionID);
	}
	
	public static String getMessage(final int exceptionID) {

		String ErrMsg = null;

		switch (exceptionID) {
		case USER_NOT_FOUND:
			ErrMsg = "User Not available.";
			break;
		case USER_DETAILS_NOT_PROPER:
			ErrMsg = "User Personal Info Not Proper.";
			break;
		default:
			ErrMsg = "Incorrect Exception ID";
			break;
		}

		return ErrMsg;
	}

}
