package com.revature.ecommerce.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -13216733298798717L;
    private final String id;
 
    public CustomerNotFoundException(String message, String userId) {
        super(message);
        this.id = userId;
    }
 
    public CustomerNotFoundException(String message, Throwable error, String userId) {
        super(message, error);
        this.id = userId;
    }
 
    public CustomerNotFoundException(Throwable e, String userId) {
        super(e);
        this.id = userId;
    }
 
    public String getUserId() {
        return id;
    }
}