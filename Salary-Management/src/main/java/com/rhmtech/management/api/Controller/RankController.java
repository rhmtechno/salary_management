package com.rhmtech.management.api.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rhmtech.management.api.model.Rank;
import com.rhmtech.management.api.service.RankService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rank")
public class RankController {
	@Autowired
	private RankService service;
	Logger log = LoggerFactory.getLogger(RankController.class);

	/* Fetch all */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Rank>> retriveAll() {
		List<Rank> allData = service.fetchAll();
		return new ResponseEntity<List<Rank>>(allData, HttpStatus.OK);
	}

	/* Add new */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Rank> addData(@RequestBody Rank payload) {
		Rank rvalue = service.addNew(payload);
		return new ResponseEntity<Rank>(rvalue, HttpStatus.OK);

	}

	

	/*
	 * find by id
	 */	
	@RequestMapping(value = "/fethbyPkId/{idpkey}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findById(@PathVariable(name = "idpkey") long id) {
		if (id < 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Rank rvalue = service.findOne(id);
			if (rvalue != null) {
				return new ResponseEntity<>(rvalue, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Data not exits in our database", HttpStatus.NO_CONTENT);
			}

		}

	}
	/* update */
	@RequestMapping(value = "/{idpkey}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Rank> doUpdate(@PathVariable(name = "idpkey") long id,
			@RequestBody Rank payload) {
		Rank rvalue = service.doUpdate(id, payload);
		return new ResponseEntity<Rank>(rvalue, HttpStatus.CREATED);

	}

	/* delete */
	@RequestMapping(value = "/{idpkey}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<String> doDelete(@PathVariable(name = "idpkey") long id) {
		String response = service.doDelete(id);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}

	

}
