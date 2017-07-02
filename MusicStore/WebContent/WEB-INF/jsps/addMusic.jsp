<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome to MusicStore!!!  and we are in Add Musci JSP page</h1>
		
	<spring:url value="/welcome/submitMusicForm" var="userActionUrl" />
	
	<form:form action="${userActionUrl}" modelAttribute="musicItem" method="post">
		
		<spring:bind path="title">
			<label class="col-sm-2 control-label">Title</label>
			<form:input path="title" id="title" placeholder="Enter Album Title here" />
			<form:errors path="title" />
		</spring:bind>
		<br>
		<spring:bind path="artist">
			<label class="col-sm-2 control-label">Artist</label>
			<form:input path="artist" id="artist" placeholder="" />
			<form:errors path="artist" />
		</spring:bind>
		
		<br>

		<spring:bind path="releaseDate">
			<label class="col-sm-2 control-label">Release Date</label>
			<fmt:formatDate value="${releaseDate}" var="releaseDateField" pattern="mm/DD/yyyy" />
			<form:input path="releaseDate" value="${releaseDateField}" id="releaseDate" placeholder="${releaseDateField}" />
			<form:errors path="releaseDate" />
		</spring:bind>
		
		<br>
		
		<spring:bind path="price">
			<label class="col-sm-2 control-label">Price</label>
			<form:input path="price" id="price" placeholder="0.00" />
			<form:errors path="price" />
		</spring:bind>
		
		<br>
		
		<spring:bind path="musicCategory">
			<label class="col-sm-2 control-label">Music Category</label>
				<form:select path="musicCategory" >
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${musicCategory}" />
				</form:select>
				<form:errors path="musicCategory" />
		</spring:bind>
		
		<br>
		
		<form:button name="submit" value="Submit">Submit</form:button>
		
	</form:form>
	
	
</body>
</html>