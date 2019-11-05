package web.controllers;

import model.Vol;
import services.dao.VolDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MesVolsServlet extends HttpServlet {

    @EJB
    private VolDAOLocal volDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int pilotId = (int)session.getAttribute("id");
        List<Vol> vols = volDAO.getVolByPiloteId(pilotId);
        request.setAttribute("vols", vols);
        request.setAttribute("title", "Mes vols");
        request.getRequestDispatcher("/WEB-INF/pages/mesVols.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String volId = req.getParameter("id");
        volDAO.deleteVolById(Integer.parseInt(volId));
        req.getRequestDispatcher("/WEB-INF/pages/mesVols.jsp").forward(req, resp);
    }
}
