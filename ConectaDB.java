import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDB {
    // Conexão com BD
    private Connection conexao;

    // Construtor que conecta ao Banco de Dados
    public ConectaDB() {
        String url = "jdbc:mariadb://localhost:3306/ED II";
        String user = "root";
        String pwd = "root";

        try {
            conexao = DriverManager.getConnection(url, user, pwd);
            System.out.println("Conexão Realizada");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Método para retornar a conexão com o BD
    public Connection getConexaoDB() {
        return conexao;
    }
}
