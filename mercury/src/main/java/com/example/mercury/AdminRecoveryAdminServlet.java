package com.example.mercury;

import dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "admin-recovery",urlPatterns = "/admin-recoveryAdmin")
public class AdminRecoveryAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AdminDao ad = new AdminDao();

        ArrayList<Admin> adminList = ad.recoveryAllAdmin();

        if(adminList.size() > 0){
            req.setAttribute("adminList",adminList);
            req.getRequestDispatcher("/admin-recoveryAdmin.jsp").forward(req,resp);
        }else{
            System.out.println("array vuoto");
            resp.sendRedirect("home.jsp");
        }

    }
}
