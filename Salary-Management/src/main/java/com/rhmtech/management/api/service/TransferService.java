package com.rhmtech.management.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.model.Company_bank_acc;
import com.rhmtech.management.api.model.Salary;

@Service
public class TransferService {
	@Autowired
	private SalaryService sservice;
	@Autowired
	private CompanyService cservice;
	
	public boolean validate(String cacc) {
		Salary totalSalary = sservice.totalSalary();
		float totalSalary2 = totalSalary.getTotalSalary();
		
		Company_bank_acc findByAccnumber = cservice.findByAccnumber(cacc);
		float curr_bal = findByAccnumber.getCurr_bal();
		
		if(curr_bal>=totalSalary2) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
