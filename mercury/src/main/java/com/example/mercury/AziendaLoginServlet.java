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

@WebServlet(name="login-azienda",urlPatterns = "/login-azienda")
public class AziendaLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("name");
        String p_iva = req.getParameter("p_iva");
        StringBuilder error = new StringBuilder();

        if(p_iva.isEmpty() || nome.isEmpty()){
         error.append("Field partita iva is required!");
         req.setAttribute("error",error);
        }

        if(error.length() > 0){
            getServletContext().getRequestDispatcher("/login-azienda.jsp").forward(req,resp);
        }else{
            HttpSession session = req.getSession();
            Azienda a = new Azienda();
            AziendaDao ad = new AziendaDao();

            a.setNomeAzienda(nome);
            a.setP_iva(p_iva);

            ad.loginAzienda(a);

            if(ad.isCheckLogin()){
                session.setAttribute("azienda",a);
                getServletContext().getRequestDispatcher("/home-azienda.jsp").forward(req,resp);
            }else {
                error.append("the password isn't correct");
                req.setAttribute("error",error);
                getServletContext().getRequestDispatcher("/login-azienda.jsp").forward(req,resp);

            }
        }

    }
}
