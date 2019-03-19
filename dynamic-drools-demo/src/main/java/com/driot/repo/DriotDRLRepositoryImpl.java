package com.driot.repo;

import org.springframework.stereotype.Repository;

import com.driot.entity.DriotDRL;
import com.driot.exception.RepositoryException;

@Repository
public class DriotDRLRepositoryImpl extends GenericRepository<DriotDRL> implements DriotDRLRepository{
 
	@Override
	public DriotDRL findById(String id) throws RepositoryException {
		return (DriotDRL) super.findById(new DriotDRL(id));
	}

	@Override
	public void save(DriotDRL droolsDrl) throws RepositoryException  {
		
		this.persist(droolsDrl);
		
	}

	
}
