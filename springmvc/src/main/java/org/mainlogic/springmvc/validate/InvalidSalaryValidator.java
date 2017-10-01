package org.mainlogic.springmvc.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InvalidSalaryValidator implements ConstraintValidator<InvalidSalary, String>{
	
	private InvalidSalary annotation;

	@Override
	public void initialize(InvalidSalary constraintAnnotation) {
		
		this.annotation = constraintAnnotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		int salary = annotation.value();

		return (value != null && !value.isEmpty() && salary <= Integer.parseInt(value));
	}
}
