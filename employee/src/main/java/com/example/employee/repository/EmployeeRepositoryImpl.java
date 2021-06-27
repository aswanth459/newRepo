package com.example.employee.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import com.example.employee.DTO.EmployeeDTO;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	List<EmployeeDTO> employee = null;
	
	@PostConstruct
	public void initializer() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setempId(101);
		employeeDTO.setempName("Jack");
		employeeDTO.setdepartment("ETA");
		employee = new ArrayList<>();
		employee.add(employeeDTO);
	}
	@Override
	public void insertEmployee(EmployeeDTO emp) {
		employee.add(emp);
	}
	@Override
	public void removeEmployee(int empId) {
		employee.remove(empId);
	}
	public List<EmployeeDTO> fetchCustomer() {
		return employee;
	}
}
