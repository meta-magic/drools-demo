package com.driot.service;

import com.driot.exception.ServiceException;

public interface DriotRuntimeService {
	
	public Object runRule(String id, String data) throws ServiceException;
	
}
