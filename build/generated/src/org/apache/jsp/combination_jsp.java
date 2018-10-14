package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class combination_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <form class=\"container\" style=\"margin-top: 100px;\" action=\"testing\">\n");
      out.write("            <img src=\"lucene.png\" style=\"margin-left: 250px; margin-top: 0px;\" class=\"img-rounded\" alt=\"Cinque Terre\">\n");
      out.write("            <div class=\"form-group\" style=\"margin-left:270px;margin-right: 200px;margin-top: 5px;\">\n");
      out.write("<!--      <label  style=\"margin-left: 100px;margin-top: 50px;\">Exception:</label>-->\n");
      out.write("      <div class=\"col-sm-4\" >\n");
      out.write("        <input type=\"text\" class=\"form-control\" id=\"email\" placeholder=\"Enter time1(dd-mm-yyyyhh:mm:ss)\" name=\"time1\">\n");
      out.write("      </div>           \n");
      out.write("<div  class=\"col-sm-4\" >\n");
      out.write("        <input type=\"text\" class=\"form-control\" id=\"email\" placeholder=\"Enter time2(dd-mm-yyyyhh:mm:ss)\" name=\"time2\">\n");
      out.write("</div>            \n");
      out.write("<div  class=\"col-sm-4\">\n");
      out.write("        <input type=\"text\" class=\"form-control\" id=\"email\" placeholder=\"Enter data(*optional)\" name=\"exception\">\n");
      out.write("</div></div>\n");
      out.write("<div class=\"btn-group\" style=\"margin-left: 300px;margin-top: 50px;\">\n");
      out.write("\n");
      out.write("        <button type=\"submit\" name=\"btn\" value=\"5\" class=\"btn btn-default\">Between Timestamp</button>\n");
      out.write("  \n");
      out.write("\n");
      out.write("        <button type=\"submit\" name=\"btn\" value=\"6\" class=\"btn btn-default\">Exception and timestamp</button>\n");
      out.write("    \n");
      out.write("\n");
      out.write("        <button type=\"submit\" name=\"btn\" value=\"7\" class=\"btn btn-default\">Id and Timestamp</button>\n");
      out.write("   \n");
      out.write("\n");
      out.write("        <button type=\"submit\" name=\"btn\" value=\"8\" class=\"btn btn-default\">Error and timestamp</button>\n");
      out.write("        \n");
      out.write("</div></div>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
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
