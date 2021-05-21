package com.rhmtech.management.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rhmtech.management.api.Repository.SalaryRepo;
import com.rhmtech.management.api.dto.TotalSalaryDto;
import com.rhmtech.management.api.model.Company_bank_acc;
import com.rhmtech.management.api.model.Salary;

@Service
public class SalaryService {
	@Autowired
	private SalaryRepo repo;

	public List<Salary> getSalary() {
		return repo.getAllSalary();
	}

	public void saveCompleteData(List<Salary> salary) {
		repo.saveAll(salary);

	}

	public Salary getSalaryById(long id) {
		return repo.getAllSalary(id);
	}

	public float totalSalary() {
		List<Salary> slist = repo.getAllSalary();
		return  getTotal(slist);
	}

	private float getTotal(List<Salary> slist) {
		double tsalary = slist.stream().parallel().map(employee -> employee.getTotalSalary()).mapToDouble(i -> i).sum();
		return (float) tsalary;
	}

}
