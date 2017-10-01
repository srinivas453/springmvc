package org.mainlogic.springmvc.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ExtendedSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	public ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		
		System.out.println("In extended exception resolver");
		return super.doResolveException(request, response, handler, ex);
		
	}
	
	@Override
	public void logException(Exception ex, HttpServletRequest request) {

		System.out.println("In extended exception resolver: " + ex.getMessage());
	}
}