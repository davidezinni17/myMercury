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

@WebServlet(name = "searchEvent-servlet", urlPatterns = "/search-event")
public class SearchEventServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EventDao ed = new EventDao();

        String genere = req.getParameter("genere").toLowerCase();
//        String luogo = req.getParameter("luogo").toLowerCase();

        StringBuilder error = new StringBuilder();
        if (genere.isEmpty() || genere == null) {
            error.append("you have an error");
        }

        ArrayList<Evento> eventList = ed.recoveryEvento();
        ArrayList<Evento> filteredList = new ArrayList<>();

        for (Evento evento : eventList) {
            if (evento.getGenere().toLowerCase().equals(genere.toLowerCase())) {
                filteredList.add(evento);
            }
        }

        if (error.length() > 0) {
            req.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/searchEvent.jsp").forward(req, resp);
        }

        req.setAttribute("searchEventList", filteredList);
        getServletContext().getRequestDispatcher("/filteredEvent.jsp").forward(req, resp);


    }
}
