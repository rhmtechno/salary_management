package com.rhmtech.management.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rhmtech.management.api.Repository.SalaryRepo;
import com.rhmtech.management.api.model.Salary;

@Service
public class SalaryService {
	@Autowired
	private SalaryRepo repo;
	
	
	public List<Salary> getSalary (){
		return repo.getAllSalary();
	}


	public Salary getSalaryById(long id) {
		return  repo.getAllSalary(id);
	}

}
