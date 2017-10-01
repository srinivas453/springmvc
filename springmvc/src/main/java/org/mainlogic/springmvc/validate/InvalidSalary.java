package org.mainlogic.springmvc.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy={InvalidSalaryValidator.class})
@Target({java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InvalidSalary {

	  String message() default "Invalid salary";
	  
	  int value() default 1000;
	  
	  Class<?>[] groups() default {};
	  
	  Class<? extends Payload>[] payload() default {};
}
