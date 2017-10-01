package org.mainlogic.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.mainlogic.springmvc.error.ErrorResponse;
import org.mainlogic.springmvc.error.JsonException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes=EmployeeController.class)
public class GlobalRestInterceptor {

	//@ExceptionHandler(JsonException.class)
	public ErrorResponse jsonHandleException(HttpServletRequest request, Exception exception) {
		
		ErrorResponse response = new ErrorResponse();
		response.setErrorMessage(exception.getMessage());
		response.setUrl(request.getRequestURL().toString());
		
		return response;
	}
}
