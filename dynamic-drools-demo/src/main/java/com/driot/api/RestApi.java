package com.driot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driot.service.DriotRuntimeService;;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class RestApi {
	
	@Autowired
	private DriotRuntimeService driotRuntimeService;
	
	
	@PostMapping("/execute")
	public ResponseEntity<Object> executeRule(@RequestBody String body) throws Exception{
		System.out.println("*******IN EXECUTE RULE************"+body);				
		Object newobj = driotRuntimeService.runRule("6c2e77ea-5bde-4200-903b-606fc40b74b3",body);
		System.out.println(newobj);
		return new ResponseEntity<Object>(newobj, HttpStatus.OK);
	}

	
	
	

}
