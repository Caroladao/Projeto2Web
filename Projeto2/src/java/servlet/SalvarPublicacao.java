/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@WebServlet( urlPatterns = {"/publicar"})
public class SalvarPublicacao extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String UPLOAD_DIRECTORY = null;

    @Override
    //@MultipartConfig
    public void init(ServletConfig config) throws ServletException {
        super.init();
        
        UPLOAD_DIRECTORY = getServletContext().getInitParameter("UPLOAD_DIRECTORY");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //pegando a pasta do projeto
        String pastaProjeto = getServletContext().getRealPath("");
        
        //definir o caminho completo da pasta do arquivo
        String salvarEm = pastaProjeto + File.separator + UPLOAD_DIRECTORY;
        System.out.println("Salvar arquivo em: "+salvarEm);
        
        //verificar se a pasta existe ou criar caso n exista
        File pasta = new File(salvarEm);
        if(!pasta.exists()){
            //criar a pasta
            pasta.mkdir();
        }
        //pegar o arquivo selecionado
        Part arquivoSelecionado = request.getPart("arquivo");
        String nomeArquivo = arquivoSelecionado.getSubmittedFileName();
        
        //gravar arquivo na pasta
        arquivoSelecionado.write(salvarEm + File.separator + nomeArquivo);
        
    }
    
    
}