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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/cadastrar"})
public class CadastroUsuario extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        request.getSession().setAttribute("mensagem", "");

        HttpSession session = request.getSession();

        boolean op = false;
        boolean vemail = false;

        vemail = validaEmail(email);

        if (vemail) {
            Connection con = ConnectionFactory.getConnection();

            try {
                String sql = "INSERT INTO usuario VALUES (null,'" + login + "','" + senha + "','" + nome + "','" + email + "','" + endereco + "',false)";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.execute();

                op = true;
                out.println("usuario cadastrado!");

                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (op) {
                System.out.println("FOI!");
                response.sendRedirect("./index.jsp");

            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                request.getSession().setAttribute("mensagem", "EMAIL OU LOGIN INVÁLIDOS!!!");
                response.sendRedirect("./cadastro.jsp");
            }
        }else{
            request.getSession().setAttribute("mensagem","EMAIL INVÁLIDO!!!");
            response.sendRedirect("./cadastro.jsp");
        }

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
