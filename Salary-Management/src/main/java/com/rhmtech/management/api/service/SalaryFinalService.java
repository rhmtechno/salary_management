package com.rhmtech.management.api.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.Repository.SalaryFinalRepo;

import com.rhmtech.management.api.model.SalaryFinal;

@Service
public class SalaryFinalService {
	@Autowired
	private SalaryFinalRepo repo;
	
	

	public void saveCompleteData(SalaryFinal salary) {
		repo.save(salary);
		
	}

}
