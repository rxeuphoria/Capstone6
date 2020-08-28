<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add task</title>
</head>
<body>
	<%@include file="partials/header.jsp" %>
<table class="table">
			<tr>
				<th>description</th>
				<th>date</th>
				<th>complete</th>
				<th></th>
			</tr>

			<c:forEach var="task" items="${user.tasks}">

				<tr>
					<td>${task.description}</td>
					<td>${task.date}</td>
					<td>${task.complete}</td>
				</tr>

			</c:forEach>
		</table>
</body>
</html>