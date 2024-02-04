<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="5px solid black">
<tr>
<th>ID</th>
<th>NAME</th>
<th>AGE</th>
<th>EMAIL</th>
<th>PASSWORD</th>
<th>ADDRESS</th>
<th>PHONE</th>
<th>GENDER</th>
<th>EDIT</th>
<th>DELETE</th>

</tr>
<c:forEach var="students" items="${student}" >
<tr>
<td>${students.getId()}</td>
<td>${students.getName()}</td>
<td>${students.getAge()}</td>
<td>${students.getEmail()}</td>
<td>${students.getPassword()}</td>
<td>${students.getAddress()}</td>
<td>${students.getPhone()}</td>
<td>${students.getGender()}</td>
<td ><a href="edituser.jsp?id=${ students.getId()}">Edit</a></td>
<td ><a href="deleteuser?id=students.getId()">Delete</a></td>


</tr>
</c:forEach>


</table>

</body>
</html>