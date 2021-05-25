package com.rhmtech.management.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.management.api.Repository.EmployeeRepo;
import com.rhmtech.management.api.dto.EmployeeDto;
import com.rhmtech.management.api.exception.EmployeeeServiceExp;
import com.rhmtech.management.api.model.Employee;
import com.rhmtech.management.api.model.Employee_bank_acc;

@Service
@DynamicUpdate
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);

	}

	public Employee findEmplyee(long id) throws EmployeeeServiceExp {
		Employee emp = null;
		try {
			emp = employeeRepo.findById(id).get();
		} catch (Exception e) {
			throw new EmployeeeServiceExp(e.getLocalizedMessage());
		}

		return emp;
	}

	public Employee updateProduct(long id, Employee employee) throws EmployeeeServiceExp {
		Employee getemployee = findEmplyee(id);
		if (getemployee != null) {
			getemployee.setName(employee.getName());
			getemployee.setGrade(employee.getGrade());
			getemployee.setAddress(employee.getAddress());
			getemployee.setMobile(employee.getMobile());
			// getemployee.setEmp_bank(getemployee.getEmp_bank());
			return employeeRepo.save(getemployee);
		} else {
			System.out.println("Record Not availble in Db");
		}
		return null;
	}

	public String deleteEmployee(long id) throws EmployeeeServiceExp {
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

	public List<EmployeeDto> fetchAllEmployeeDto() {
		List<Employee> findAll = employeeRepo.findAll();
		List<EmployeeDto> dlist = new ArrayList<>();
		for (Employee e : findAll) {
			EmployeeDto dto = new EmployeeDto();
			Employee_bank_acc aa = e.getEmp_bank();
			long grade = e.getGrade();
			String name = e.getName();
			String mobile = e.getMobile();
			String add = e.getAddress();
			//
			dto.setCurrball(aa.getCurr_bal());
			dto.setEmpId(e.getEmp_id());
			dto.setAcc_type(aa.getAcc_type());
			dto.setGrade(grade);
			dto.setName(name);
			dto.setMobile(mobile);
			dto.setAddress(add);
			dto.setAccnumber(aa.getAccnumber());
			dto.setBank_name(aa.getBank_name());
			dto.setBank_branch(aa.getBank_branch());
			dlist.add(dto);
			};
		return dlist;
	}

	public EmployeeDto addEmployeev2(EmployeeDto dto, Employee employee, Employee_bank_acc empb) {
		employee.setName(dto.getName());
		employee.setMobile(dto.getMobile());
		employee.setAddress(dto.getAddress());
		employee.setGrade(dto.getGrade());
		empb.setAcc_name(dto.getName());
		empb.setCurr_bal(0);
		empb.setAcc_type(dto.getAcc_type());
		empb.setBank_branch(dto.getBank_branch());
		empb.setBank_name(dto.getBank_name());
		empb.setAccnumber(dto.getAccnumber());
		employee.setEmp_bank(empb);
		Employee save = employeeRepo.save(employee);
		return null;
	}

}
