package com.infy.controller;


import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.infy.dto.EmployeeDTO;
import com.infy.dto.ErrorMessage;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import com.infy.dto.EmployeeDTO;
import com.infy.exception.EmployeeException;
import com.infy.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.infy.domain.Employee;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "EmployeeController deal with API resources")

//@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	
	// Inserting employee details using @RequestBody
	@ApiOperation(value = "creating new Employee")
	@PostMapping(path="/setEmp",consumes="application/json")
	public ResponseEntity CreateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws EmployeeException{
		
			
		String response=employeeService.addEmployee(employeeDTO);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	
	
	//getting the employee data using ID, @pathVariable 
	@ApiOperation(value = "fetching employee details by employee id")	
	@GetMapping(value = "/getId/{empId}", params="version=1")
	public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable int empId) throws EmployeeException{
		return new ResponseEntity<>(employeeService.findEmployee(empId),HttpStatus.OK);
		//return employeeService.findById(id);
	}
	
	@ApiOperation(value = "fetching employee details by employee id")	
	@GetMapping(value = "/getId/{empId}", params="version=2")
	public ResponseEntity<EmployeeDTO> findEmployeeV2(@PathVariable int empId) throws EmployeeException{
		return new ResponseEntity<>(employeeService.findEmployee(empId),HttpStatus.OK);
		//return employeeService.findById(id);
	}
	
	
	//Fetching all employee details 

		//@CrossOrigin(origins = "*", allowedHeaders = "*")
		@ApiOperation(value = "fetching all employee details ")	
		@GetMapping(path="/getEmp",produces="application/json")
		public List<Employee> fetchEmployee(){

			return employeeService.findAll(Sort.by(Sort.Direction.DESC, "empName"));
		}
		
		@ApiOperation(value = "fetching all employee details ")	
		@GetMapping(path="/getEmp",produces="application/json")
		public List<EmployeeDTO> fetchEmployeeV2(){

			return employeeService.fetchEmployee();
		}
	
	//Updating employee details using @RequestParam
	@ApiOperation(value = "updating employee details by employee id")	
	@PutMapping(value="/update")
	public ResponseEntity updateEmp(@RequestParam("id") int id, @RequestParam("baseLocation") String baseLocation) throws EmployeeException {
		String response= employeeService.updateEmployee(id, baseLocation);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	//Deleting employee details using @PathVariable version 1
	@ApiOperation(value = "deleting employee details by employee id")	
	@GetMapping(value="/delete/{id}", params="version=1")
	public String deleteEmp(@PathVariable("id") int id) throws EmployeeException {
		 employeeService.removeEmployee(id);
		 //return new ResponseEntity(HttpStatus.OK);
		 return "deleted "+id+ "successfully";
	}
	
	
	//Deleting employee details using @PathVariable version 2
	@ApiOperation(value = "deleting employee details by employee id")	
	@GetMapping(value="/delete/{id}", params="version=2")
	public String deleteEmpV2(@PathVariable("id") int id) throws EmployeeException {
		 employeeService.removeEmployee(id);
		 //return new ResponseEntity(HttpStatus.OK);
		 return "deleted "+id+ "successfully";
	}
	
	
	
	//cross origin resource sharing - CORS
	@GetMapping("/demo")
	public String greeting() {
		return "Welcome to java portal";
	}
	
	//Rest template
	@GetMapping("/template")
	public ResponseEntity<String> trainEmployee() {
		String uri = "http://localhost:8095/customer";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	
	

}
