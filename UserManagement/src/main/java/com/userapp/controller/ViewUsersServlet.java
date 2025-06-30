package com.userapp.controller;

import java.io.IOException;
import java.util.List;

import com.userapp.dao.UserDAO;
import com.userapp.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewUsersServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao;
	
	
	public void init() {
		userDao = new UserDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> userList = userDao.getUsers();
		req.setAttribute("userList", userList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("view_users.jsp");
		dispatcher.forward(req,resp);
	}
}
