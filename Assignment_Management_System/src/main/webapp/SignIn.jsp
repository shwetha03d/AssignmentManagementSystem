<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
</head>
<body align="center" bgcolor="cyan">
<h1>SignIn</h1>
<form action="LogIn.ams" method="post">
Email Id:<input type="text" name="email"><br><br>
Password:<input type="text" name="password"><br><br>
<br><br>
<input type="submit" value="LogIn">   <input type="reset" value="Reset">

</form>
<h3>${msg}</h3>



</body>
</html>