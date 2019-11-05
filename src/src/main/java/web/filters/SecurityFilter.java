package web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        boolean isProtected = true;

        if(path.startsWith("/home/")){
            isProtected = false;
        }else{
            request.setAttribute("target",path);
        }


        String main = (String) httpRequest.getSession().getAttribute("main");
        if(main == null && isProtected){

            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);

        }else{

            chain.doFilter(request,response);
        }


    }

    @Override
    public void destroy() {

    }
}
