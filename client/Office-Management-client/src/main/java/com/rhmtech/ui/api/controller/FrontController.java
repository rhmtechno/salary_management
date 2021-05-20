package com.rhmtech.ui.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhmtech.ui.api.service.ClientService;
import com.rhmtech.ui.api.model.Employee;
import com.rhmtech.ui.api.model.Employee_bank_acc;

import java.util.List;

@Controller
public class FrontController {
	@Autowired
	private ClientService service;
	@RequestMapping("/")
	public String home() {
		return "index";
		
	}
	
	
	@GetMapping("/gson")
	public ResponseEntity<List<Employee>> gSonTest() throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> res = service.CallGetAllUserAPIJson();
		String JsonString = res.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<Employee> map = mapper.readValue(JsonString, new TypeReference<List<Employee>>() {
		});
		System.out.println(res.getStatusCodeValue());
		//resClient.saveAllUserResponse2(map);
		
		for (Employee u : map) { System.out.println(u.getAddress());
		 System.out.println(u.getName()); }
		
		return new ResponseEntity<List<Employee>>(map,HttpStatus.OK);
	}
	
	@GetMapping("/create")
	public void createEmp(Employee employee,Employee_bank_acc emp_bank) {
		employee.setEmp_bank(emp_bank);
		service.callCreateUserApi(employee);
		
	}

}
