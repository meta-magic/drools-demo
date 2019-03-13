package com.drools.service;

import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drools.entity.DroolsDRL;
import com.drools.exception.InvalidJsonException;
import com.drools.exception.RepositoryException;
import com.drools.exception.ServiceException;
import com.drools.repo.DroolsDRLRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DroolsRuntimeServiceImpl implements DroolsRuntimeService
{
	@Autowired
	private KieContainer kieContainer;

	@Autowired
	private DroolsDRLRepository droolsDRLRepository;
	 
	@Autowired
	private DroolsKSessionUtils ksessionHandler;
	
	public Object runRule(String id, String data) throws ServiceException 
	{
		
		try {
			DroolsDRL drl = droolsDRLRepository.findById(id);
			
			KieSession kieSession = ksessionHandler.getKSession(drl.getDsl());
			
			FactType factType = kieSession.getKieBase().getFactType(drl.getPkg(), drl.getClassName());
			Object runtimeInstance = factType.newInstance();
				
			Object newobj = this.getObject(data, runtimeInstance);
			runtimeInstance = newobj;
			kieSession.insert(runtimeInstance);
			kieSession.fireAllRules();
			kieSession.dispose();
					
			System.out.println("Total amount : "+factType.get( runtimeInstance, "totalAmount" ));
			System.out.println("Discount Applied : "+factType.get( runtimeInstance, "discount" ));
			System.out.println("Total amount after discount : "+factType.get( runtimeInstance, "payableAmount" ));		
			
			
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
