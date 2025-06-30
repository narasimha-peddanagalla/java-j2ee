package com.userapp.controller;
import java.io.IOException;

import com.userapp.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDAO dao = new UserDAO();
		
		boolean isValid =  dao.validateUser(email, password);
		
		if(isValid) {
			//Login Success : forward to Welcome Page
			req.setAttribute("message", "Login Successful !!!");
			req.setAttribute("msgType", "success");
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
		}
		else {
			//Login Failed
			req.setAttribute("message","Login Failed, Invalid Credentials !!!");
			req.setAttribute("msgType", "error");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
