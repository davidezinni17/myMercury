package com.example.mercury;

import dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Azienda;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "admin-recoveryAzienda", urlPatterns = "/admin-recoveryAzienda")
public class AdminRecoveryAziendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminDao ad = new AdminDao();
        ArrayList<Azienda> aziendaList = ad.recoveryAllAziende();

        if (aziendaList.size() > 0){
            req.setAttribute("aziendaList",aziendaList);
            req.getRequestDispatcher("/admin-recoveryAzienda.jsp").forward(req,resp);
        }else{
            System.out.println("Array vuoto");
            resp.sendRedirect("home.jsp");
        }
    }


}
