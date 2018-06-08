package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import servlet.Publicacao;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import servlet.ConnectionFactory;
import java.sql.Connection;

public final class busca_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    if (!session.getAttribute("logado").equals("true")) {
        response.sendRedirect("./index.jsp");
    }
    String busca = request.getParameter("q");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Projeto Web</title>\n");
      out.write("    </head>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        html,body{\n");
      out.write("            background:#f7f9f9;\n");
      out.write("            height: 100%;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            padding: 0;\n");
      out.write("            font-family: Calibri;\n");
      out.write("        }\n");
      out.write("        .section1{\n");
      out.write("            background:url('images/montanha.jpg');\n");
      out.write("            background-size: cover;\n");
      out.write("            width: 100%;\n");
      out.write("            height: 70%;\n");
      out.write("        }        \n");
      out.write("        .menu ul{\n");
      out.write("            margin: 0 auto;\n");
      out.write("            font-size: 14pt;\n");
      out.write("            padding: 2% 0;\n");
      out.write("            list-style: none;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .menu ul li {\n");
      out.write("            margin:1%;\n");
      out.write("            display: inline; \n");
      out.write("        }\n");
      out.write("        .menu ul li a{\n");
      out.write("            text-decoration: none;\n");
      out.write("            color:#b3bfc3;\n");
      out.write("        }\n");
      out.write("        .menu ul li a:hover{\n");
      out.write("            font-weight:bolder;\n");
      out.write("            color:black;\n");
      out.write("        }\n");
      out.write("        .menu2 ul{\n");
      out.write("            display: none;\n");
      out.write("        }\n");
      out.write("        .btn{\n");
      out.write("            display: none;\n");
      out.write("        }\n");
      out.write("        .id{\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 1% 0;\n");
      out.write("            width: 12%;\n");
      out.write("            height: 10%;\n");
      out.write("            font-size: 18pt;\n");
      out.write("            background: #ff664c;\n");
      out.write("            color: white;\n");
      out.write("            border:0px;\n");
      out.write("            margin: 7% 0 2% 0;\n");
      out.write("        }\n");
      out.write("        .id a{\n");
      out.write("            color:white;\n");
      out.write("        }\n");
      out.write("        .id:hover{\n");
      out.write("            font-weight:bolder;\n");
      out.write("            font-style:italic;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .section1 h1{\n");
      out.write("            color: white;\n");
      out.write("            text-align: center;\n");
      out.write("            font-size: 20pt;\n");
      out.write("        }\n");
      out.write("        .section1 p{\n");
      out.write("            color:#b3bfc3;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .section2{\n");
      out.write("            padding: 0;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            width: 80%;\n");
      out.write("            height: auto;\n");
      out.write("        }\n");
      out.write("        .publ{\n");
      out.write("            margin: 2% 0;\n");
      out.write("            height: 90%;\n");
      out.write("            padding: 2%;\n");
      out.write("            border: 2px groove;\n");
      out.write("            border-radius: 6px;\n");
      out.write("        }\n");
      out.write("        .pp{\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 3% 0;\n");
      out.write("            font-size: 24pt;\n");
      out.write("            color: #565d60;\n");
      out.write("            text-align: center;\n");
      out.write("            letter-spacing: -1px;\n");
      out.write("        }\n");
      out.write("        .p1{\n");
      out.write("            margin: 0;\n");
      out.write("            font-size: 24pt;\n");
      out.write("            color: #565d60;\n");
      out.write("            text-align: left;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        .p2{\n");
      out.write("            font-size: 16pt;\n");
      out.write("            color: #565d60;\n");
      out.write("            text-align: left;\n");
      out.write("            letter-spacing: -1px;\n");
      out.write("        }\n");
      out.write("        .imp{\n");
      out.write("            height: 250px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            margin: 0 0 0 25%;\n");
      out.write("            width: 50%;\n");
      out.write("            position: relative;\n");
      out.write("        }\n");
      out.write("        .busca {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            height: 40px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            font-style:italic;\n");
      out.write("            font-size:18px;\n");
      out.write("        }\n");
      out.write("        .btnn {\n");
      out.write("            padding: 5px;\n");
      out.write("            position: absolute;   \n");
      out.write("            top: 0; \n");
      out.write("            right: 0;\n");
      out.write("            height: 40px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        .imgbusca{\n");
      out.write("            height: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        @media screen and (max-width: 992px) {\n");
      out.write("            .session1{\n");
      out.write("                height: auto;\n");
      out.write("            }\n");
      out.write("            .menu ul{\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("            img.btn{\n");
      out.write("                display: block;\n");
      out.write("                width: 10%;\n");
      out.write("            }\n");
      out.write("            .btn:hover{\n");
      out.write("                background-color: #868e93;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .botao{\n");
      out.write("                padding: 1% 0;\n");
      out.write("                width: 35%;\n");
      out.write("                font-size: 170%;\n");
      out.write("                height: 20%;\n");
      out.write("            }\n");
      out.write("            .session1 h1{\n");
      out.write("                padding: 0 10%;\n");
      out.write("                font-size:150%;\n");
      out.write("            }\n");
      out.write("            .session1 p{\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 130%;\n");
      out.write("                padding: 0 10% 5% 10%;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .session2{\n");
      out.write("                width: 90%;\n");
      out.write("            }\n");
      out.write("            .pp{\n");
      out.write("                padding: 5% 0;\n");
      out.write("                font-size: 150%;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("            .p1{\n");
      out.write("                padding: 5% 0;\n");
      out.write("                font-size: 150%;\n");
      out.write("            }\n");
      out.write("            .p2{\n");
      out.write("                margin: 0 auto;\n");
      out.write("                padding: 3% 0;\n");
      out.write("                font-size: 130%;\n");
      out.write("                color: #565d60;\n");
      out.write("                text-align: left;\n");
      out.write("                width: 90%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <section class=\"section1\">\n");
      out.write("            <nav class=\"menu\">                    \n");
      out.write("                <ul>    \n");
      out.write("                    <li><a href=\"./home.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"./cadastroo.jsp\">Cadastro</a></li>\n");
      out.write("                    <li><a href=\"./publicacao.jsp\">Publicar</a></li>\n");
      out.write("                    <li><a href=\"./Logout\">Sair</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <nav class=\"menu2\">\n");
      out.write("                <img class=\"btn\" src=\"images/btn.png\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"./home.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"./cadastroo.jsp\">Cadastro</a></li>\n");
      out.write("                    <li><a href=\"./publicacao.jsp\">Publicar</a></li>\n");
      out.write("                    <li><a href=\"./Logout\">Sair</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <center><div class=\"id\">\n");
      out.write("                    <b> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.login}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b>\n");
      out.write("                </div></center>\n");
      out.write("            <br>\n");
      out.write("            <h1>Bem vindo:</h1>\n");
      out.write("            <p>Se você não for administrador, não poderá publicar nada, sinto muito! <br> Mas você pode olhar as publicações, olha que legal!</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("        <section class=\"section2\">\n");
      out.write("            <p class=\"pp\"><b>Publicações</b></p>\n");
      out.write("            <hr>\n");
      out.write("            <form action=\"./busca.jsp\" method=\"get\">\n");
      out.write("                <div class=\"container\">  \n");
      out.write("                    <input type=\"search\" class=\"busca\" name=\"q\" placeholder=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${busca}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">\">\n");
      out.write("                    <button class=\"btnn\" type=\"submit\"><img class=\"imgbusca\" src=\"images/search.png\"></button>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            <hr>\n");
      out.write("\n");
      out.write("            ");

                Connection con = ConnectionFactory.getConnection();
                int cont = 0;
                try {
                    String q = "SELECT count(*) AS cntd FROM publicacao";
                    PreparedStatement ps = con.prepareStatement(q);

                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        cont = rs.getInt("cntd");
                        System.out.println("Quantidade " + cont);
                    }
                    rs.close();
                    ps.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

      out.write('\n');

                Publicacao pub[] = new Publicacao[cont];
                int ct = 0, cod, usuario;
                String titulo, descricao, arquivo;

                try {
                    String q = "SELECT * FROM publicacao WHERE pub_titulo LIKE ?";
                    PreparedStatement ps = con.prepareStatement(q);
                    ps.setString(1, busca + "%");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        cod = rs.getInt("pub_codigo");
                        titulo = rs.getString("pub_titulo");
                        descricao = rs.getString("pub_texto");
                        arquivo = rs.getString("pub_arquivo");
                        usuario = rs.getInt("usu_codigo");
                    }
                    rs.close();
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                for (ct = 0; ct < cont; ct++) {
            
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"publ\">\n");
      out.write("                <p class=\"p1\">");
      out.print( pub[ct].getTitulo());
      out.write("</p>\n");
      out.write("                <p class=\"p2\">");
      out.print(pub[ct].getDescricao());
      out.write("</p>\n");
      out.write("                ");

                    String cam, aux = pub[ct].getArquivo();
                    int n = aux.lastIndexOf("web");
                    n = n + 3;
                    cam = aux.substring(n);
                
      out.write("\n");
      out.write("\n");
      out.write("                <img class=\"imp\" src=\".");
      out.print(cam);
      out.write("\" >\n");
      out.write("            </div>\n");
      out.write("            ");
}
            
      out.write("\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
