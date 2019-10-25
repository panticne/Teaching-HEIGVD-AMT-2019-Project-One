package web.controllers;

import services.dao.PiloteDAO;
import services.dao.PiloteDAOLocal;

import java.io.IOException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PiloteServlet extends HttpServlet{

    @EJB
    private PiloteDAOLocal piloteDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("pilotes", piloteDAO.getAllPilotes());
            request.getRequestDispatcher("/WEB-INF/pages/pilote.jsp").forward(request, response);
        }
    }

