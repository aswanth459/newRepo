package com.infy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.infy.domain.Employee;
import com.infy.dto.EmployeeDTO;
import com.infy.exception.EmployeeException;

public interface EmployeeService {
	public String addEmployee(EmployeeDTO emp) throws EmployeeException;
	public String updateEmployee(int empId, String dept) throws EmployeeException;
	public void removeEmployee(int empId) throws EmployeeException;
	public EmployeeDTO findEmployee(int empId) throws EmployeeException;
	
	public EmployeeDTO searchEmployee(int empId);
	public List<EmployeeDTO> viewAllEmployee();

	//public List<Employee> findEmp(int empId);
	Page<Employee> findAll(Pageable page);
	List<Employee> findAll(Sort sort);
	public Optional<Employee> findById(int id);
	
}
