package com.example.mercury;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

@WebServlet(name = "log", urlPatterns = "/user-login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder error = new StringBuilder();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            error.append("you have an error..");
            req.setAttribute("error", error);
        }

        if (error.length() > 0) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            User u = new User();
            UserDao ud = new UserDao();
            u.setNome(name);
            u.setEmail(email);
            u.setPass(pass);

            ud.loginUser(u);

            if (ud.isCheckLogin()) {
                HttpSession session = req.getSession();
                session.setAttribute("user",u);
                getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
            }

        }

    }
}
