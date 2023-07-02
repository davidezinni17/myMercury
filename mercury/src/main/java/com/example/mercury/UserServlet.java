package com.example.mercury;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet(name = "reg", urlPatterns = "/user-register")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder error = new StringBuilder();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String pass = req.getParameter("pass");
        String confirmPass = req.getParameter("confirmPass");

        if (name.isEmpty()|| surname.isEmpty() || email.isEmpty() || age.isEmpty() || pass.isEmpty()) {
            error.append("you have an error..");
            req.setAttribute("error", error);
        } else if (!pass.equalsIgnoreCase(confirmPass)) {
            error.append("Password do not match");
            req.setAttribute("error", error);
        }

        if (error.length() > 0) {
            getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            User u = new User();
            UserDao ud = new UserDao();

            u.setNome(name);
            u.setSuranme(surname);
            u.setEmail(email);
            u.setAge(age);
            u.setPass(pass);

            ud.insertUser(u);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);

        }
    }
}