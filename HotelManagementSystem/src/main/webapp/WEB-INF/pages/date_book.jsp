<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date Booking</title>
</head>
<body>
	<h1 style="color: lime; text-align: center;">Book Dates</h1>
	<h3 style="color: red;text-align: center;"> ${resMsg } </h3>
	<f:form modelAttribute="bkCmd">
			<table align="center">
				<tr>
					<td>Choosen Room ID</td>
					<td> <input type="text" name="rNo" value="${rNo }" readonly="readonly"/> </td>
				</tr>
				<tr>
					<td>Choosen Room Type</td>
					<td> <input type="text" name="type" value="${type }" readonly="readonly"/> </td>
				</tr>
				<tr>
					<td>Enter Start Date</td>
					<td><f:input path="startDate"/> </td>
					<td>(yyyy-mm-dd)</td>
				</tr>
				<tr>
					<td>Enter End Date</td>
					<td><f:input path="endDate" /> </td>
					<td>(yyyy-mm-dd)</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Book Room"></td>
				</tr>
			</table>
	</f:form>
</body>
</html>