package org.mainlogic.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mainlogic.springmvc.dto.Address;
import org.mainlogic.springmvc.dto.Employee;
import org.mainlogic.springmvc.error.ErrorResponse;
import org.mainlogic.springmvc.format.CustomDateFormatter;
import org.mainlogic.springmvc.format.CustomDatePropertyEditor;
import org.mainlogic.springmvc.service.EmployeeService;
import org.mainlogic.springmvc.validate.CustomDateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
@SessionAttributes("employee")
public class HelloWorldController {
	
	@Autowired
	private EmployeeService service;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
/*        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);*/
        //binder.registerCustomEditor(Date.class, "joinDate", new CustomDatePropertyEditor());
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
        binder.addCustomFormatter(new CustomDateFormatter());
        binder.addValidators(new CustomDateValidator());
    }
    
	@ModelAttribute
	public void getEmployee(HttpServletRequest request) {
		
		request.setAttribute("employee", new Employee());
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public ModelAndView sayHello() {
		
		System.out.println("Hello from controller " + service.getEmployee().getName());
		
		ModelAndView mv = new ModelAndView("hello", "message", "Hello !!! " + service.getEmployee().getName());
		
		//model.addAttribute("message", "Hello !!! " + service.getEmployee().getName());
		//return "hello";
		
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employee/add", params="!id", headers="Accept=text/xml")
	public String sayHelloAgain(@Valid @ModelAttribute Employee employee, BindingResult result, @RequestHeader("Referer") String referer, @CookieValue("JSESSIONID") String cookieValue ) {
		
		System.out.println("Parameter value: " + employee.getName());
		return "employee";
	}
	
	@GetMapping(value="/employee")
	public ModelAndView gotoEmployee() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new Employee());
		//mv.addObject("address", new Address());
		
		mv.setViewName("employee");
		
		return mv;
	}
	
	@GetMapping(value="/employee/session")
	public void gotoEmployee(@RequestAttribute Employee employee) {
		
		return;
	}
	
	@GetMapping(value="/employee/{id}/{age}")
	@ResponseBody
	public void getEmployee(@PathVariable("id") String empId, @MatrixVariable(pathVar="id") String name, @MatrixVariable(pathVar="age", name="name") String age) {
		
		System.out.println("Employeen ID: " + empId + ", Name: " + name);
		return;
	}
	
	@GetMapping(value="/employee/{id}")
	@ResponseBody
	public void getEmployee(@PathVariable("id") int empId) throws Exception {
		
		if(empId == 1)
			throw new Exception("Invalid ID: " + empId);
		
		System.out.println("Employeen ID: " + empId);
		return;
	}
	
/*	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception exception) {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", exception);
		mv.addObject("url", request.getRequestURL());
		
		return mv;
	}*/
}