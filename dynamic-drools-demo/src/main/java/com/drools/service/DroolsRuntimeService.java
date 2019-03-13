package com.drools.service;

import com.drools.exception.ServiceException;

public interface DroolsRuntimeService {
	
	public Object runRule(String id, String data) throws ServiceException;

}
