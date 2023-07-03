package com.example.mercury;

import dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "admin-recoveryUser",urlPatterns = "/admin-recoveryUser")
public class AdminRecoveryUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AdminDao ad = new AdminDao();
        ArrayList<User> userList = ad.recoveryAllUser();

        if(ad.recoveryAllUser().size() > 0){
            req.setAttribute("userList",userList);
            req.getRequestDispatcher("/admin-recoveryUser.jsp").forward(req,resp);
        }else{
            System.out.println("Array vuoto");
            resp.sendRedirect("home.jsp");
        }

    }
}
