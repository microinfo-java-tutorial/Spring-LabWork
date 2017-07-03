<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<style>
table, tr, td{
border:1px solid #000;
}
td{
text-align:center;
}
</style>
</head>
<body>

	<h1><c:out value="${welcomeMessage}" /></h1>
	
	<table style="width: 100%">
	
	<tr>
			<th>Title</th>
			<th>Artist</th>
			<th>Music Category</th>
			<th>ReleaseDate</th>
			<th>Price</th>
	</tr>
	
	<c:forEach var="musicItem" items="${musicItemList}">
			<tr>
				<td><c:out value="${musicItem.title}"/></td>
				<td><c:out value="${musicItem.artist}"/></td>
				<td><c:out value="${musicItem.musicCategory}"/></td>
				<td><c:out value="${musicItem.releaseDate}"/></td>
				<td><c:out value="${musicItem.price}"/></td>
			</tr>
	</c:forEach>
	
	</table>
		
</body>
</html>