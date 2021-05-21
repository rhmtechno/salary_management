package com.rhmtech.management.api.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.Repository.SalaryFinalRepo;
import com.rhmtech.management.api.model.Salary;
import com.rhmtech.management.api.model.SalaryFinal;

@Service
public class SalaryFinalService {
	@Autowired
	private SalaryFinalRepo repo;
	
	

	public void saveCompleteData(SalaryFinal salary) {
		repo.save(salary);
		
	}
	
	public float getTotalPaid() {
		List<SalaryFinal> findAll = repo.findAll();
		return  PaidProcess(findAll);
		
	}
	private float PaidProcess(List<SalaryFinal> slist) {
		double tsalary = slist.stream().parallel().map(employee -> employee.getTotalSalary()).mapToDouble(i -> i).sum();
		return (float) tsalary;
	}

}
