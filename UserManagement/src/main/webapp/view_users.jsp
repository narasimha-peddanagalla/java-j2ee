<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="com.userapp.model.User" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>

	<style>
		body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #f3f3f3;
        }
        a.button {
            padding: 5px 10px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        a.button:hover {
            background-color: #0056b3;
        }
	
	</style>

</head>
<body>

	<h2>User List</h2>
	
	<%
		List<User> userList = (List<User>) request.getAttribute("userList");
		
		if(userList == null || userList.isEmpty()){
			
		
	%>
		<p>No Users Found</p>
		
	<%
	  }
		else{
	
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Action</th>
		
		</tr>
		
		<%
		
			for(User user : userList){
		
		%>
		<tr>
			<td><%=user.getId() %></td>
			<td><%=user.getName() %></td>
			<td><%=user.getEmail() %></td>
			<td><%=user.getContact() %></td>
			
			<td>
				<a href="editUser?id=<%=user.getId() %>" class="button">Edit</a>
				<a href="deleteUser?id=<%=user.getId()%>" class="button" style="background-color:#dc3545;">Delete</a>
			</td>
		</tr>
		<% 
			}
		%>

	</table>
		<%
	  		}		
		%>
</body>
</html>