package web.controllers;

import model.Vol;
import services.dao.VolDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Ce contrôleur permet de gérer la page home
 */
public class HomeServlet extends HttpServlet {

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
        double nbTotalRecords = 0;
        try {
            nbTotalRecords = volDAO.getNbTotalVols();
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
            vols = volDAO.getAllVols((int)page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("vols", vols);
        request.setAttribute("title", "Home");
        request.setAttribute("nbPages", (int)nbPages);
        request.setAttribute("page", (int)page);
        request.getRequestDispatcher("/WEB-INF/pages/restreint/home.jsp").forward(request, response);
    }
}
