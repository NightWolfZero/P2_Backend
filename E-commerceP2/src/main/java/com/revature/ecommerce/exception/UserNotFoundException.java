package com.revature.ecommerce.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -13216733298798717L;
    private final String user_id;
 
    public UserNotFoundException(String message, String userId) {
        super(message);
        this.user_id = userId;
    }
 
    public UserNotFoundException(String message, Throwable error, String userId) {
        super(message, error);
        this.user_id = userId;
    }
 
    public UserNotFoundException(Throwable e, String userId) {
        super(e);
        this.user_id = userId;
    }
 
    public String getUserId() {
        return user_id;
    }
}