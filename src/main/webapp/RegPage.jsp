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

if (request.getAttribute("error") != null) {
	
out.println("Wrong input. Try again");
}
%>
<h3> Register here </h3>
<form action="reg" method="post">
<table style="width: 20%">
                 <tr>
                 <td>UserName</td>
                                    <td><input type="text" name="username" /></td>
                         </tr>
                                    <tr>
                                    <td>Password</td>
                                    <td><input type="password" name="password" /></td>
                           </tr>
                 </table>
                 <input type="submit" value="Submit" />
</form>
</body>
</html>