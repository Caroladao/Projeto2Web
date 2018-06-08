package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carol
 */
@WebServlet(urlPatterns = {"/Busca"})
public class Busca extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String busca = request.getParameter("q");

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
        
        Publicacao pub[] = new Publicacao[cont];
        int cod, usuario,ct=0;
        String titulo, descricao, arquivo;
        boolean op = false;        

        try {
            String q = "SELECT * FROM publicacao WHERE pub_titulo LIKE ?% OR pub_titulo LIKE %? OR pub_titulo LIKE %?% ";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, busca);
            ps.setString(2, busca);
            ps.setString(3, busca);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                op = true;
                cod = rs.getInt("pub_codigo");
                titulo = rs.getString("pub_titulo");
                descricao = rs.getString("pub_texto");
                arquivo = rs.getString("pub_arquivo");
                usuario = rs.getInt("usu_codigo");
                pub[ct] = new Publicacao(cod,titulo,descricao,arquivo,usuario);
                ct++;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(op){
            response.sendRedirect("./home.jsp");
            
        }else{
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendRedirect("./home.jsp");
        }

    }
}
