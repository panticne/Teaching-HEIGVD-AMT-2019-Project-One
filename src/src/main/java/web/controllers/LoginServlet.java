package web.controllers;

import services.dao.PiloteDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    @EJB
    private PiloteDAOLocal piloteDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pseudo = req.getParameter("pseudo");
        String motdepasse = req.getParameter("motdepasse");
        try {
            if(piloteDAO.loginControl(pseudo,motdepasse)){
                req.setAttribute("pseudo", pseudo); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
                req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/pages/home.jsp");

    }
}
