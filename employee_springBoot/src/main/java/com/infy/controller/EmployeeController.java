package com.infy.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;


import com.infy.dto.EmployeeDTO;
import com.infy.service.EmployeeService;


import com.infy.domain.Employee;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public List<EmployeeDTO> fetchEmployee(){
		System.out.println("Sorted employee records");
		Iterable<Employee> emp = employeeService.findAll(Sort.by(Sort.Direction.DESC, "empName"));
		for(Employee e: emp) {
			System.out.println(e);
		}
	}
	public ResponseEntity<String> CreateEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		String response=employeeService.addEmployee(employeeDTO);
		return ResponseEntity.ok(response);
	}
}
