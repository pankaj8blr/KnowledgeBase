package org.cmad.blog.api.exception;


public class PostNotFoundException extends InvalidPostException {

	public static final int POST_NOT_FOUND = 1;
	
	private int exceptionID;
	
	public PostNotFoundException() {
	}
	
	public PostNotFoundException(int exceptionID) {
		super(exceptionID);
	}
	
	public static String getMessage(final int exceptionID) {

		String ErrMsg = null;

		switch (exceptionID) {
		case POST_NOT_FOUND:
			ErrMsg = "Post Not available.";
			break;
		default:
			ErrMsg = "Incorrect Exception ID";
			break;
		}

		return ErrMsg;
	}

}
