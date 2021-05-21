package com.rhmtech.management.api.Controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rhmtech.management.api.dto.ValidateDto;
import com.rhmtech.management.api.service.TransferService;

@RestController
@RequestMapping("/transfer")
@CrossOrigin(origins = "http://localhost:4200")
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
	
	
	@RequestMapping(value = "/validatev2/{comAccno}" ,method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Boolean> validTransferV2(@PathVariable(name = "comAccno")String  comAccno,ValidateDto dto) {
		boolean validate = service.validate(comAccno);
		return new ResponseEntity<Boolean>(validate,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/initiateTransfer/{comAccno}" ,method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ValidateDto> doTransfer(String comAccno,ValidateDto dto) {
		boolean validate = service.validate(comAccno);
		if(validate) {
        service.InitiateTransfer(comAccno);
        dto.setValidate(validate);
		}
		return new ResponseEntity<ValidateDto>(dto,HttpStatus.OK);
	}
	

}
