<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

if (session.getAttribute("username") ==null) {
	
response.sendRedirect("index.jsp");
} response.sendRedirect("todoList.jsp");
%>
<h1>HI ${u.getUserName()} <br>
Now you're ready for planning your life
</h1>

<form action="LogOut">
<input type = "submit" value = "LogOut">
</form>
</body>
</html>