package com.driot.exception;

public class InvalidJsonException extends Exception{

	public InvalidJsonException(String msg) {
		super(msg);
	}

	public InvalidJsonException(Exception e) {
		super("Invalid Json", e);
	}

	public InvalidJsonException(String msg, Exception e) {
		super(msg, e);
	}
	
}
