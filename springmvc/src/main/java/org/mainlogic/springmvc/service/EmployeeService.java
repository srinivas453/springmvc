package org.mainlogic.springmvc.service;

import org.mainlogic.springmvc.dto.Employee;
import org.springframework.stereotype.Service;

@Service("EmployeeService")
public class EmployeeService {

	public Employee getEmployee() {
		
		Employee employee = new Employee("Spring User");	
		return employee;
	}
}
