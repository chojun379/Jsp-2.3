package guestbook.service;

public class MessageNotFoundException extends RuntimeException {
	
	public MessageNotFoundException(String message) {
		super(message);
	}
	
}
