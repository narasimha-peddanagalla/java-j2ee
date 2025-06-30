package com.userapp.controller;

import java.io.IOException;

import com.userapp.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteUserServlet extends HttpServlet {
	private UserDAO userDao;

	@Override
	public void init() {
		userDao = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get ID from query string
		int id = Integer.parseInt(request.getParameter("id"));

		// Call DAO to delete user
		boolean deleted = userDao.deleteUser(id);

		// Redirect back to the user list page
		if (deleted) {
			response.sendRedirect("viewUsers");
		} else {
			response.getWriter().println("User deletion failed!");
		}
	}

}
