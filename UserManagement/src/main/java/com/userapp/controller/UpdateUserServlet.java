package com.userapp.controller;

import java.io.IOException;

import com.userapp.dao.UserDAO;
import com.userapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateUserServlet extends HttpServlet{
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = new UserDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		
		//Read from data
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		
		//Create User Object with updated values
		User updatedUser = new User(id,name,email,password,contact);
		
		//Call DAO to Update User in DB
		boolean isUpdated = userDao.updateUser(updatedUser);
		
		//Redirect
		if(isUpdated) {
			response.sendRedirect("viewUsers");
		}
		else {
			response.getWriter().println("Update Failed !!!");
		}
	}
}
