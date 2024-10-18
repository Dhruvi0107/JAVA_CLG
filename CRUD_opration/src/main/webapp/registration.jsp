<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registration Page</title>
	</head>
	<body align="center">
		<h3>Registration Form</h3>
		<form action="registration" method="post">
			Username : <input type="text" name="uname" placeholder="Enter Your Username.."><br><br>
			Password : <input type="password" name="upwd" placeholder="Enter Your Password.."><br><br>
			Firstname : <input type="text" name="fname" placeholder="Entet Your Firstname.."><br><br>
			Lastname : <input type="text" name="lname" placeholder="Enter Your Lastname.."><br><br>
			Age : <input type="text" name="age" placeholder="Enter Your Age.."><br><br>
			EmailID : <input type="text" name="eid" placeholder="Enter Your Email ID.."><br><br>
			Contact No : <input type="text" name="cno" placeholder="Enter Your Contact No.."><br><br>
			
			<input type="submit" value="REGISTER">
			
 		</form>
	</body>
</html>