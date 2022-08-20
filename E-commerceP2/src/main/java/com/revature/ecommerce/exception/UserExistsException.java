package com.revature.ecommerce.exception;

import javax.naming.AuthenticationException;

public class UserExistsException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserExistsException(final String msg) {
        super(msg);
    }

}
