package com.rhmtech.management.api.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rhmtech.management.api.service.SalaryFinalService;

@RestController
@RequestMapping("/paidsalary")
@CrossOrigin(origins = "http://localhost:4200")
public class PaiSalaryController {
	@Autowired
	private SalaryFinalService service;
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Float> getSalary(){
		float totalPaid = service.getTotalPaid();
		 return new ResponseEntity<Float>(totalPaid,HttpStatus.OK);
		
	}

}
