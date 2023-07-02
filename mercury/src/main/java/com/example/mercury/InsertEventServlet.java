package com.example.mercury;

import dao.EventDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Evento;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "event-servlet", urlPatterns = "/event-servlet")
public class InsertEventServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("name-evento");
        String nomeAzienda = req.getParameter("nome-azienda");
        String genere = req.getParameter("genere");
        String luogo = req.getParameter("luogo");
        String prezzo = req.getParameter("prezzo");

        StringBuilder error = new StringBuilder();

        if (nome.isEmpty() || nomeAzienda.isEmpty() || genere.isEmpty() || luogo.isEmpty() || prezzo.isEmpty()) {
            error.append("All field are required!!");
            getServletContext().getRequestDispatcher("/insert-event.jsp").forward(req, resp);
        } else {
            Evento e = new Evento();
            EventDao ed = new EventDao();

            e.setName(nome);
            e.setNomeAzienda(nomeAzienda);
            e.setGenere(genere);
            e.setLuogo(luogo);
            e.setPrezzo(prezzo);

            ed.insertEvent(e);

            getServletContext().getRequestDispatcher("/home-azienda.jsp").forward(req, resp);
        }
    }
}
