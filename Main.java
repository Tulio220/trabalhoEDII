public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Inserir livros
        biblioteca.inserirLivro(new Livro(1, "Livro A", "Autor A", 2001));
        biblioteca.inserirLivro(new Livro(2, "Livro B", "Autor B", 2002));

        // Inserir usuários
        biblioteca.inserirUsuario(new Usuario(1, "Usuario A", "emailA@example.com"));
        biblioteca.inserirUsuario(new Usuario(2, "Usuario B", "emailB@example.com"));

        // Buscar e listar livros
        System.out.println("Buscando Livro com ID 1: " + biblioteca.buscarLivro(1));
        System.out.println("Listando todos os livros: " + biblioteca.listarLivros());

        // Buscar e listar usuários
        System.out.println("Buscando Usuario com ID 1: " + biblioteca.buscarUsuario(1));
        System.out.println("Listando todos os usuários: " + biblioteca.listarUsuarios());

        // Remover livro
        biblioteca.removerLivro(1);
        System.out.println("Listando todos os livros após remoção: " + biblioteca.listarLivros());

        // Remover usuário
        biblioteca.removerUsuario(1);
        System.out.println("Listando todos os usuários após remoção: " + biblioteca.listarUsuarios());
    }
}