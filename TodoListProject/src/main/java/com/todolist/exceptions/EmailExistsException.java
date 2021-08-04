package com.todolist.exceptions;

public class EmailExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailExistsException(String errorMessage) {
		super(errorMessage);
	}
}