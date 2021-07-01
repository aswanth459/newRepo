package com.infy.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.infy.dto.EmployeeDTO;

@Entity
public class Employee {
	@Id
	private int empId;
	private String empName;
	private String department;
	private String baseLocation;
	private String address;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//private Address address;
	
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
	
	public Employee() {}
	
	public Employee(int empId, String empName, String department, String baseLocation, String address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.baseLocation = baseLocation;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", department=" + department + ", baseLocation="
				+ baseLocation + ", address=" + address + "]";
	}
	
	public static EmployeeDTO prepareEmployeeDTO(Employee e) {
		EmployeeDTO empDto = new EmployeeDTO();
		empDto.setEmpId(e.getEmpId());
		empDto.setEmpName(e.getEmpName());
		empDto.setDepartment(e.getDepartment());
		empDto.setBaseLocation(e.getBaseLocation());
		empDto.setAddress(e.getAddress());
		return empDto;
	}
	
	

}
