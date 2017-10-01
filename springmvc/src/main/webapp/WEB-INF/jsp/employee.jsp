<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="employee" action="/springmvc/hello/employee/add" method="post">

<form:errors cssStyle="color:red" element="error">

</form:errors>

	<label>Employee Name</label>
	<form:input path="name" name="name"/> 
	<form:errors cssStyle="color:red" path="name"></form:errors>
	<br/>
	<label>Employee Age</label>
	<form:input path="age" name="age"/> 
	<form:errors cssStyle="color:red" path="age"></form:errors>
	<br/>
	<label>Employee Salary</label>
	<form:input path="salary" name="salary"/> 
	<form:errors cssStyle="color:red" path="salary"></form:errors>
	<br/>
	<label>Joining Date</label>
	<form:input path="joinDate" name="joinDate"/> 
	<form:errors cssStyle="color:red" path="joinDate"></form:errors>
<%-- 	<br/>
	<label>Addess</label>
	<form:input path="address" name="address"/> 
	<form:errors cssStyle="color:red" path="address"></form:errors>
	<br/>
	<label>City</label>
	<form:input path="city" name="city"/> 
	<form:errors cssStyle="color:red" path="city"></form:errors>
	<br/>
	<label>State</label>
	<form:input path="state" name="state"/> 
	<form:errors cssStyle="color:red" path="state"></form:errors> --%>
	
	<input type="submit">
</form:form>
</body>
</html>