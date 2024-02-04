<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="savestudent" modelAttribute="stud" method="post">

NAME:<form:input path="name"/><br>
AGE:<form:input path="age"/><br>
EMAIL:<form:input path="email"/><br>
PASSWORD:<form:input path="password"/><br>
ADDRESS:<form:input path="address"/><br>
PHONE:<form:input path="phone"/><br>
GENDER:<form:input path="gender"/><br>
<form:button>Register</form:button>



</form:form>

</body>
</html>