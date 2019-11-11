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
import java.sql.SQLException;
import java.util.List;

/**
 * Contrôleur permettant de gérer mes vols
 */
public class MesVolsServlet extends HttpServlet {

    @EJB
    private VolDAOLocal volDAO;
    private double nbRecordPerPage = 10;
    private double page = 1;

    /**
     * @param request servlet requête
     * @param response servlet réponse
     * @throws ServletException la méthode peut retourner une exception de type "Servletexception"
     * @throws IOException la méthode peut retourner une exception de type "IOException"
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int pilotId = (int)session.getAttribute("id");
        double nbTotalRecords = 0;
        try {
            nbTotalRecords = volDAO.getNbVolByPiloteId(pilotId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        List<Vol> vols = null;
        try {
            vols = volDAO.getVolByPiloteId(pilotId, (int)page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("vols", vols);
        request.setAttribute("title", "Mes vols");
        request.setAttribute("nbPages", (int)nbPages);
        request.setAttribute("page", (int)page);
        request.getRequestDispatcher("/WEB-INF/pages/restreint/mesVols.jsp").forward(request, response);
    }

    /**
     * @param req servlet requête
     * @param resp servlet réponse
     * @throws ServletException la méthode peut retourner une exception de type "Servletexception"
     * @throws IOException la méthode peut retourner une exception de type "IOException"
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String volId = req.getParameter("id");
        try {
            volDAO.deleteVolById(Integer.parseInt(volId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/Project-One/pages/mesVols");
    }
}
