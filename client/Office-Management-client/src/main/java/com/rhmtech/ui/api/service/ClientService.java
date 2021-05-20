package com.rhmtech.ui.api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rhmtech.ui.api.model.Employee;
import com.rhmtech.ui.api.model.Employee_bank_acc;

@Service
public class ClientService {
	@Autowired
	private RestTemplate template;



	public Employee[] CallGetAllUserAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//		ResponseEntity<String> result = restTemplate.exchange(envSetup.getAllgetApi(), HttpMethod.GET, entity,
//				String.class);
//		System.out.println(result);
		// return result;
		ResponseEntity<Employee[]> responseEntity = template.getForEntity("", Employee[].class);
		Employee[] objects = responseEntity.getBody();
		System.out.println(objects);
		return objects;
//		 for(User ob:objects) {
//		 System.out.println(ob.getId());
//		 System.out.println(ob.getName());
//		 System.out.println(ob.getEmail());
//		
//	             }

	}

	public ResponseEntity<String> CallGetAllUserAPIJson() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<String> result = template.exchange("http://localhost:8080/employee", HttpMethod.GET, entity, String.class);
		return result;
	}
	
	
	public void callCreateUserApi(Employee employee) {
		ResponseEntity<Employee> user2 = template.postForEntity("http://localhost:8080/employee/addemployee", employee, Employee.class);
		System.out.println(user2.getBody());
	}
}
