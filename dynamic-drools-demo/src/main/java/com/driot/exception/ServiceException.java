package com.driot.exception;

public class ServiceException  extends Exception{

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Exception e) {
		super("Service Exception", e);
	}

	public ServiceException(String msg, Exception e) {
		super(msg, e);
	}
	
}