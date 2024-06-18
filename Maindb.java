public class MainDB {
    public static void main(String[] args) {
        ConectaDB conectaDB = new ConectaDB();
        Biblioteca biblioteca = new Biblioteca(conectaDB.getConexaoDB());

        // Inserção de Livros
        biblioteca.inserir(new Livro(1, "Livro A", "Autor A", 2000));
        biblioteca.inserir(new Livro(2, "Livro B", "Autor B", 2010));
        biblioteca.inserir(new Livro(3, "Livro C", "Autor C", 2020));

        // Busca de Livro por ID
        System.out.println("Busca de Livro ID 2: " + biblioteca.consultaID(2));

        // Remoção de Livro por ID
        biblioteca.remover(2);

        // Listagem de Livros
        System.out.println("Listagem de Livros: ");
        biblioteca.listarTodos();

        // Inserção de Usuários
        biblioteca.inserirUsuario(new Usuario(1, "Usuario A", "emailA@exemplo.com"));
        biblioteca.inserirUsuario(new Usuario(2, "Usuario B", "emailB@exemplo.com"));
        biblioteca.inserirUsuario(new Usuario(3, "Usuario C", "emailC@exemplo.com"));

        // Busca de Usuário por ID
        System.out.println("Busca de Usuario ID 2: " + biblioteca.consultaIDUsuario(2));

        // Remoção de Usuário por ID
        biblioteca.removerUsuario(2);

        // Listagem de Usuários
        System.out.println("Listagem de Usuários: ");
        biblioteca.listarTodosUsuarios();
    }
}
