package com.drools.repo;

import org.springframework.stereotype.Repository;

import com.drools.entity.DroolsDRL;
import com.drools.exception.RepositoryException;

@Repository
public class DroolsDRLRepositoryImpl extends GenericRepository<DroolsDRL> implements DroolsDRLRepository{
 
	@Override
	public DroolsDRL findById(String id) throws RepositoryException {
		return (DroolsDRL) super.findById(new DroolsDRL(id));
	}

	@Override
	public void save(DroolsDRL droolsDrl) throws RepositoryException  {
		
		this.persist(droolsDrl);
		
	}

	
}
