package com.stg.exception;

public class BookStoreException extends Exception {
	private String errorMessage;

	public BookStoreException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return errorMessage;
	}


	public BookStoreException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	
	

}
