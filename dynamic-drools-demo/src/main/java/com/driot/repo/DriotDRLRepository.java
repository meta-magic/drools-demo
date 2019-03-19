package com.driot.repo;

import com.driot.entity.DriotDRL;
import com.driot.exception.RepositoryException;

public interface DriotDRLRepository {

	public DriotDRL findById(String id) throws RepositoryException;
	
	public void save(DriotDRL droolsDrl) throws RepositoryException;
	
}
