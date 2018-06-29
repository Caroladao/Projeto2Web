package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/busca"})
public class Busca extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet (HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = res.getWriter();
        String busca = req.getParameter("q");
        
        Connection con = ConnectionFactory.getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM publicacao WHERE pub_titulo like ?");
            ps.setString(1, busca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                writer.println(rs.getString("pub_titulo") + ",");
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
