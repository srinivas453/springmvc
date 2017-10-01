package org.mainlogic.springmvc.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.mainlogic.springmvc.validate.InvalidSalary;

@XmlRootElement
public class Employee {

	private String name;

	@Min(value = 20)
	private int age;

	@InvalidSalary(value = 20000, message = "Salary must not be empty")
	private String salary;

	private Date joinDate;

	public Employee() {
		super();
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	@XmlElement
	public void setSalary(String salary) {
		this.salary = salary;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
