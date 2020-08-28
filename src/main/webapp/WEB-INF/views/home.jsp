<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<body>
	<%@include file="partials/header.jsp" %>
	<h1>Welcome</h1>
	
	<p class="message">${ message }</p>
	
	<p>Krabby Patty Secret Formula Safe</p>
	
	<c:if test="${ not empty user }">
		<p>Got something to do? Add a <a href="/addTask">task</a>.</p>
	</c:if>
</body>
</body>
</html>