package org.mainlogic.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.mainlogic.springmvc.dto.Employee;
import org.mainlogic.springmvc.error.ErrorResponse;
import org.mainlogic.springmvc.error.JsonException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@GetMapping(value="/employee/{id}", produces= {MediaType.APPLICATION_XML_VALUE})
	public Employee getEmployee(@PathVariable("id") int empId) throws Exception {

		/*if(empId == 1)
			throw new JsonException("Invalid ID: " + empId);*/
		
		Employee employee = new Employee();
		employee.setName("Test");
		employee.setAge(30);
		employee.setSalary("10000");

		return employee;
	}
	
	@PutMapping(value="/employee")
	public ResponseEntity<Employee> updateEmployee(HttpEntity<Employee> employee) {

		ResponseEntity<Employee> response = new ResponseEntity<>(employee.getBody(), HttpStatus.ACCEPTED);
		return response;
	}
	
/*	@ExceptionHandler(Exception.class)
	public ErrorResponse jsonHandleException(HttpServletRequest request, Exception exception) {
		
		ErrorResponse response = new ErrorResponse();
		response.setErrorMessage(exception.getMessage());
		response.setUrl(request.getRequestURL().toString());
		
		return response;
	}*/
}