/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( urlPatterns = {"/cadastrei"})
public class CadastrarAdmin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String[] admin = request.getParameterValues("adm");
           
        System.out.println("admin "+admin);
        
        HttpSession session = request.getSession();
                
        Boolean op = false;
        
        Connection con = ConnectionFactory.getConnection();
       
        
        try {
            String sql = "INSERT INTO usuario VALUES (null,'"+login+"','"+senha+"','"+nome+"','"+email+"','"+endereco+"',"+admin+")";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.execute();
            
            op = true;
            out.println("usuario cadastrado!");
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(op){
            System.out.println("FOOOI!");   
            response.sendRedirect("./home.jsp");
                 
        }else{
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendRedirect("./cadastroo.jsp");
        }
        
        
        
    }
    
    
}