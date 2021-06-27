package com.example.employee.service;

import java.util.List;

import com.example.employee.DTO.EmployeeDTO;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.EmployeeRepositoryImpl;

//public class EmployeeServiceImpl implements EmployeeService {
//	 // For this exercise no need to have EmployeeRepository  we will implement repository later in this course
////		EmployeeRepository employeeDAO = new EmployeeRepositoryImpl();
//		
//	@Override
//		public void insert(EmployeeDTO emp) {
//			System.out.println("inserted");
//		}
//		public void delete(int empId) {
//			System.out.println("deleted");
//		}
//}

public class EmployeeServiceImpl implements EmployeeService {
	//EmployeeRepository employeeDAO = new EmployeeRepositoryImpl();// Make necesserychanges
	
	EmployeeRepository employeeDAO;



	   public EmployeeServiceImpl(EmployeeRepository employeeDAO) {

	      this.employeeDAO = employeeDAO;

	   }
	@Override
	public void insert(EmployeeDTO emp) {
		employeeDAO.insertEmployee(emp);
	}
	
	@Override
	public void delete(int empId) {
		employeeDAO.removeEmployee(empId);
	}
	
	@Override
	public List<EmployeeDTO> getAllCustomer() {
		
		return employeeDAO.fetchCustomer();
	}
}
