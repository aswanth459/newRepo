/*package com.infy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.dto.ErrorMessage;

@RestControllerAdvice
public class EmployeeException {

	
	@ExceptionHandler(NoSuchEmployeeException.class)
	public ResponseEntity<Object> exceptionHandler(NoSuchEmployeeException ex) {
		ErrorMessage error = new ErrorMessage();
	error.setErrorCode(HttpStatus.BAD_REQUEST.value());
//		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
*/


package com.infy.exception;



public class EmployeeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmployeeException() {
		super();
	}
	
	public EmployeeException(String message) {
		super(message);
		
	}

	
}
