package com.driot.service;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.driot.entity.DriotDRL;
import com.driot.repo.GenericRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl extends GenericRepository implements QueryService {



    @Override
    public Object executeQuery(String query1) {
        
        PersistenceManager pm = pm();
       
		try {
			Query query = pm.newQuery(new DriotDRL().getClass());
			List list = (List) query.execute();
			return (List) pm.detachCopyAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
        }
        
        return null;
	}
	
	@Override
    public Object executeQuery(String id, Object param, Object op) {
		System.out.println("*****OP*******"+op);
        PersistenceManager pm = pm();
       
		try {
			Query query = pm.newQuery(new DriotDRL().getClass());
			List list = (List) query.execute();
			return (List) pm.detachCopyAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
        }
        
        return null;
    }
}