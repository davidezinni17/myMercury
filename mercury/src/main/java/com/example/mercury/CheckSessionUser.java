package com.example.mercury;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class CheckSessionUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        StringBuilder errorCheck = new StringBuilder();

        if(session.getAttribute("user") == (null)){
            errorCheck.append("Effettua il login");
            req.setAttribute("errorCheck",errorCheck);
            resp.sendRedirect("login.jsp");

        }else{
            getServletContext().getRequestDispatcher("/home.jsp").forward(req,resp);
        }

    }
}
