package com.rhmtech.management.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rhmtech.management.api.dto.ValidateDto;
import com.rhmtech.management.api.service.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	@Autowired
	private TransferService service;
	
	
	@RequestMapping(value = "/validate/{comAccno}" ,method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ValidateDto> validTransfer(String comAccno,ValidateDto dto) {
		boolean validate = service.validate(comAccno);
		dto.setValidate(validate);
		System.out.println(validate);
		return new ResponseEntity<ValidateDto>(dto,HttpStatus.OK);
	}
	
	

}
