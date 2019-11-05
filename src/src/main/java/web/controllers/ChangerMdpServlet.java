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

public class ChangerMdpServlet extends HttpServlet {
    @EJB
    private PiloteDAOLocal piloteDAOLocal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Changer le mot de passe");
        request.getRequestDispatcher("/WEB-INF/pages/changerMdp.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        boolean ok = false;
        HttpSession session = request.getSession();
        int pilotId = (int)session.getAttribute("id");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

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
