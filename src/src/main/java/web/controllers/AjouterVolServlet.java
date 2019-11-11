package web.controllers;

import model.Avion;
import model.Trajet;
import services.dao.AvionDAOLocal;
import services.dao.TrajetDAO;
import services.dao.TrajetDAOLocal;
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
 * Cette classe joue le rôle de contrôleur afin de gérer l'ajout de vol
 */
public class AjouterVolServlet extends HttpServlet {

    @EJB
    private AvionDAOLocal avionDAOLocal;

    @EJB
    private TrajetDAOLocal trajetDAOLocal;

    @EJB
    private VolDAOLocal volDAOLocal;

    /**
     *
     * @param request servlet requête
     * @param response servlet réponse
     * @throws ServletException la méthode peut retourner une exception de type "Servletexception"
     * @throws IOException la méthode peut retourner une exception de type "IOException"
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int pilotId = (int)session.getAttribute("id");
        List<Avion> avions = null;
        try {
            avions = avionDAOLocal.getAllPlane();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Trajet> trajets = trajetDAOLocal.getAllTrajet();
        request.setAttribute("avions", avions);
        request.setAttribute("trajets", trajets);
        request.setAttribute("title", "Ajouter un vol");
        request.setAttribute("piloteId", pilotId);
        request.getRequestDispatcher("/WEB-INF/pages/restreint/ajouterVol.jsp").forward(request, response);
    }


    /**
     * @param request servlet requête
     * @param response servlet réponse
     * @throws ServletException la méthode peut retourner une exception de type "Servletexception"
     * @throws IOException la méthode peut retourner une exception de type "IOException"
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        int piloteId = Integer.parseInt(request.getParameter("piloteId"));
        int avionId = Integer.parseInt(request.getParameter("avion"));
        int trajetId = Integer.parseInt(request.getParameter("trajet"));
        try {
            volDAOLocal.ajouterVol(piloteId, avionId, trajetId);
        }catch (Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("/Project-One/pages/mesVols");
    }
}
