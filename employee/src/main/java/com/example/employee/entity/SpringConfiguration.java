package com.example.employee.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.employee.repository.EmployeeRepositoryImpl;
import com.example.employee.service.EmployeeServiceImpl;

//import com.example.employee.EmployeeServiceImpl;



@Configuration
public class SpringConfiguration {
	@Bean(name = "EmployeeRepositoryImpl")

	   public EmployeeRepositoryImpl employeeRepositoryImpl() {

	      return new EmployeeRepositoryImpl();

	   }

	//   

	   @Bean(name = "EmployeeServiceImpl")

	   public EmployeeServiceImpl employeeServiceImpl() {

	      return new EmployeeServiceImpl(employeeRepositoryImpl());

	   }
}
