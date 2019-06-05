<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>
<form action="SignUp.ams" method="post">

FirstName:<input type="text" name="fName"><br><br>
LastName:<input type="text" name="lName"><br><br>
CountryCode:<select name="cCode">
	<option>+91</option>
	<option>+61</option>
	<option>+1</option>
	</select> MobileNumber:<input type="number" name="mobileNo">
<br><br>
EmailId:<input type="text" name="email"><br><br>

<br><br>
<input type="submit" value="SignUp"> <input type="reset" value="Reset">


</form>

</body>
</html>