package com.example.mercury;

import dao.EventDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Evento;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="recovery-event",urlPatterns = "/recovery-event")
public class RecoveryEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EventDao ed = new EventDao();
        ArrayList<Evento> newEventList = ed.recoveryEvento();

        req.setAttribute("newEventList" ,newEventList);
        req.getRequestDispatcher("/eventi-home.jsp").forward(req,resp);
    }
}
