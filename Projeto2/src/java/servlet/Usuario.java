
package servlet;

/**
 * @author carol
 */
public class Usuario {
    
    private String login;
    private String senha;
    private String nome;
    private String email;
    private String endereco;
    private int codigo;
    private boolean adm;
    
    public Usuario(){
    }

    public Usuario(String login, String senha, String nome, String email, String endereco, int codigo, boolean adm) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.codigo = codigo;
        this.adm = adm;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean getAdm() {
        return adm;
    }
    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
}
