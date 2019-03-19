package com.driot.repo;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.driot.entity.Entity;
import com.driot.exception.RepositoryException;

public abstract class GenericRepository <T> {

	@Autowired
	PersistenceManagerFactory pmf;

	/**
	 * THIS METHOD IS USED TO CREATE INSTACE OF PERSISTENCEMANAGERFACTORY
	 */
	public PersistenceManager pm() {
		return pmf.getPersistenceManager();
	}

	/**
	 * THIS METHOD IS USED FOR PERSIST T TYPE OF OBJECT IN DATABASE
	 * @throws Exception 
	 * */
	public void persist(T t) throws RepositoryException {
		PersistenceManager pm = pm();
		try {
			pm.setDetachAllOnCommit(true);
			pm.makePersistent(t);
		} catch (Exception e) {
			throw new RepositoryException(e);
		} finally {
			pm.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(Object entity) throws RepositoryException {
		
		PersistenceManager pm = pm();
		try {
			Query query = pm.newQuery(entity.getClass());
			List<T> list = (List<T>) query.execute();
			return (List<T>) pm.detachCopyAll(list);
		} catch (Exception e) {
			throw new RepositoryException(e);
		} finally {
			pm.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entity findById(Entity entity) throws RepositoryException{
		
		PersistenceManager pm = pm();
		try {
			final String filter = entity.primaryField()+" == :"+entity.primaryField(); 
			Query query = pm.newQuery(entity.getClass());
			query.setFilter(filter);
			query.setUnique(true);
			Entity newEntity = (Entity) query.execute(entity.primaryKey());
			return newEntity;
		} catch (Exception e) {
			throw new RepositoryException(e);
		} finally {
			pm.close();
		}
	}	
	
}
