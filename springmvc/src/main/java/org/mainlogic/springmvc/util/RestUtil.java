package org.mainlogic.springmvc.util;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.mainlogic.springmvc.dto.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class RestUtil {
	
	private static final String URL = "http://localhost:8080/springmvc/emp/employee";
	private static final String URL_1 = URL + "/{id}";

	public static void main(String[] args) {
		
		RestTemplate rt = new RestTemplate();		
		
		Map<String, String> map = new HashMap<>();
		map.put("id", "10");
		map.put("id", "20");
		
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(URL_1).build();
		URI uri = uriComponents.expand("42").encode().toUri();
		
		Employee employee = rt.getForObject(uri.toString(), Employee.class, "10");		
		
		Employee emp = new Employee("TestHttp");
		emp.setAge(25);
		emp.setSalary("10000");
		
		//HttpHeaders header = new HttpHeaders();
		//header.add("Accept", MediaType.APPLICATION_XML_VALUE);
		
		HttpEntity<Employee> empEntity = new HttpEntity<Employee>(emp);
		
		ResponseEntity<Employee> emplyee = rt.exchange(URL, HttpMethod.PUT, empEntity, Employee.class);
		
		System.out.println(emplyee.getBody().getName());
	}
}
