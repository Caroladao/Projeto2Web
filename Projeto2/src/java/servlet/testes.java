/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
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
@WebServlet(urlPatterns = {"/login"})
public class testes extends HttpServlet {

@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        
        // out.println("");    
       HttpSession session = request.getSession();       
       if(session.getAttribute("logado") != null){
            response.sendRedirect("./home.jsp");
        }else{
            response.sendRedirect("./index.jsp");
        }
    }    
}