import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDB {
    //atributo
    private Connection conexao;
    //construtor
    public ConectaDB(){
        String url = "jdbc:mariadb://localhost:3306/ed2";
        String user = "root";
        String pwd = "root";
        
        try {
            conexao = DriverManager.getConnection(url,user,pwd);
            System.out.println("Conexão estabelecida!");
        } catch (Exception e){
            System.out.println("Falha na conexão!");
            System.out.println(e.getMessage());
            //TOdo: handle exception
        }
    }
    public Connection getConexaoDB(){
        return conexao;
    }
}
