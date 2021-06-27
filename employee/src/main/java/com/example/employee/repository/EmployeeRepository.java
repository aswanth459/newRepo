package com.example.employee.repository;

import java.util.List;

import com.example.employee.DTO.EmployeeDTO;

public interface EmployeeRepository {

	public void insertEmployee(EmployeeDTO emp);

	public void removeEmployee(int empId);

	List<EmployeeDTO> fetchCustomer();

}
