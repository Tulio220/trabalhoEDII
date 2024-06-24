import java.util.LinkedList;

public class Biblioteca {
    private LinkedList<Livro> livros;
    private LinkedList<Usuario> usuarios;

    public Biblioteca() {
        livros = new LinkedList<>();
        usuarios = new LinkedList<>();
    }

    // Métodos para gerenciar livros
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        livros.sort((Livro l1, Livro l2) -> l1.getId() - l2.getId());
    }

    public Livro buscarLivro(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public boolean removerLivro(int id) {
        Livro livro = buscarLivro(id);
        if (livro != null) {
            livros.remove(livro);
            return true;
        }
        return false;
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    // Métodos para gerenciar usuários
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        usuarios.sort((Usuario u1, Usuario u2) -> u1.getId() - u2.getId());
    }

    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public boolean removerUsuario(int id) {
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
