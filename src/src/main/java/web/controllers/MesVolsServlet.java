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
    private double nbRecordPerPage = 10;
    private double page = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int pilotId = (int)session.getAttribute("id");
        double nbTotalRecords = volDAO.getNbVolByPiloteId(pilotId);
        double nbPages = Math.ceil(nbTotalRecords / nbRecordPerPage);
        String pageRequest = null;

        if((pageRequest = request.getParameter("page")) != null){
            int pageSelected = (int)page;
            if(pageRequest.equals("previous")){
                --pageSelected;
            }else if(pageRequest.equals("next")){
                ++pageSelected;
            }

            if(pageSelected <= nbPages && pageSelected > 0) {
                page = pageSelected;
            }
        }else {
            page = 1;
        }
        List<Vol> vols = volDAO.getVolByPiloteId(pilotId, (int)page);
        request.setAttribute("vols", vols);
        request.setAttribute("title", "Mes vols");
        request.setAttribute("nbPages", (int)nbPages);
        request.setAttribute("page", (int)page);
        request.getRequestDispatcher("/WEB-INF/pages/restreint/mesVols.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String volId = req.getParameter("id");
        volDAO.deleteVolById(Integer.parseInt(volId));
        resp.sendRedirect("/Project-One/pages/mesVols");
    }
}
