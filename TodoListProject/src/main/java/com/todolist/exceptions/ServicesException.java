package com.todolist.exceptions;

public class ServicesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicesException(String errorMessage) {
		super(errorMessage);
	}
	
	public ServicesException(String errorMessage, int id) {
		super(errorMessage + " " +id);
	}
	
	public ServicesException(String errorMessage, String email) {
		super(errorMessage + " " + email);
	}

}
