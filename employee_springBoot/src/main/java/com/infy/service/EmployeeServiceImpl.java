package com.infy.service;

import java.util.List;
import java.util.Optional;
import com.infy.dto.EmployeeDTO;
import com.infy.exception.EmployeeException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.infy.domain.Employee;
import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository repository;

//	@Override
//	public String addEmployee(EmployeeDTO emp) {
//		repository.saveAndFlush(EmployeeDTO.prepareEmployeeEntity(emp));
//		return "Customer with "+emp.getEmpId()+" added successfully";
//	}
//	
	
	@Override
	public String addEmployee(EmployeeDTO emp) throws EmployeeException {
		
		Optional<Employee> employee=repository.findById(emp.getEmpId());
		if(employee.isEmpty()) {
			repository.saveAndFlush(EmployeeDTO.prepareEmployeeEntity(emp));
			return "Customer with "+emp.getEmpId()+" added successfully";

		}
		else {
			throw new EmployeeException("Employee Already Exists");
		}
	}
	
	
	@Override
	public String updateEmployee(int empId, String baseLocation) throws EmployeeException {
		Optional<Employee> employee = repository.findById(empId);
		if(!(employee.isEmpty())) {
			Employee emp = employee.get();
			emp.setBaseLocation(baseLocation);
			repository.save(emp);
			return "The department for the employee EmpId:"+empId+" has been updated successfully.";
		}
		else {
			throw new EmployeeException("Employee is not Existed");

		}
		
	}
	
	
	
	@Override
	public List<Employee> findAll(Sort sort) {
		return repository.findAll(sort);
	}
	
	@Override
	public List<EmployeeDTO> fetchEmployee(){
		return null;

	}
	
	@Override
	public Optional<Employee> findById(int empId){
		return repository.findById(empId);
	}
	
	@Override
	public EmployeeDTO findEmployee(int empId) throws EmployeeException {
		Optional<Employee> employee=repository.findById(empId);
		Employee emp=employee.orElseThrow(() -> new EmployeeException("Employee Not Found"));
		EmployeeDTO employeeDTO=new EmployeeDTO(emp.getEmpId(),emp.getEmpName(),emp.getDepartment(),emp.getBaseLocation(), emp.getAddress());
		
		return employeeDTO ;
	}
	
	
	@Override
	public EmployeeDTO findEmployeeV2(int empId) throws EmployeeException {
		Optional<Employee> employee=repository.findById(empId);
		Employee emp=employee.orElseThrow(() -> new EmployeeException("Employee Not Found"));
		EmployeeDTO employeeDTO=new EmployeeDTO(emp.getEmpId(),emp.getEmpName(),emp.getDepartment(),emp.getBaseLocation(), emp.getAddress());
		
		return employeeDTO ;
	}
	
	
	
	@Override
	public void removeEmployee(int empId) throws EmployeeException {
		
		Optional<Employee> employee=repository.findById(empId);
		Employee emp=employee.orElseThrow(() -> new EmployeeException("Employee Not Found"));	
		repository.deleteById(empId);
		
	}
	
	
	@Override
	public Page<Employee> findAll(Pageable page) {
		return repository.findAll(page);
		
	}
	

	@Override
	public EmployeeDTO searchEmployee(int empId) {
		Optional<Employee> optional = repository.findById(empId);
		Employee employee = optional.get();
		EmployeeDTO eDto = Employee.prepareEmployeeDTO(employee);
		return eDto;
	}

	@Override
	public List<EmployeeDTO> viewAllEmployee() {
		return null;
	}

	

	
	
	

	

}
