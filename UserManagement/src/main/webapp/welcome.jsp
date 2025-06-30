<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h2 style="color:green"><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %></h2>
	<h2>Welcome User</h2>
	

</body>
</html>