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
import com.rhmtech.management.api.model.HeadsBenifits;
import com.rhmtech.management.api.service.BenifitService;


@RestController
@RequestMapping("/benifit")
public class BenifitController {
	@Autowired
	private BenifitService service;

	/* Fetch all */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<HeadsBenifits>> retriveAll() {
		List<HeadsBenifits> allData = service.fetchAll();
		return new ResponseEntity<List<HeadsBenifits>>(allData, HttpStatus.OK);
	}

	/* Add new */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<HeadsBenifits> addData(@RequestBody HeadsBenifits payload) {
		HeadsBenifits rvalue = service.addNew(payload);
		return new ResponseEntity<HeadsBenifits>(rvalue, HttpStatus.OK);

	}

	

	/*
	 * find by id
	 */	
	@RequestMapping(value = "/fethbyPkId/{idpkey}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findById(@PathVariable(name = "idpkey") long id) {
		if (id < 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			HeadsBenifits rvalue = service.findOne(id);
			if (rvalue != null) {
				return new ResponseEntity<>(rvalue, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Data not exits in our database", HttpStatus.NO_CONTENT);
			}

		}

	}
	/* update */
	@RequestMapping(value = "/{idpkey}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<HeadsBenifits> doUpdate(@PathVariable(name = "idpkey") long id,
			@RequestBody HeadsBenifits payload) {
		HeadsBenifits rvalue = service.doUpdate(id, payload);
		return new ResponseEntity<HeadsBenifits>(rvalue, HttpStatus.CREATED);

	}

	/* delete */
	@RequestMapping(value = "/{idpkey}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> doDelete(@PathVariable(name = "idpkey") long id) {
		String response = service.doDelete(id);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}

	

}
