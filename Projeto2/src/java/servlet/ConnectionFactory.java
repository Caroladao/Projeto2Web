package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carol
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/Projeto2";
    private static final String USER = "root";
    private static final String PASS = "usbw";
    
    private static Connection instancia = null; //singleton -> pesquisar
    
    private ConnectionFactory(){}
    
    public static Connection getConnection(){
        if(instancia == null){
            try {
                Class.forName(DRIVER);
                instancia = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("no banco");
                return instancia;
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException("Erro na Conexão: ", ex);
            }
        }
        return instancia;
    }
    
    
    public static void closeConnection(Connection con){
        try {
            if(con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro : "+ ex);
        }
    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        try {
            if(stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro : "+ ex);
        }
        closeConnection(con);

    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro : "+ ex);
        }
        closeConnection(con, stmt);
    }
    
}