<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Avaliable Rooms</title>
</head>
<body>
	<h1 style="color: maroon; text-align: center;">Rooms Avaliable In Hotel</h1>
	<c:choose>
			<c:when test="${!empty roomDTO}">
						<table align="center" border="1">
							<tr>
								<th>Sr.No</th>
								<th>Room ID</th>
								<th>Room Type </th>
								<th>Room Status</th>
								<th>Operation</th>
							</tr>
							<c:forEach var="dto" items="${roomDTO}"> 
								<tr>
									<td>${dto.serNo}</td>
									<td>${dto.roomId}</td>
									<td>${dto.roomType}</td>
									<td>${dto.status}</td>
									<td><a href="book?rNo=${dto.roomId}&type=${dto.roomType}">Book</a></td>
								</tr>
							</c:forEach>
						</table>
			</c:when>
		<c:otherwise >
			<h1 style="color: red;text-align: center;">Hotels Data Not Found....!</h1>
		</c:otherwise>
	</c:choose>
	<h2><a href="search_rooms">Go Back To Profile</a></h2>
</body>
</html>