package org.cmad.blog.api.exception;

public class InvalidCommentException extends BlogException{

	public static final int INVALID_COMMENT = 1;

	private int exceptionID;

	public InvalidCommentException() {
	}
	
	public InvalidCommentException(int exceptionID) {
		super();
		this.exceptionID = exceptionID;
	}

	public InvalidCommentException(final int exceptionId, final String message) {
		super(message);
		this.exceptionID = exceptionId;
	}

	public int getExceptionID() {
		return exceptionID;
	}

	public static String getMessage(final int exceptionID) {

		String ErrMsg = null;

		switch (exceptionID) {
		case INVALID_COMMENT:
			ErrMsg = "Comment Description is not proper.";
			break;
		
		default:
			ErrMsg = "Incorrect Exception ID";
			break;
		}

		return ErrMsg;
	}
}
