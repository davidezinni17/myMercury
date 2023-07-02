package com.example.mercury;

import dao.AziendaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Azienda;

import java.io.IOException;

@WebServlet(name = "azienda-r", urlPatterns = "/register-azienda")
public class AziendaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String luogo = req.getParameter("luogo");
        String numero = req.getParameter("numero");
        String p_iva = req.getParameter("p_iva");

        StringBuilder error = new StringBuilder();

        if (name.isEmpty() || luogo.isEmpty() || numero.isEmpty()) {
            error.append("This field are required!!");
            req.setAttribute("error", error);
        }

        if (error.length() > 0) {
            getServletContext().getRequestDispatcher("/register-azienda.jsp").forward(req, resp);
        } else {
            Azienda a = new Azienda();
            AziendaDao ad = new AziendaDao();

            a.setNomeAzienda(name);
            a.setLuogoAzienda(luogo);
            a.setNumeroAzienda(numero);
            a.setP_iva(p_iva);

            ad.registerAzienda(a);
            getServletContext().getRequestDispatcher("/login-azienda.jsp").forward(req, resp);
        }
    }
}
