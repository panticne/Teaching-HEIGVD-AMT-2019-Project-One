package web.controllers;

import services.dao.AvionDAO;
import services.dao.AvionDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class AvionServlet extends HttpServlet {
    @EJB
    private AvionDAOLocal avionDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        try {
            request.setAttribute("avions", avionDAO.getAllPlane());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/pages/avion.jsp").forward(request, response);
    }
}
