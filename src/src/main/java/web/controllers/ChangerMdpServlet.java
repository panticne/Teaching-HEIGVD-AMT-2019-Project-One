package web.controllers;

import model.Pilote;
import services.dao.AvionDAOLocal;
import services.dao.PiloteDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Ce contrôleur permet de changer le mot de passe
 */
public class ChangerMdpServlet extends HttpServlet {
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
        request.setAttribute("title", "Changer le mot de passe");
        request.getRequestDispatcher("/WEB-INF/pages/restreint/changerMdp.jsp").forward(request, response);
    }

    /**
     * @describe méthode permettant de hasher un mot de passe
     * @param passwordToHash mot de passe que nous souhaitons hasher
     * @return le mot de passe chiffré
     */
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

    /**
     * @param request servlet requête
     * @param response servlet réponse
     * @throws ServletException la méthode peut retourner une exception de type "Servletexception"
     * @throws IOException la méthode peut retourner une exception de type "IOException"
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        boolean ok = false;
        HttpSession session = request.getSession();
        int pilotId = (int)session.getAttribute("id");
        String oldPassword = getSecurePassword(request.getParameter("oldPassword"));
        String newPassword = getSecurePassword(request.getParameter("newPassword"));
        String confirmPassword = getSecurePassword(request.getParameter("confirmPassword"));

        try {
            ok = piloteDAOLocal.changePassword(pilotId, oldPassword, newPassword, confirmPassword);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(ok){
            response.sendRedirect("/Project-One/pages/myAccount");
        } else {
            response.sendRedirect("/Project-One/pages/changerMdp");
        }
    }
}
