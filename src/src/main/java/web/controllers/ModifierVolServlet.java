package web.controllers;

import model.Avion;
import model.Trajet;
import model.Vol;
import services.dao.AvionDAOLocal;
import services.dao.PiloteDAOLocal;
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
 * Contrôleur permettant de modifier un vol
 */
public class ModifierVolServlet extends HttpServlet {

    @EJB
    private VolDAOLocal volDAO;

    @EJB
    private AvionDAOLocal avionDAOLocal;

    @EJB
    private TrajetDAOLocal trajetDAOLocal;

    @EJB
    private PiloteDAOLocal piloteDAOLocal;

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
        int volId = Integer.parseInt(request.getParameter("id"));
        Vol vol = null;
        try {
            vol = volDAO.getVolById(volId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Avion> avions = null;
        try {
            avions = avionDAOLocal.getAllPlane();
        }catch (SQLException e){
            e.printStackTrace();
        }
        List<Trajet> trajets = trajetDAOLocal.getAllTrajet();
        String st = "%s (%s)<br><h2>%s \uD83E\uDC52 %s (%d min.)<h2>";
        String title = String.format(
            st,
            vol.getAvion().getCompagnie(),
            vol.getAvion().getType(),
            vol.getTrajet().getStart(),
            vol.getTrajet().getEnd(),
            vol.getTrajet().getTime()
        );
        request.setAttribute("vol", vol);
        request.setAttribute("avions", avions);
        request.setAttribute("trajets", trajets);
        request.setAttribute("title", title);
        request.getRequestDispatcher("/WEB-INF/pages/restreint/modifierVol.jsp").forward(request, response);
    }

    /**
     * @param request servlet requête
     * @param response servlet réponse
     * @throws ServletException la méthode peut retourner une exception de type "Servletexception"
     * @throws IOException la méthode peut retourner une exception de type "IOException"
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        int volId = Integer.parseInt(request.getParameter("vol"));
        int avionId = Integer.parseInt(request.getParameter("avion"));
        int trajetId = Integer.parseInt(request.getParameter("trajet"));

        HttpSession session = request.getSession();
        int pilotId = (int)session.getAttribute("id");
        Vol vol = null;
        try {
            vol = volDAO.getVolById(volId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int volPiloteId = piloteDAOLocal.getPiloteId(vol.getPilote().getPseudo(), vol.getPilote().getMotdepasse());

        if(volPiloteId == pilotId) {
            try {
                volDAO.changerVolbyPilote(volId, avionId, trajetId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/Project-One/pages/mesVols");
    }
}
