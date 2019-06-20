package com.driot.service;

import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driot.entity.DriotDRL;
import com.driot.exception.InvalidJsonException;
import com.driot.exception.RepositoryException;
import com.driot.exception.ServiceException;
import com.driot.repo.DriotDRLRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DriotRuntimeServiceImpl implements DriotRuntimeService
{
	@Autowired
	private DriotDRLRepository driotDRLRepository;
	 
	@Autowired
	private DroolsKSessionUtils ksessionHandler;
	
	@Autowired
	private QueryService queryService;

	public Object runRule(String id, String data) throws ServiceException 
	{
		
		try {
			DriotDRL drl = driotDRLRepository.findById(id);
			String str [] = {"2","1"};
			
			KieSession kieSession = ksessionHandler.getKSession(drl.getDsl());
			
			FactType factType = kieSession.getKieBase().getFactType(drl.getPkg(), drl.getClassName());
			Object runtimeInstance = factType.newInstance();
				
			Object newobj = this.getObject(data, runtimeInstance);
			runtimeInstance = newobj;
			kieSession.insert(runtimeInstance);
			//kieSession.insert(queryService);
			//kieSession.setGlobal("queryService", queryService);
			kieSession.fireAllRules();
			kieSession.dispose();
					
			return newobj;
		} catch (RepositoryException e) {
			throw new ServiceException("Drools Service Exception",e);
		} catch (InvalidJsonException e) {
			throw new ServiceException("Drools Service Exception "+e.getMessage(),e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Drools Service Exception "+e.getMessage(),e);
		}
		
	}
	

	private Object getObject(String json, Object obj) throws InvalidJsonException{
		try {
			Object objnew = new ObjectMapper().readValue(json, obj.getClass());
			return objnew;
		} catch (Exception e) {			
			throw new InvalidJsonException(e);
		}
	}
 
}
