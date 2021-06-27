package com.example.employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.employee.DTO.EmployeeDTO;
import com.example.employee.entity.SpringConfiguration;
import com.example.employee.repository.EmployeeRepositoryImpl;
import com.example.employee.service.EmployeeServiceImpl;


public class Client {

	   public static void main(String[] args) {

	      //System.out.println("Hello World!");



	      AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);



	      EmployeeRepositoryImpl employeeRepositoryImpl = (EmployeeRepositoryImpl) context.getBean("EmployeeRepositoryImpl");

	      EmployeeServiceImpl employeeServiceImpl = (EmployeeServiceImpl) context.getBean(EmployeeServiceImpl.class);



	      //System.out.println(employeeServiceImpl.getAllCustomer());

	      employeeServiceImpl.insert(new EmployeeDTO(1, "Aswanth", "Trainee"));

	      employeeServiceImpl.insert(new EmployeeDTO(2, "Teja", "Trainee"));

	      System.out.println(employeeServiceImpl.getAllCustomer());



	      employeeServiceImpl.delete(1);

	      System.out.println(employeeServiceImpl.getAllCustomer());

	   }

	}

