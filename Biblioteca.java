import java.util.LinkedList;

public class Biblioteca {
    private LinkedList<Livro> livros;
    private LinkedList<Usuario> usuarios;

    public Biblioteca() {
        livros = new LinkedList<>();
        usuarios = new LinkedList<>();
    }

    // Métodos para gerenciar livros
    public void inserir(Livro livro) {
        livros.add(livro);
        livros.sort((Livro l1, Livro l2) -> l1.getId() - l2.getId());
    }

    public Livro consultaID(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                System.out.println(livro);
                return livro;
            }
        }
        System.out.println("Livro não encontrado.");
        return null;
    }

    public boolean remover(int id) {
        Livro livro = consultaID(id);
        if (livro != null) {
            livros.remove(livro);
            System.out.println("Livro removido com sucesso.");
            return true;
        }
        System.out.println("Falha ao remover o livro.");
        return false;
    }

    public void listarTodos() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    // Métodos para gerenciar usuários
    public void inserirUsuario(Usuario usuario) {
        usuarios.add(usuario);
        usuarios.sort((Usuario u1, Usuario u2) -> u1.getId() - u2.getId());
    }

    public Usuario consultaIDUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                System.out.println(usuario);
                return usuario;
            }
        }
        System.out.println("Usuário não encontrado.");
        return null;
    }

    public boolean removerUsuario(int id) {
        Usuario usuario = consultaIDUsuario(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuário removido com sucesso.");
            return true;
        }
        System.out.println("Falha ao remover o usuário.");
        return false;
    }

    public void listarTodosUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
