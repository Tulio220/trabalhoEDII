import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class LivroDAO {
    public void inserir(Livro livro){
        ConectaDB conexao = new ConectaDB();
        String sql = "INSERT INTO livro (titulo, autor, ano) values(?,?,?)";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getAutor());
            pst.setInt(3, livro.getAno_publicacao());
            pst.execute();
            System.out.println("Inserção ok:" + livro);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Falha na Inserção:" + e.getMessage());
        }
    }

    public LinkedList<Livro> consultarTodos(){
        ConectaDB conexao = new ConectaDB();
        String sql = "SELECT * FROM livro";
        LinkedList<Livro> lista = new LinkedList<Livro>();
        try{
            prepareStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            //executar consulta
            ResultSet resultados = pst.executeQuery();
        }catch(Exception e){
            System.out.println("Falha na consulta livro: " + e.getMessage());
        }
    }
}
