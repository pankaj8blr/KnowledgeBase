package org.cmad.blog.api.exception;

public class InvalidPostException extends BlogException {

	public static final int INVALID_POST_TITLE = 1;
	public static final int INVALID_POST_DESCRIPTION = 2;

	private int exceptionID;

	public InvalidPostException(){
		
	}
	
	public InvalidPostException(int exceptionID) {
		super();
		this.exceptionID = exceptionID;
	}

	public InvalidPostException(final int exceptionId, final String message) {
		super(message);
		this.exceptionID = exceptionId;
	}

	public int getExceptionID() {
		return exceptionID;
	}

	public static String getMessage(final int exceptionID) {

		String ErrMsg = null;

		switch (exceptionID) {
		case INVALID_POST_TITLE:
			ErrMsg = "Post title is not proper.";
			break;
		case INVALID_POST_DESCRIPTION:
			ErrMsg = "Post Description is not proper.";
			break;
		default:
			ErrMsg = "Incorrect Exception ID";
			break;
		}

		return ErrMsg;
	}

}
