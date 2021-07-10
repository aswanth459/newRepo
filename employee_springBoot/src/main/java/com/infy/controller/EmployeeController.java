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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import com.infy.dto.EmployeeDTO;
import com.infy.exception.EmployeeException;
import com.infy.service.EmployeeService;


import com.infy.domain.Employee;



@RestController
//@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	
	// Inserting employee details using @RequestBody
	
	@PostMapping(path="/setEmp",consumes="application/json")
	public ResponseEntity CreateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws EmployeeException{
		
			
		String response=employeeService.addEmployee(employeeDTO);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	
	
	//getting the employee data using ID, @pathVariable 
	
//	@GetMapping(value = "/getId/{id}")
//	public Optional<Employee> findEmployee(@PathVariable("id") int id){
//		return employeeService.findById(id);
//	}
	
	@GetMapping(value = "/getId/{empId}")
	public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable int empId) throws EmployeeException{
		return new ResponseEntity<>(employeeService.findEmployee(empId),HttpStatus.OK);
		//return employeeService.findById(id);
	}
	
	
	//Fetching all employee details 
	
		@GetMapping(path="/getEmp",produces="application/json")
		public List<Employee> fetchEmployee(){
//			System.out.println("Sorted employee records");
//			Iterable<Employee> emp = employeeService.findAll(Sort.by(Sort.Direction.DESC, "empName"));
//			for(Employee e: emp) {
//				System.out.println(e);
//			}
			return employeeService.findAll(Sort.by(Sort.Direction.DESC, "empName"));
		}
		
	
	//Updating employee details using @RequestParam
	
	@PutMapping(value="/update")
	public ResponseEntity updateEmp(@RequestParam("id") int id, @RequestParam("baseLocation") String baseLocation) throws EmployeeException {
		String response= employeeService.updateEmployee(id, baseLocation);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	//Deleting employee details using @PathVariable
	
	@GetMapping(value="/delete/{id}")
	public String deleteEmp(@PathVariable("id") int id) throws EmployeeException {
		 employeeService.removeEmployee(id);
		 //return new ResponseEntity(HttpStatus.OK);
		 return "deleted "+id+ "successfully";
	}
	
//	@GetMapping(value="/delete/{id}")
//	public String deleteEmp(@PathVariable("id") @Pattern(regexp="[0-9]{0,6}", message="{employee.id.invalid}") int id) throws NoSuchEmployeeException {
//		 employeeService.removeEmployee(id);
//		 return "deleted "+id+ "successfully";
//
//	}
}
