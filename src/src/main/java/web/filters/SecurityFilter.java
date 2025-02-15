package web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filtre permettant d'empêcher l'accès à des pages sans s'être login
 */
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     *
     * @param request servlet requête
     * @param response servlet réponse
     * @param chain la chaîne de filtrage que l'on applique
     * @throws ServletException la méthode peut retourner une exception de type "Servletexception"
     * @throws IOException la méthode peut retourner une exception de type "IOException"
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /* Cast des objets request et response */
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        /* Récupération de la session depuis la requête */
        HttpSession session = req.getSession();

        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute("id") == null ) {
            /* Redirection vers la page publique */
            rep.sendRedirect( "/Project-One/login");
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }
    }

    @Override
    public void destroy() {

    }
}
