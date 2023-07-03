package com.example.mercury;

import dao.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Evento;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="admin-recoveryEvent",urlPatterns = "/admin-recoveryEvent")
public class AdminRecoveryEventServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AdminDao ad = new AdminDao();
        if(ad.recoveryEvent().size() > 0){
            ArrayList<Evento> eventList = ad.recoveryEvent();
            req.setAttribute("eventList",eventList);
            // PROVARE CON RESP.SEND
            req.getRequestDispatcher("/admin-eventRecovery.jsp").forward(req,resp);

        }else{
            System.out.println("array vuoto");
            resp.sendRedirect("home.jsp");
        }


    }
}
