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

/**
 *
 * @author Carol
 */
@WebServlet(urlPatterns = {"/valida"})
public class ProjetoWeb extends HttpServlet {

@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        boolean op = false;
        boolean adm = false;
        int ucod = 0;
        String nome = "";
        Usuario user = null;
        
        Connection con = ConnectionFactory.getConnection();
        
        try {
            String q = "SELECT * FROM usuario WHERE usu_login LIKE ? and usu_senha LIKE ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, login);
            ps.setString(2, senha);
            

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                op = true;
                adm = rs.getBoolean("usu_adm");
                ucod = rs.getInt("usu_codigo");
                nome = rs.getString("usu_nome");
                System.out.println("usuario encontrado!");
                
            }    
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String admin = adm?"true":"false";
        
        if(op){            
            request.getSession().setAttribute("logado","true");
            request.getSession().setAttribute("login",login);
            request.getSession().setAttribute("adm",admin);
            request.getSession().setAttribute("cod",ucod);
            request.getSession().setAttribute("nome",nome);
            
            
            response.sendRedirect("./login");
            
        }else{
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendRedirect("./index.jsp");
        }
    }
}