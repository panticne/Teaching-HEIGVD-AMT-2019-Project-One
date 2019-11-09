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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class RegisterServlet extends HttpServlet {

    @EJB
    private PiloteDAOLocal piloteDAO;

    protected void doGet(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException{

        RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/pages/registration.jsp");
         req.include(request,response);

    }

    private static String getSecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String pseudo = request.getParameter("pseudo");
        String motdepasse = request.getParameter("motdepasse");
        String securePassword = "";

        securePassword = getSecurePassword(motdepasse);


        Pilote pilote = new Pilote(prenom,nom,pseudo,securePassword);

        try {
            piloteDAO.registerPilote(pilote);
        }catch (Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("/Project-One/pages/home?page=1");
    }
}
