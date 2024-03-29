package com.rhmtech.management.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rhmtech.management.api.Repository.EmployeeBankRepo;
import com.rhmtech.management.api.dto.EmployeeDto;
import com.rhmtech.management.api.exception.EmployeeeServiceExp;
import com.rhmtech.management.api.model.Employee;
import com.rhmtech.management.api.model.Employee_bank_acc;
import com.rhmtech.management.api.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;

	@RequestMapping(value = "/addemployee", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee emp = empservice.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/addemployee/v2", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<EmployeeDto> addEmployeev2(@RequestBody EmployeeDto dto,Employee employee,Employee_bank_acc empb) {
		EmployeeDto emp = empservice.addEmployeev2(dto,employee,empb);
		return new ResponseEntity<EmployeeDto>(emp, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee>> retriveEmployee() {
		
		List<Employee> emplist = empservice.fetchAllEmployee();
		return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/ejoinb" ,method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<EmployeeDto>> retriveEmployeeDto() {
		List<EmployeeDto> emplist = empservice.fetchAllEmployeeDto();
		return new ResponseEntity<List<EmployeeDto>>(emplist, HttpStatus.OK);

	}

	@RequestMapping(value = "/fetchemployee/{emp_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> addEmployee(@PathVariable(name = "emp_id") long id) throws EmployeeeServiceExp {

		if (id < 1000) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Employee emp = empservice.findEmplyee(id);
			if (emp != null) {
				return new ResponseEntity<>(emp, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Product not exits in our database", HttpStatus.NO_CONTENT);
			}

		}

	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "employeeId") long id,
			@RequestBody Employee employee) throws EmployeeeServiceExp {
		Employee emp = empservice.updateProduct(id, employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteEmployee(@PathVariable(name = "employeeId") long id) throws EmployeeeServiceExp {
		String response = empservice.deleteEmployee(id);
		//return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}

}
