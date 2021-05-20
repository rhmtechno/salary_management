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

import com.rhmtech.management.api.model.Company_bank_acc;
import com.rhmtech.management.api.service.CompanyService;

@RestController
@RequestMapping("/companybank")
public class CompanyController {
	@Autowired
	private CompanyService service;

	/* Fetch all */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Company_bank_acc>> retriveAll() {
		List<Company_bank_acc> allData = service.fetchAll();
		return new ResponseEntity<List<Company_bank_acc>>(allData, HttpStatus.OK);
	}

	/* Add new */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Company_bank_acc> addData(@RequestBody Company_bank_acc payload) {
		Company_bank_acc rvalue = service.addNew(payload);
		return new ResponseEntity<Company_bank_acc>(rvalue, HttpStatus.OK);

	}

	/*
	 * find by id
	 */
	@RequestMapping(value = "/fethbyPkId/{idpkey}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findById(@PathVariable(name = "idpkey") long id) {
		if (id < 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Company_bank_acc rvalue = service.findOne(id);
			if (rvalue != null) {
				return new ResponseEntity<>(rvalue, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Data not exits in our database", HttpStatus.NO_CONTENT);
			}

		}

	}

	/* update */
	@RequestMapping(value = "/{idpkey}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Company_bank_acc> doUpdate(@PathVariable(name = "idpkey") long id,
			@RequestBody Company_bank_acc payload) {
		Company_bank_acc rvalue = service.doUpdate(id, payload);
		return new ResponseEntity<Company_bank_acc>(rvalue, HttpStatus.CREATED);

	}

	/* delete */
	@RequestMapping(value = "/{idpkey}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> doDelete(@PathVariable(name = "idpkey") long id) {
		String response = service.doDelete(id);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}
	
	
	/*
	 * find by accnumber
	 */
	@RequestMapping(value = "/fethbyAccNum/{accno}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findByAcc(@PathVariable(name = "accno") String id) {
		if (Integer.parseInt(id) < 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Company_bank_acc rvalue = service.findByAccnumber(id);
			if (rvalue != null) {
				return new ResponseEntity<>(rvalue, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Data not exits in our database", HttpStatus.NO_CONTENT);
			}

		}

	}
	
	
	

}
