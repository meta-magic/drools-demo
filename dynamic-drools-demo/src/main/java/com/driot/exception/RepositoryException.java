package com.driot.exception;

public class RepositoryException extends Exception{

	public RepositoryException(String msg) {
		super(msg);
	}

	public RepositoryException(Exception e) {
		super("Repository Exception", e);
	}

	public RepositoryException(String msg, Exception e) {
		super(msg, e);
	}
	
}
