package com.rhmtech.management.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rhmtech.management.api.model.Employee_bank_acc;
import com.rhmtech.management.api.service.EmployeeBankService;

@RestController
@RequestMapping("/empaccount")
public class EmployeeBankController {

	@Autowired
	private EmployeeBankService bankservice;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee_bank_acc>> retriveAccount() {

		List<Employee_bank_acc> acclist = bankservice.fetchAllEmployee();
		return new ResponseEntity<List<Employee_bank_acc>>(acclist, HttpStatus.OK);

	}

	@RequestMapping(value = "/fetchemployeeacc/{accid}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findacc(@PathVariable(name = "accid") long id) {

		if (id < 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Employee_bank_acc acc = bankservice.findEmplyee(id);
			if (acc != null) {
				return new ResponseEntity<>(acc, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Account not exits in our database", HttpStatus.NO_CONTENT);
			}

		}

	}

	@RequestMapping(value = "/{accid}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee_bank_acc> updateEmployeeAcc(@PathVariable(name = "accid") long id,
			@RequestBody Employee_bank_acc acc) {
		System.out.println(id);
		Employee_bank_acc empacc = bankservice.updateProduct(id, acc);
		return new ResponseEntity<Employee_bank_acc>(empacc, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{accid}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> deleteEmployeeAcc(@PathVariable(name = "accid") long id) {
		String response = bankservice.deleteAcc(id);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}
	
	
	
	@RequestMapping(value = "/fetchByAcc/{accno}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findByAccNo(@PathVariable(name = "accno") long id) {
		if (id < 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Employee_bank_acc acc = bankservice.findByccc_no(id);
			if (acc != null) {
				return new ResponseEntity<>(acc, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Account not exits in our database", HttpStatus.NO_CONTENT);
			}

		}

	}
	
	

}
