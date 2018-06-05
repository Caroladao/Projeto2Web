package servlet;

/**
 *
 * @author carol
 */
public class Publicacao {
    private String descricao,
            titulo,            
            Arquivo;
    private int codigo, 
            usuario;

    public Publicacao() {
    }

    public Publicacao(int codigo, String titulo, String descricao, String Arquivo,int usuario) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.Arquivo = Arquivo;
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getArquivo() {
        return Arquivo;
    }

    public void setArquivo(String Arquivo) {
        this.Arquivo = Arquivo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUsuario() {
        return usuario;
    }
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    
   
}
