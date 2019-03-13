package com.drools.repo;

import com.drools.entity.DroolsDRL;
import com.drools.exception.RepositoryException;

public interface DroolsDRLRepository {

	public DroolsDRL findById(String id) throws RepositoryException;
	
	public void save(DroolsDRL droolsDrl) throws RepositoryException;
	
}
