<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Result</title>
</head>
<body>
	<h1 style="color: fuchsia; text-align: center;">Room Booking Details</h1>
	<table align="center" border="0">
		<tr>
			<td>Room ID::</td>
			<td>${roomNo }</td>
		</tr>
		<tr>
			<td>Room ID::</td>
			<td>${roomType }</td>
		</tr>
		<tr>
			<td>Booking Start Date::</td>
			<td>${startDate }</td>
		</tr>
		<tr>
			<td>Booking End Date::</td>
			<td>${endDate }</td>
		</tr>
	</table>
	<h3 style="color: navy; text-align: center;"><a href="welcome">Go To Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#">Print Report</a></h3>
</body>
</html>