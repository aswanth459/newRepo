package com.example.employee.service;

import java.util.List;

import com.example.employee.DTO.EmployeeDTO;

public interface EmployeeService {

	public void insert(EmployeeDTO emp); 
	public void delete(int empId);
	public List<EmployeeDTO> getAllCustomer();



}
