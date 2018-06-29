package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(urlPatterns = {"/UploadServlet"})
public class UploadServlet extends HttpServlet {

    private File file;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Publicacao pub = new Publicacao();
        boolean op = false;
        boolean isMultipart;
        String diretorio;
        int maxFileSize = 5000 * 1024;
        
        HttpSession session = request.getSession();
        int cod = (int) session.getAttribute("cod");

        diretorio = getServletContext().getInitParameter("file_upload");        //pegando a pasta do projeto
        String pastaProjeto = getServletContext().getRealPath("");
        String salvarEm = pastaProjeto + diretorio;
        System.out.println("Salvar arquivo em: " + salvarEm);

        File pasta = new File(salvarEm);
        if (!pasta.exists()) {
            //criar a pasta
            pasta.mkdir();
        }

        isMultipart = ServletFileUpload.isMultipartContent(request);
        PrintWriter out = response.getWriter();
        if (!isMultipart) {
            System.out.print("arquivo não upou");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxFileSize);
        factory.setRepository(new File("C:\\temp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(maxFileSize);
        try {
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();

            List<FileItem> camposForm = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

            while (i.hasNext()) {

                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(salvarEm + fileName.substring(fileName.lastIndexOf("\\")));
                        pub.setArquivo(file.toString());
                    } else {
                        file = new File(salvarEm + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        pub.setArquivo(file.toString());
                    }
                    fi.write(file);
                    System.out.println("File Upado: " + fileName);
                }
                if (fi.isFormField()) {
                    if (fi.getFieldName().equals("titulo")) {
                        pub.setTitulo(fi.getString());
                    }
                    if (fi.getFieldName().equals("descricao")) {
                        pub.setDescricao(fi.getString());
                    }
                }
            }
            System.out.println("Arquivo " + pub.getArquivo());
            System.out.println("Titulo " + pub.getTitulo());
            System.out.println("Descricao " + pub.getDescricao());

            out.println("antes da conexão");
            Connection con = ConnectionFactory.getConnection();

            try {
                String sql = "INSERT INTO publicacao VALUES (null,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, pub.getTitulo());
                ps.setString(2, pub.getDescricao());
                ps.setString(3, pub.getArquivo());
                ps.setInt(4, cod);

                ps.execute();
                op = true;

                out.println("publicação cadastrado!");
                
            ps.close();
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
        } catch (Exception e) {
            System.err.println("Erro no upload dos arquivos");
            request.setAttribute("mensagem", "Erro no upload dos arquivos: " + e);
        }

    }

}
