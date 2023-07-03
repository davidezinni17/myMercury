package com.example.mercury;

import dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;

import java.io.IOException;

@WebServlet(name="admin-area", urlPatterns = "/register-admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        StringBuilder error = new StringBuilder();
        if(name.isEmpty() || surname.isEmpty() || username.isEmpty() || email.isEmpty() || pass.isEmpty()){
            error.append("You have a error!! please check all field");
        }

        if(error.length() > 0){
            req.setAttribute("error",error);
            getServletContext().getRequestDispatcher("register-admin.jsp").forward(req,resp);
        }else{
            Admin admin = new Admin();
            AdminDao ad = new AdminDao();

            admin.setName(name);
            admin.setSurname(surname);
            admin.setUsername(username);
            admin.setEmail(email);
            admin.setPassword(pass);

            ad.insertAdmin(admin);
            getServletContext().getRequestDispatcher("/login-admin.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        StringBuilder error = new StringBuilder();
        if(email.isEmpty() || pass.isEmpty()){
            error.append("You have a error!! please check all field");
        }

        if(error.length() > 0){
            req.setAttribute("error",error);
            getServletContext().getRequestDispatcher("/login-admin.jsp").forward(req,resp);
        }else{
            Admin admin = new Admin();
            AdminDao ad = new AdminDao();

            admin.setUsername(username);
            admin.setEmail(email);
            admin.setPassword(pass);

            ad.loginAdmin(admin);

            if(ad.isCheckLoginAdmin()){
                HttpSession session = req.getSession();
                session.setAttribute("admin",admin);
                getServletContext().getRequestDispatcher("/home-admin.jsp").forward(req,resp);

            }
        }

    }
}


