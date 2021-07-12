package com.infy.test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

import com.infy.controller.EmployeeController;
import com.infy.domain.Employee;
import com.infy.dto.EmployeeDTO;
import com.infy.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private EmployeeService service;
	
	private EmployeeDTO employeeDTO = null;
	
	private List<EmployeeDTO> empList = null;
	
	@Before
	public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
	
	@Before
	public void initializeEmployee() {
		
		employeeDTO=new EmployeeDTO();
		employeeDTO.setEmpId(7);
		employeeDTO.setEmpName("Aswanth");
		employeeDTO.setDepartment("geoscience");
		employeeDTO.setBaseLocation("Earth");
		employeeDTO.setAddress("Earth");
		empList=new ArrayList<>();
		empList.add(employeeDTO);
		
	}
	
	@WithMockUser("/root")
	@Test
	public void getEmployeeTest() throws Exception {
		Mockito.when(service.fetchEmployee()).thenReturn(empList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		ObjectMapper mapper = new ObjectMapper();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		mapper.writeValue(out, empList);
		byte[] data = out.toByteArray();
		
		Assert.assertEquals(new String(data), response.getContentAsString());
	}
}

