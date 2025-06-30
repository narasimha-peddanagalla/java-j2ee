package com.userapp.controller;
import java.io.IOException;
import com.userapp.dao.UserDAO;
import com.userapp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");
		String password = req.getParameter("password");
		
		//Create User Object
		User user = new User(name,email,contact,password);
		
		//Insert into DB
		UserDAO dao = new UserDAO();
		 boolean isSuccess = dao.addUser(user);
		 
		 if(isSuccess) {
			 req.setAttribute("message", "User Registered Successfully, Please Login.");
			 //redirects to the login.jsp
			 req.setAttribute("msgType", "success");
			 req.getRequestDispatcher("login.jsp").forward(req, resp);;
		 }
		 else {
			 req.setAttribute("message", "Registration Failed, Try Again.");
			 req.setAttribute("msgType", "error");
			 req.getRequestDispatcher("register.jsp").forward(req, resp);
		 }		
	}

}
