package com.example.mercury;

import com.sun.net.httpserver.HttpsServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name="check-session",urlPatterns = "/check-session")
public class CheckSessionAzienda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        StringBuilder errorCheck = new StringBuilder();
        if(session.getAttribute("azienda") == (null)){
            errorCheck.append("Effettua il login");
            req.setAttribute("errorCheck",errorCheck);
            resp.sendRedirect("login-azienda.jsp");

        }else{
            getServletContext().getRequestDispatcher("/home-azienda.jsp").forward(req,resp);
        }
    }
}
