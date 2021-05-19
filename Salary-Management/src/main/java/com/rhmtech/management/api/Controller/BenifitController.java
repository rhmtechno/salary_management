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

import com.rhmtech.management.api.model.SalaryGrade;
import com.rhmtech.management.api.service.GradeService;

@RestController
@RequestMapping("\benifit")
public class BenifitController {
	@Autowired
	private GradeService gradeService;
	
	
	final String [] gradeholder= {"grade one","grade two","grade three","grade four","grade five","grade six"};
	final float gradediff=5000;


	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<SalaryGrade>> retriveGrade() {

		List<SalaryGrade> acclist = gradeService.fetchAllGrade();
		return new ResponseEntity<List<SalaryGrade>>(acclist, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/addgrade", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalaryGrade> addEmployee(@RequestBody SalaryGrade grade) {
		SalaryGrade sgrade = gradeService.addGrade(grade);
		return new ResponseEntity<SalaryGrade>(sgrade, HttpStatus.OK);

	}
	

	@RequestMapping(value = "/lowestgrade/{amount}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<SalaryGrade>> addLowestGrade(@PathVariable("amount") float amount) {
		List<SalaryGrade> sgrade = gradeService.addLowest(amount,gradeholder,gradediff);
		return new ResponseEntity<List<SalaryGrade>>(sgrade, HttpStatus.OK);

	}
	
	

	@RequestMapping(value = "/fetchemployeeacc/{idpkey}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findacc(@PathVariable(name = "idpkey") long id) {

		if (id < 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			SalaryGrade acc = gradeService.findEmplyee(id);
			if (acc != null) {
				return new ResponseEntity<>(acc, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Account not exits in our database", HttpStatus.NO_CONTENT);
			}

		}

	}

	@RequestMapping(value = "/{idpkey}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalaryGrade> updateEmployeeAcc(@PathVariable(name = "idpkey") long id,
			@RequestBody SalaryGrade acc) {
		SalaryGrade empacc = gradeService.updateGrade(id, acc);
		return new ResponseEntity<SalaryGrade>(empacc, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{idpkey}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> deleteEmployeeAcc(@PathVariable(name = "idpkey") long id) {
		String response = gradeService.deleteAcc(id);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/fetchByGradeId/{gradeid}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findByAccNo(@PathVariable(name = "gradeid") long id) {
		if (id < 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			SalaryGrade acc = gradeService.findBygrade(id);
			if (acc != null) {
				return new ResponseEntity<>(acc, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Account not exits in our database", HttpStatus.NO_CONTENT);
			}

		}

	}


}
