package com.rhmtech.management.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rhmtech.management.api.model.Salary;
import com.rhmtech.management.api.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {
	@Autowired
	private SalaryService service;
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Salary>> getSalary(){
		 List<Salary> salary = service.getSalary();
		 return new ResponseEntity<List<Salary>>(salary,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/{empId}",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Salary> getSalaryById(@PathVariable(name = "empId")long id){
		 Salary salary = service.getSalaryById(id);
		 return new ResponseEntity<Salary>(salary,HttpStatus.OK);
		
	}

}
