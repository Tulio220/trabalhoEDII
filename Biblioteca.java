import java.sql.Connection;

public class Biblioteca {
    private LivroDAO livroDAO;
    private UsuarioDAO usuarioDAO;

    public Biblioteca(Connection conexao) {
        this.livroDAO = new LivroDAO(conexao);
        this.usuarioDAO = new UsuarioDAO(conexao);
    }

    // Métodos para gerenciar livros
    public void inserir(Livro livro) {
        livroDAO.inserir(livro);
    }

    public void listarTodos() {
        livroDAO.listarTodos();
    }

    public Livro consultaID(int id) {
        return livroDAO.consultaID(id);
    }

    public void remover(int id) {
        livroDAO.remover(id);
    }

    // Métodos para gerenciar usuários
    public void inserirUsuario(Usuario usuario) {
        usuarioDAO.inserir(usuario);
    }

    public void listarTodosUsuarios() {
        usuarioDAO.listarTodos();
    }

    public Usuario consultaIDUsuario(int id) {
        return usuarioDAO.consultaID(id);
    }

    public void removerUsuario(int id) {
        usuarioDAO.remover(id);
    }
}
