package org.mainlogic.springmvc.validate;

import org.mainlogic.springmvc.dto.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomDateValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		System.out.println(clazz);
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "joinDate", "date.error", "Invalid date");
		
		System.out.println(target);
	}

}
