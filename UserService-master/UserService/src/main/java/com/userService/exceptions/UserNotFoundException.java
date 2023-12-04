package com.userService.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 262019632182597761L;
	
	public UserNotFoundException(){
		super("UserNot found");
		
	}
	public UserNotFoundException(String message) {
		super(message);
	}

}
