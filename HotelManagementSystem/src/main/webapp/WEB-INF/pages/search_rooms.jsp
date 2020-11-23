<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Room Page</title>
<link href="<c:url value='/resources/css/jquery-ui.css'/>"
	rel="stylesheet">
<script href="<c:url value='/resources/css/jquery-ui.js'/>"></script>
<script href="<c:url value='/resources/css/jquery.js'/>"></script>
<script>
	$(function() {
		$("input[name=checkIn]").datepicker({
			format : 'yyyy-mm-dd'
		});
	});
	$(function() {
		$("input[name=checkOut]").datepicker({
			format : 'yyyy-mm-dd'
		});
	});
</script>
</head>
<body>
	<h1 style="color: aqua; text-align: center;">Search Room By
		Supplying Below Details</h1>
	<f:form modelAttribute="serRoomCmd">
		<table align="center">
			<tr>
				<td>Select Room Type::</td>
				<td><f:select path="roomType">
						<f:option value="NONE" label="--- Select ---" />
						<f:options items="${roomTypes}" />
					</f:select></td>
			</tr>
			<tr>
				<td>Check In Date::</td>
				<td><f:input path="checkIn" /></td>
				<td>(yyyy-mm-dd)</td>
			</tr>
			<tr>
				<td>Check Out Date::</td>
				<td><f:input path="checkOut" /></td>
				<td>(yyyy-mm-dd)</td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</f:form>
</body>
</html>