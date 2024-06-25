import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDB {

    private Connection conexao;

    public ConectaDB(){
        String url = "jdbc:mariadb://localhost:3306/ED II";
        String user = "root";
        String pwd = "root";

        try {
            conexao = DriverManager.getConnection(url, user, pwd);
            System.out.println("Conexão Realizada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Nao encontrado drive");
        }
    }

    public Connection getConexaoDB(){
        return conexao;
    }
}
