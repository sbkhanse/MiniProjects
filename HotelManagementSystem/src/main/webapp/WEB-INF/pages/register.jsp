<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Details</title>
<script type="text/javascript">
	function validate(frm){
		alert("123");
		//Erase old error messages
		document.getElementById("gstNameErr").innerHTML="";
		document.getElementById("emailErr").innerHTML="";
		document.getElementById("mobileErr").innerHTML="";
		document.getElementById("usernameErr").innerHTML="";
		document.getElementById("passwordErr").innerHTML="";
		document.getElementById("confirmPasswordErr").innerHTML="";

		alert("Java Script");

		//Reading from Data
		let name=frm.gstName.value;
		let mob=frm.mobile.value;
		let email=frm.email.value;
		let username=frm.username.value;
		let pass=frm.password.value;
		let cfmPass=frm.confirmPassword.value;
		let status=false;
	
		alert("Data");
		
		if(name=="") {
			document.getElementById("gstNameErr").innerHTML="Farmer Name is mandatory";
			status = true;
		}
		if(mob=="") {
			document.getElementById("mobileErr").innerHTML="Guest Mobile No is mandatory";
			status = true;
		} 
		else if(isNaN(mob)) {
			document.getElementById("mobileErr").innerHTML="Guest Mobile No should be integer value";
			status = true;
		} 
		else if(mob.length<10 || mob.length>10) {
			document.getElementById("mobileErr").innerHTML="Guest Mobile No should be 10 digit";
			status = true;
		}
		if(email=="") {
			document.getElementById("emailErr").innerHTML="Guest Email is mandatory";
			status = true;
		}
		if(username=="") {
			document.getElementById("usernameErr").innerHTML="Guest Username is mandatory";
			status = true;
		}
		if(pass=="") {
			document.getElementById("passwordErr").innerHTML="Guest Password is mandatory";
			status = true;
		}
		if(cfmPass=="") {
			document.getElementById("confirmPasswordErr").innerHTML="Guest Confirm Password is mandatory";
			status = true;
		}
		if(pass!=cfmPass) {
			document.getElementById("confirmPasswordErr").innerHTML="Password and Confirm Password shoul be same";
			status = true;
		}
		//change vflag value to yes
		frm.vflag.value="yes";

		if(status)
			return false;
		else
			return true;
	}
</script>
</head>
<body>
	<h1 style="color: red;text-align: center;">Guest Registration Form</h1>
	<h3 style="color: red;text-align: center;"> ${regMsg}</h3>
	
	<f:form modelAttribute="gstCmd" onsubmit="return validate(this)">
		<table align="center">
			<tr>
				<td>Full Name::</td>
				<td><f:input path="gstName" /><f:errors path="gstName"/><span id="gstNameErr"></span></td>
			</tr>
			<tr>
				<td>E-mail::</td>
				<td><f:input path="email" /><f:errors path="email"/><span id="emailErr"></span></td>
			</tr>
			<tr>
				<td>Mobile No::</td>
				<td><f:input path="mobile" /><f:errors path="mobile"/><span id="mobileErr"></span></td>
			</tr>
			<tr>
				<td>User Name::</td>
				<td><f:input path="username" /><f:errors path="username"/><span id="usernameErr"></span></td>
			</tr>
			<tr>
				<td>Password::</td>
				<td><f:input path="password" /><f:errors path="password"/><span id="passwordErr"></span></td>
			</tr>
			<tr>
				<td>Confirm Password::</td>
				<td><f:input path="confirmPassword" /><f:errors path="confirmPassword"/><span id="conFirmPasswordErr"></span></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
				<td><input type="reset" value="Reset"></td>
				<td><f:hidden path="vflag"/></td>
			</tr>
		</table>
	</f:form>
	<h3 style="color: maroon;text-align: center;"><a href="welcome">Go To Home</h3>
</body>
</html>