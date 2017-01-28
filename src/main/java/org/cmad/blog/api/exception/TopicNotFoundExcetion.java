package org.cmad.blog.api.exception;

public class TopicNotFoundExcetion extends BlogException {

public static final int TOPIC_NOT_FOUND = 1;
	
	private int exceptionID;
	
	public TopicNotFoundExcetion() {
	}
	
	public TopicNotFoundExcetion(int exceptionID) {
		super(exceptionID);
	}
	
	public static String getMessage(final int exceptionID) {

		String ErrMsg = null;

		switch (exceptionID) {
		case TOPIC_NOT_FOUND:
			ErrMsg = "Invalid Topic.";
			break;
		default:
			ErrMsg = "Incorrect Exception ID";
			break;
		}

		return ErrMsg;
	}
}
