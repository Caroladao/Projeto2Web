/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/cadastrei"})
public class CadastrarAdmin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String admin = request.getParameter("adm");
        request.getSession().setAttribute("mensagem", "");
        
                     
        System.out.println("dados: "+nome+" || "+login+" || "+senha+" || "+email+" || "+endereco+" || ");

        System.out.println("admin " + admin);

        HttpSession session = request.getSession();
        String resposta = null;
        int adm;
        
        if(admin.equals("true")){
            adm = 1;
        }else{
            adm = 0;
        }
        
        Boolean op = false;
        boolean vemail = false;

        vemail = validaEmail(email);

        if (vemail) {
            Connection con = ConnectionFactory.getConnection();

            try {
                String sql = "INSERT INTO usuario VALUES (null,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, login);
                ps.setString(2, senha);
                ps.setString(3, nome);
                ps.setString(4, email);
                ps.setString(5, endereco);
                ps.setInt(6, adm);
                ps.executeUpdate();
                op = true;

            } catch (Exception e) {
                e.printStackTrace();
                request.getSession().setAttribute("mensagem","NAO FOI!!");
            }

            if (op) {
                System.out.println("FOOOI!");
                resposta = "Usuario gravado com sucesso";
                response.sendRedirect("./cadastroo.jsp");

            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                resposta = "Erro ao gravar usuario";
                response.sendRedirect("./cadastroo.jsp");
            }

        }    
        else{
            request.getSession().setAttribute("mensagem", "EMAIL INVÁLIDO!!!");
            response.sendRedirect("./cadastroo.jsp");
        }
        
        response.setContentType("application/json");
        response.getWriter().write((new Gson()).toJson(resposta));
        System.out.println("resposta -> "+resposta);

    }

    private boolean validaEmail(String email) {
        boolean ema = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                ema = true;
            }
        }
        return ema;
    }

}