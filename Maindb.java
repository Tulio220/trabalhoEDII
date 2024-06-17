
public class Maindb {
    public static void main(String[] args) {
        Livro liv = new Livro("O senhor dos Anéis", "J. R. R. Tolkien", 1953);

        LivroDAO objDAO = new LivroDAO();
        objDAO.inserir(liv);
    }
}
