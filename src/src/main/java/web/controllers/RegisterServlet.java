package web.controllers;

import model.Pilote;
import services.dao.PiloteDAOLocal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @EJB
    private PiloteDAOLocal piloteDAO;

    protected void doGet(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException{

        RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/pages/registration.jsp");
         req.include(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String pseudo = request.getParameter("pseudo");
        String motdepasse = request.getParameter("motdepasse");

        Pilote pilote = new Pilote(prenom,nom,pseudo,motdepasse);

        try {
            piloteDAO.registerPilote(pilote);
        }catch (Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("/Project-One/pages/home");
    }
}
