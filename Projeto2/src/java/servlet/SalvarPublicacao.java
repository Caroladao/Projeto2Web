package servlet;

import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(urlPatterns = {"/publicar"})
public class SalvarPublicacao extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String UPLOAD_DIRECTORY;

    @Override
    //@MultipartConfig
//    public void init(ServletConfig config) throws ServletException {;
//        super.init();
//        
//        UPLOAD_DIRECTORY = getServletContext().getInitParameter("UPLOAD_DIRECTORY");
//    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        File diretorio = null;
        String name = null;
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> camposForm = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                Publicacao pub = new Publicacao();
                
                
                for (FileItem item : camposForm) {
                    if (item.isFormField()) {
                        if (item.getFieldName().equals("titulo")) {
                            pub.setTitulo(item.getString());
                        }
                        if (item.getFieldName().equals("descricao")) {
                            pub.setDescricao(item.getString());
                        }
                    }
                }
                for (FileItem item : camposForm) {
                    if (!item.isFormField()) {
                        name = new File(item.getName()).getName();
                        diretorio = new File("imagens"+ File.separator +name);
                        String path = diretorio+ File.separator + name;
                        out.println("Name: " + name);
                        out.println("path: " + path);

                        if (item.getFieldName().equals("arquivo")) {

                            HttpSession session = request.getSession();

                           // String titulo = request.getParameter("titulo");
                            
                            out.println("Titulo " + pub.getTitulo());
                            //String descricao = request.getParameter("descricao");
                            out.println("des " + pub.getDescricao());
                            int cod = (int) session.getAttribute("cod");
                            out.println("cod: " + cod);
                            Boolean op = false;

                            out.println("antes da conexão");
                            Connection con = ConnectionFactory.getConnection();

                            try {
                                String sql = "INSERT INTO publicacao VALUES (null,?,?,?,?)";
                                PreparedStatement ps = con.prepareStatement(sql);
                                ps.setString(1, pub.getTitulo());
                                ps.setString(2, pub.getDescricao());
                                ps.setString(3, diretorio.toString());
                                ps.setInt(4, cod);

                                ps.execute();
                                op = true;

                                out.println("publicação cadastrado!");

                            } catch (Exception e) {
                                e.printStackTrace();
                                out.println(e);
                            }

                            if (op) {
                                System.out.println("FOOOI!");
                                response.sendRedirect("./home.jsp");

                            } else {
                                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                                response.sendRedirect("./publicacao.jsp");
                            }

                        }
                        item.write(new File(path));
                    }
                }
            } catch (Exception e) {
                System.err.println("Erro no upload dos arquivos");
                request.setAttribute("mensagem", "Erro no upload dos arquivos: " + e);
            }

        }

        
         
        System.out.println("");
        
        //pegando a pasta do projeto
        String pastaProjeto = getServletContext().getRealPath("");
        
        //definir o caminho completo da pasta do arquivo
        String salvarEm = pastaProjeto + diretorio + File.separator;
        System.out.println("Salvar arquivo em: "+salvarEm);
        
        //verificar se a pasta existe ou criar caso n exista
        File pasta = new File(salvarEm);
        if(!pasta.exists()){
            //criar a pasta
            pasta.mkdir();
        }
        //pegar o arquivo selecionado
        Part arquivoSelecionado = request.getPart("arquivo");
        
       // String nomeArquivo = arquivoSelecionado.getSubmittedFileName();
        
        //gravar arquivo na pasta
        arquivoSelecionado.write(salvarEm + File.separator + name);
         
    }

}
