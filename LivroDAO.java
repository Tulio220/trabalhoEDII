import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class LivroDAO {
    private ConectaDB conexao;

    public LivroDAO(){
        conexao = new ConectaDB();
    }
    public void inserir(Livro livro){
        String sql = "INSERT INTO livro(titulo, autor, ano) values(?, ?, ?)";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getAutor());
            pst.setInt(3, livro.getAnoPublicacao());
           
            pst.execute();
            System.out.println("Insercao ok: "+ livro);
        } catch (Exception e) {
            System.out.println("Falha na inserção: "+ e.getMessage());
        }
    }

    public LinkedList<Livro> consultarTodos(){
        String sql = "SELECT * FROM livro";
        LinkedList<Livro> lista = new LinkedList<Livro>();
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            ResultSet resultados = pst.executeQuery();
            while (resultados.next()){
                String titulo = resultados.getString("titulo");
                String autor = resultados.getString("autor");
                int ano = resultados.getInt("ano");
                int id = resultados.getInt("id_livro");
                Livro obj = new Livro(titulo);
                obj.setAutor(autor);
                obj.setAnoPublicacao(ano);
                obj.setId(id);
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Falha na consulta livro: "+ e.getMessage());
        }
        return null;
    }

    public Livro consultar (int id){
        String sql = "SELECT * FROM livro WHERE id_livro = ?";
        Livro lista = null;
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultados = pst.executeQuery();

            if (resultados.next()){
                String titulo = resultados.getString("titulo");
                String autor = resultados.getString("autor");
                int ano = resultados.getInt("ano");
                int id_livro = resultados.getInt("id_livro");

                Livro livro = new Livro(titulo);
                
                livro.setAnoPublicacao(ano);
                livro.setAutor(autor);
                livro.setId(id_livro);
                return livro;
            }else{
                System.out.println("Não possui registro com o ID "+ id);
            }

        } catch (Exception e) {
            System.out.println("Falha na consulta: "+ e.getMessage());
        }
        return null;
    }


    public void excluir(int id){
        Livro liv = consultar(id);
        String sql = "DELETE FROM livro WHERE id_livro = ?";  
        
        try {
            if (liv.getId() == id){
                PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
                pst.setInt(1, id);
                
                System.out.println("Livro excluido com sucesso");
                pst.execute();
            }else{
                System.out.println(id + " não está cadastrado");
            }
        } catch (Exception e) {
            System.out.println("Falha na consulta livro: "+ e.getMessage());
        }
        
    }


    public void alterar(Livro livro, int id){
        String sql = "UPDATE livro SET titulo = ?, autor = ?, ano = ? WHERE id_livro = ?";
        try{
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getAutor());
            pst.setInt(3, livro.getAnoPublicacao());
            pst.setInt(4, id);
            pst.execute();

            System.out.println("Livro atualizado com sucesso.");
        } catch (Exception e) {
            System.out.println("Falha na consulta do livro: "+ e.getMessage());
        }
    }
}
