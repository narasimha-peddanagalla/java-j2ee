<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<style>
body {
	font-family: Arial;
	margin: 50 px;
	background-color: #f2f2f2;
}

.container {
	background: white;
	padding: 50px;
	width: 350px;
	margin: auto;
	box-shadow: 0 0 10px gray;
}

input[type="text"], input[type="email"], input[type="password"] {
	width: 100%;
	padding: 8px;
	margin: 8px 0;
}

button {
	width: 100%;
	padding: 10px;
	background: green;
	color: white;
	border: none;
}
</style>


</head>
<body>
	<div class="container">
		<h2>Login Here</h2>
		<form action="login" method="post">

			<label>Email</label> <input type="email" name="email" required /> <label>Password</label>
			<input type="password" name="password" required />

			<button type="submit">Login</button>

		</form>

		<p>
			Don't have an Account? <a href="register.jsp">Register Here</a>
		</p>

		<%
		String msg = (String) request.getAttribute("message");
		String msgType = (String) request.getAttribute("msgType");
		if (msg != null) {
			String color = "green";
			if ("error".equals(msgType)) {
				color = "red";
			}
		%>
		<p style="color:<%=color%>;"><%=msg%></p>
		<%
		}
		%>

	</div>

</body>
</html>