package com.infyTel;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.infyTel.dto.CustomerDTO;
import com.infyTel.service.CustomerService;
@SpringBootApplication
public class Client implements CommandLineRunner{
    static Logger logger = Logger.getLogger(Client.class);
	@Autowired
	ApplicationContext context;
	@Autowired
	CustomerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1);
		CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2);
		CustomerDTO customer3= new CustomerDTO(7022713722L, "Lucy", 27, 'F', "MUMBAI", 3);
		
		//invoke service layer method to insert Customer
		service.insertCustomer(customer1);
		service.insertCustomer(customer2);
		service.insertCustomer(customer3);
		logger.info("Records are successfully added..");
		
		System.out.println("Enter the phone Number of the Customer which has to be deleted.");
		Scanner scanner = new Scanner(System.in);
		Long phoneNo = scanner.nextLong();
		// Invoking Service layer method to remove Customer details from
		// Customer table
		service.removeCustomer(phoneNo);
		logger.info("Record Deleted");
		
		logger.info("Let's print the details of a Customer");
		System.out.println("Enter the phone Number of the Customer whose details have to be printed.");
		Long phoneNo1 = scanner.nextLong();
		CustomerDTO customerDTO = service.getCustomer(phoneNo1);
		logger.info("Customer Details:");
		logger.info("Phone Number : "+customerDTO.getPhoneNumber());
		logger.info("Name         : "+customerDTO.getName());
		logger.info("Age          : "+customerDTO.getAge());
		logger.info("Gender       : "+customerDTO.getAge());
		logger.info("Address      : "+customerDTO.getAddress());
		logger.info("Plan ID      : "+customerDTO.getPlanId());
		
		logger.info("Let's update the current plan of a Customer");
		System.out.println("Enter the phone Number of the Customer whose current plan has to be updated.");
		Long phoneNo2 = scanner.nextLong();
		System.out.println("Enter the new plan id for the Customer");
		Integer newPlanId = scanner.nextInt();
		String msg = service.updateCustomer(phoneNo2, newPlanId);
		logger.info(msg);
		scanner.close();
		
}
		
	}
