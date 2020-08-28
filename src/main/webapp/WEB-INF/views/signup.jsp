<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="partials/header.jsp" %>
	<h1>Sign up</h1>
	
	<p class="message">${ message }</p>
	
	<form action="signup" method="post">
		<p>
			<label for="name">Your Name:</label> <input id="name" name="name" value="${ param.name }" required minlength="2" autocomplete="off"/>
		</p>
		<p>
			<label for="username">Username:</label> <input id="username" name="username" value="${ param.username }" required minlength="2" />
		</p>
		<p>
			<label for="password">Password:</label> <input id="password" type="password" name="password" required minlength="2" />
		</p>
		<p>
			<label for="password2">Confirm Password:</label> <input id="password2" type="password" name="confirm-password" required minlength="2" />
		</p>
		<p>
			<button>Sign me Up!</button>
		</p>
	</form>

</body>
</html>