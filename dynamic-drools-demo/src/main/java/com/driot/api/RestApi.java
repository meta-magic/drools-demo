package com.driot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

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

	@PostMapping("/demo2")
	public ResponseEntity<Object>
	 demo2(@RequestBody String body) throws Exception{		
		
		System.out.println("*******IN EXECUTE RULE************"+body);				
		Object newobj = driotRuntimeService.runRule("6c2e77ea-5bde-4200-903b-606fc40b74b4",body);
		System.out.println(newobj);
		return new ResponseEntity<Object>(newobj, HttpStatus.OK);
	}

	@PostMapping("/demo3")
	public ResponseEntity<Object> demo3(@RequestBody String body) throws Exception{		
		
		System.out.println("*******IN EXECUTE RULE************"+body);				
		Object newobj = driotRuntimeService.runRule("6c2e77ea-5bde-4200-903b-606fc40b74b5",body);
		System.out.println(newobj);
		return new ResponseEntity<Object>(newobj, HttpStatus.OK);
	}

	@PostMapping("/demo4")
	public ResponseEntity<Object> demo4(@RequestBody String body) throws Exception{		
		
		System.out.println("*******IN EXECUTE RULE************"+body);				
		Object newobj = driotRuntimeService.runRule("6c2e77ea-5bde-4200-903b-606fc40b74b6",body);
		System.out.println(newobj);
		return new ResponseEntity<Object>(newobj, HttpStatus.OK);
	}
	
	@PostMapping("/demo7")
	public ResponseEntity<Object> demo7(@RequestBody String body) throws Exception{		
		
		System.out.println("*******IN EXECUTE RULE************"+body);				
		Object newobj = driotRuntimeService.runRule("6c2e77ea-5bde-4200-903b-606fc40b74b7",body);
		System.out.println(newobj);
		return new ResponseEntity<Object>(newobj, HttpStatus.OK);
	}
	

}
