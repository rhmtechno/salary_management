package com.rhmtech.management.api.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.Repository.EmployeeRepo;
import com.rhmtech.management.api.model.Employee;

@Service
@DynamicUpdate
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);

	}

	public Employee findEmplyee(long id) {
		Optional<Employee> findById = employeeRepo.findById(id);
		if (findById.isPresent()) {
			Employee employee = findById.get();
			return employee;
		} else {
			System.out.println("Employee Not availble in Db");
		}
		return null;
	}

	public Employee updateProduct(long id, Employee employee) {
		Employee getemployee = findEmplyee(id);
		if (getemployee != null) {
			getemployee.setName(employee.getName());
			getemployee.setGrade(employee.getGrade());
			getemployee.setAddress(employee.getAddress());
			getemployee.setMobile(employee.getMobile());
			//getemployee.setEmp_bank(getemployee.getEmp_bank());
			return employeeRepo.save(getemployee);
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public String deleteEmployee(long id) {
		Employee getemployee = findEmplyee(id);
		if (getemployee != null) {
			employeeRepo.delete(getemployee);
			return "data deleted success";
		} else {
			return "Record Not availble in Db";
		}
	}

	public List<Employee> fetchAllEmployee() {

		return employeeRepo.findAll();
	}

}
