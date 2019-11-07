package web.controllers;

import services.dao.VolDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    @EJB
    private VolDAOLocal volDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("vols",volDAO.getAllVols());
        request.setAttribute("title", "Home");
        request.getRequestDispatcher("/WEB-INF/pages/restreint/home.jsp").forward(request, response);
    }
}
