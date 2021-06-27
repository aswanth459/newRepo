package com.example.employee.DTO;

//public class EmployeeDTO {
//	private int empId;
//	private String empName;
//	private String department;
//	
//}


public class EmployeeDTO { 
	
	private int empId; 
	private String empName; 
	private String department; 
	
	public int getempId() { 
		return this.empId; 
	} 
	public String getempName() { 
		return this.empName; 
	} 
	public String getdepartment() { 
		return this.department; 
	}
	public void setempId(int empId) { 
		this.empId = empId;
	}
	
	public void setempName(String empName) {
		this.empName = empName;
	}
	public void setdepartment(String department){
		this.department = department; 
	} 
}
