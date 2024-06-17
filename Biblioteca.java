import java.util.LinkedList;
import java.util.ListIterator;

public class Biblioteca {
    private LinkedList<Livro> livros;
    private LinkedList<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new LinkedList<>();
        this.usuarios = new LinkedList<>();
    }

    // Métodos para livros
    public void inserirLivro(Livro livro) {
        livros.add(livro);
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
        ListIterator<Livro> iterator = livros.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public LinkedList<Livro> listarLivros() {
        livros.sort((l1, l2) -> Integer.compare(l1.getId(), l2.getId()));
        return livros;
    }

    // Métodos para usuários
    public void inserirUsuario(Usuario usuario) {
        usuarios.add(usuario);
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
        ListIterator<Usuario> iterator = usuarios.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public LinkedList<Usuario> listarUsuarios() {
        usuarios.sort((u1, u2) -> Integer.compare(u1.getId(), u2.getId()));
        return usuarios;
    }
}
