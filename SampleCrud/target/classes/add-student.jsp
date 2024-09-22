<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<h3>Add Student</h3>
		<!--  create a html form where the user can enter data -->
		
		<form:form action = "save-student" modelAttribute ="student" method ="POST">
		
		  <form:hidden path = "id"/>
		  <label>Name : </label>
		  <form:input path="name"/>
		  <br/>
		  
		  <label>Mobile : </label>
		  <form:input path="mobile"/>
		  <br/>
		  
		  <label>Country : </label>
		  <form:input path="country"/>
		  <br/>
		  
		  <input type = "submit" value = "Submit">
		  
		</form:form>
	</div>
</body>
</html>