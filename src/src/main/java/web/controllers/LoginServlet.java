package web.controllers;

import services.dao.PiloteDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
                HttpSession session = req.getSession();
                int piloteId = piloteDAO.getPiloteId(pseudo, motdepasse);
                session.setAttribute("id", piloteId);
                resp.sendRedirect("/Project-One/pages/home");
            }else{
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }
}
