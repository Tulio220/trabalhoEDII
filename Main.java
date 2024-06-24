public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Teste com livros
        biblioteca.adicionarLivro(new Livro(1, "O Hobbit", "J.R.R. Tolkien", 1937));
        biblioteca.adicionarLivro(new Livro(2, "1984", "George Orwell", 1949));
        biblioteca.adicionarLivro(new Livro(3, "Dom Quixote", "Miguel de Cervantes", 1605));

        System.out.println("Listagem de Livros:");
        biblioteca.listarLivros();

        System.out.println("\nBusca de Livro com ID 2:");
        System.out.println(biblioteca.buscarLivro(2));

        System.out.println("\nRemoção do Livro com ID 2:");
        biblioteca.removerLivro(2);
        biblioteca.listarLivros();

        // Teste com usuários
        biblioteca.adicionarUsuario(new Usuario(1, "Alice", "alice@example.com"));
        biblioteca.adicionarUsuario(new Usuario(2, "Bob", "bob@example.com"));
        biblioteca.adicionarUsuario(new Usuario(3, "Charlie", "charlie@example.com"));

        System.out.println("\nListagem de Usuários:");
        biblioteca.listarUsuarios();

        System.out.println("\nBusca de Usuário com ID 2:");
        System.out.println(biblioteca.buscarUsuario(2));

        System.out.println("\nRemoção do Usuário com ID 2:");
        biblioteca.removerUsuario(2);
        biblioteca.listarUsuarios();
    }
}
