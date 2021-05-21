package com.rhmtech.management.api.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rhmtech.management.api.exception.EmployeeeServiceExp;
import com.rhmtech.management.api.model.ErrorMassage;

@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(EmployeeeServiceExp.class)
	public ResponseEntity<ErrorMassage> mapException(EmployeeeServiceExp ex) {
		ErrorMassage error = new ErrorMassage(ex.getMessage());
		return new ResponseEntity<ErrorMassage>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
