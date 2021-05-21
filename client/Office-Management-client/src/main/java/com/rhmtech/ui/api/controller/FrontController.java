package com.rhmtech.ui.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhmtech.ui.api.service.ClientService;
import com.rhmtech.ui.api.model.Employee;
import com.rhmtech.ui.api.model.EmployeeDto;
import com.rhmtech.ui.api.model.Grade;
import com.rhmtech.ui.api.model.SalaryGrade;

import java.util.List;

@Controller
public class FrontController {
	@Autowired
	private ClientService service;
	@RequestMapping("/")
	public String home() {
		return "employee";
		
	}
	
	
	
	@GetMapping("/gson")
	public String gSonTest(Model model) throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> res = service.CallGetAllUserAPIJson();
		String JsonString = res.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<Employee> map = mapper.readValue(JsonString, new TypeReference<List<Employee>>() {
		});
		model.addAttribute("status",map);
		return "viewemp";
	}
	
	@PostMapping("/create")
	public String createEmp(EmployeeDto dto) {
		service.callCreateUserApi(dto);
		return "viewemp";
	}
	@GetMapping("/addgrade")
	public String addGrade() {
		return "grade";
	}
	
	@PostMapping("/grade")
	public String createGrade(Grade grade) {
		service.callCreateGradeApi(grade.getAmount());
		return "redirect:/viewgrade";
	}
	
	@GetMapping("/viewgrade")
	public String viewGrade(Model model) throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> res = service.CallGetAllGradeAPIJson();
		String JsonString = res.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<SalaryGrade> map = mapper.readValue(JsonString, new TypeReference<List<SalaryGrade>>() {
		});
		model.addAttribute("status",map);
		return "viewgrade";
	}
	

}
