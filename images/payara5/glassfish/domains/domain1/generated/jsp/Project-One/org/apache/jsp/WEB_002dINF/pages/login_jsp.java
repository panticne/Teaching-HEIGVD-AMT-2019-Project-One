package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/pages/includes/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Login</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"jumbotron text-center\">\n");
      out.write("            <h1>Login</h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row justify-content-md-center\">\n");
      out.write("            <div class=\"col-sm-4\"></div>\n");
      out.write("            <div class=\"col-sm-4\">\n");
      out.write("                <c:catch var=\"exception\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${wrong}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</c:catch>\n");
      out.write("                <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty exception}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${wrong}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </c:if>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row justify-content-md-center\">\n");
      out.write("            <div class=\"col-sm-4\"></div>\n");
      out.write("            <div class=\"col-sm-4\">\n");
      out.write("                <form action=\"/Project-One/login\" method=\"post\">\n");
      out.write("                    <input class=\"form-control input-lg\" placeholder=\"Username\" type=\"text\" name=\"pseudo\" required/>\n");
      out.write("                    <input class=\"form-control input-lg\" placeholder=\"Password\" type=\"password\" name=\"motdepasse\" required/>\n");
      out.write("                    <input class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" value=\"Login\" />\n");
      out.write("                    <a class=\"btn btn-lg btn-primary btn-block\" href=\"/Project-One/register\"> Register</a>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("<footer class=\"page-footer font-small special-color-dark pt-4\" >\n");
      out.write("\n");
      out.write("    <!-- Copyright -->\n");
      out.write("    <div class=\"footer-copyright text-center py-3\">2018 Copyright:\n");
      out.write("        <a href=\"https://mdbootstrap.com/education/bootstrap/\"> MDBootstrap.com</a>\n");
      out.write("    </div>\n");
      out.write("    <!-- Copyright -->\n");
      out.write("\n");
      out.write("</footer>");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
