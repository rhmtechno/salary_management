package com.rhmtech.management.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.Repository.EmployeeBankRepo;
import com.rhmtech.management.api.model.Employee;
import com.rhmtech.management.api.model.Employee_bank_acc;

@Service
public class EmployeeBankService {
	@Autowired
	private EmployeeBankRepo bankRepo;

	public List<Employee_bank_acc> fetchAllEmployee() {

		return bankRepo.findAll();
	}

	public Employee_bank_acc findEmplyee(long id) {
		Optional<Employee_bank_acc> findById = bankRepo.findById(id);
		if (findById.isPresent()) {
			Employee_bank_acc acc = findById.get();
			return acc;
		} else {
			System.out.println("Employee Not availble in Db");
		}
		return null;
	}

	public Employee_bank_acc updateProduct(long id, Employee_bank_acc acc) {
		Employee_bank_acc getaccInfo = findEmplyee(id);
		if (getaccInfo != null) {
			acc.setAccid(getaccInfo.getAccid());
			return bankRepo.save(acc);
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public String deleteAcc(long id) {
		Employee_bank_acc getaccInfo = findEmplyee(id);
		if (getaccInfo != null) {
			bankRepo.delete(getaccInfo);
			return "data deleted success";
		} else {
			return "Record Not availble in Db";
		}
	}

	public Employee_bank_acc findByccc_no(String id) {
		
		return bankRepo. findByAccnumber(id);
	}

}
