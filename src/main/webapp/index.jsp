<html>
<body>
<%
if (request.getAttribute("error") != null) {
	
out.println("Wrong input. Try again or register");
}
%>
<h3> Login here </h3>
<form action="login" method="post">
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
                 <input type="submit" value="Login" />
                
</form>
 <button onclick="location.href = 'RegPage.jsp';" id="myButton" class="float-left submit-button" >New User</button>
</body>
</html>
