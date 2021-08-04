package com.todolist.services;

public interface EmailService {

	/**
	 * Sends information of tasks to the user via email
	 * 
	 * @param toUser
	 * @param body
	 * @param subject
	 */
	public void sendMail(String toUser, String body, String subject );

}
