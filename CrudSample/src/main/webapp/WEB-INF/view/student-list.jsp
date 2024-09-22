<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align = "center" style = "color : green;">Selenium Express</h1>
	<h1 align = "center" style = "color : red;">Student management</h1>
	<div align = "center">
	
		<form action = "showAddStudentPage">
		 
		  <input type = "submit" value = "ADD">
		
		</form>
		
		<table border = "1">
		  <thead>
		  	<tr>
		      <td>id</td>
		  	  <td>name</td>
		  	  <td>mobile</td>
		  	  <td>country</td>
		  	</tr>
		  </thead>
		  
	      
	      <c:forEach var = "student" items = "${students}">	  
		    <tr>
			  <td>${student.id}</td>
			  <td>${student.name}	</td>
	          <td>${student.mobile}</td>
			  <td>${student.country}</td>
			  <td><a href = "/CrudSample/updateStudent?userId=${student.id}">Update</a> </td>
			   <td><a href = "/CrudSample/deleteStudent?userId=${student.id}" onclick = "if(!confirm('Are you sure to delete this student?')) return false">Delete</a> </td>
	        </tr>	
	      </c:forEach>
	
		</table>
	</div>
</body>
</html> 