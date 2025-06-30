<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.userapp.model.User" %>

<%
    User user = (User) request.getAttribute("user");
    if (user == null) {
%>
    <div class="alert alert-danger text-center mt-5">User not found to edit.</div>
<%
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="mx-auto p-4 border rounded bg-white shadow-sm" style="max-width: 400px;">
        <h4 class="mb-3 text-center">Edit User</h4>

        <form action="updateUser" method="post">
            <input type="hidden" name="id" value="<%= user.getId() %>">

            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" class="form-control form-control-sm" value="<%= user.getName() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control form-control-sm" value="<%= user.getEmail() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Contact</label>
                <input type="text" name="contact" class="form-control form-control-sm" value="<%= user.getContact() %>" required>
            </div>

            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-success btn-sm">Update</button>
                <a href="viewUsers" class="btn btn-secondary btn-sm">Cancel</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
