package web.controllers;

import model.Pilote;
import services.dao.PiloteDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyAccountServlet extends HttpServlet {

    @EJB
    private PiloteDAOLocal piloteDAOLocal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int pilotId = (int)session.getAttribute("id");
        request.setAttribute("pilote", piloteDAOLocal.getPiloteById(pilotId));
        request.setAttribute("title", "Mon Compte");
        request.getRequestDispatcher("/WEB-INF/pages/monCompte.jsp").forward(request, response);
        }
    }
