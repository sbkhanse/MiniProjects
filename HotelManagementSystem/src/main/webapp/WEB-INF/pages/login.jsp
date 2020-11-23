<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/CSSFile.css" rel="stylesheet" type="text/css" media="all">
<title>Login Form Design</title>
</head>
<body>
	<h1 style="color: olive;text-align: center;">Login Form</h1>
	<h3 style="color: red;text-align: center;"> ${logMsg } </h3>	
	<f:form modelAttribute="logGstCmd">
		<table align="center">
			<tr>
				<td>User Name::</td>
				<td><f:input path="username" /></td>
			</tr>
			<tr>
				<td>Password::</td>
				<td><f:input path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>
	</f:form>
			<a href="#">Lost Your Password?</a>
			<br>
			<a href="register">Don't have an Account?</a>
			
</body>
</html>