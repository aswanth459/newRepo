package com.example.employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}


//
//package com.infy.demo1; 
//import org.springframework.context.annotation.AnnotationConfigApplicationContext; 
//import org.springframework.context.support.AbstractApplicationContext; 
//
//import org.springframework.context.annotation.Configuration; 
//import org.springframework.context.annotation.Bean;
//interface EmployeeService 
//	{ 
//		public void insert(EmployeeDTO emp); 
//		public void delete(int empId); 
//	} 
//class EmployeeDTO 
//	{ 
//		private int empId; 
//		private String empName; 
//		private String department; 
//		public int getempId() 
//			{ 
//				return this.empId; 
//			} 
//		public String getempName() 
//			{ 
//				return this.empName; 
//			} 
//		public String getdepartment() 
//			{ 
//				return this.department; 
//			}
//		public void setempId(int empId) 
//			{ 
//				this.empId = empId;
//			}
//		
//		public void setempName(String empName) 
//			{
//				this.empName = empName;
//			}
//		public void setdepartment(String department)
//			{
//				this.department = department; 
//			} 
//	}
//class EmployeeServiceImpl implements EmployeeService { 
//	// For this exercise no need to have EmployeeRepository we will implement repository later in this course 
//	// EmployeeRepository employeeDAO = new EmployeeRepositoryImpl(); 
//	@Override 
//	public void insert(EmployeeDTO emp) { 
//		System.out.println("inserted"); 
//		}
//	public void delete(int empId) { 
//		System.out.println("deleted"); 
//		} 
//	}
//@Configuration 
//class SpringConfig { 
//	@Bean 
//	public EmployeeServiceImpl employeeserviceImpl() {
//		return new EmployeeServiceImpl(); 
//		}
//	}
//class Client1 { 
//	public static void main(String[] args) {
//		EmployeeServiceImpl Service = null; 
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//		Service = (EmployeeServiceImpl) context.getBean("employeeserviceImpl"); 
//		EmployeeDTO emp = new EmployeeDTO(); 
//		emp.setempId(1001); 
//		emp.setempName("Shambhu");
//		emp.setdepartment("Production");
//		Service.insert(emp);
//		Service.delete(0); context.close(); }}
//}