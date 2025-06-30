package com.userapp.controller;

import java.io.IOException;

import com.userapp.dao.UserDAO;
import com.userapp.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditUserServlet extends HttpServlet {
	private UserDAO userDao;
	
	@Override
	public void init(){  //called by the JEE Container only 1 time
		userDao = new UserDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		//Get the ID from the URL query parameter
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Fetch the User from DB
		User existingUser = userDao.getUserById(id);
		
		//Set User as Request Attribute
		request.setAttribute("user", existingUser);
		
		// ❗ Forward the request to edit_user.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit_user.jsp");
        dispatcher.forward(request, response);
	}
}
