package com.infy.dto;

import com.infy.domain.Employee;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;


public class EmployeeDTO {

	@Digits(message="Id should be in digits", fraction = 0, integer = 5)
	private int empId;
	@NotNull(message="Name cannot be empty")
	private String empName;
	private String department;
	private String baseLocation;
	private String address;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public EmployeeDTO() {}
	
	public EmployeeDTO(int empId, String empName, String department, String baseLocation, String address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.baseLocation = baseLocation;
		this.address = address;
	}
	
	public static Employee prepareEmployeeEntity(EmployeeDTO employeeDTO) {
		Employee employeeEntity = new Employee();
		employeeEntity.setEmpId(employeeDTO.getEmpId());
		employeeEntity.setEmpName(employeeDTO.getEmpName());
		employeeEntity.setDepartment(employeeDTO.getDepartment());
		employeeEntity.setBaseLocation(employeeDTO.getBaseLocation());
		employeeEntity.setAddress(employeeDTO.getAddress());
		return employeeEntity;
	}
	
}
