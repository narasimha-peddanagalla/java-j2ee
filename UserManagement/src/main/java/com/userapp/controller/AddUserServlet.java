package com.userapp.controller;
import java.io.IOException;
import java.io.PrintWriter;

import com.userapp.dao.UserDAO;
import com.userapp.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Set response content type
        resp.setContentType("text/plain");

        // 1. Get form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String password = req.getParameter("password"); 

        // 2. Create user object
        User user = new User(name, email, contact, password); // match constructor

        // 3. Call DAO
        UserDAO dao = new UserDAO();
        boolean isSuccess = dao.addUser(user);

        // 4. Respond
        PrintWriter out = resp.getWriter();
        if (isSuccess) {
            out.print("success");
        } else {
            out.print("error");
        }
    }
}
