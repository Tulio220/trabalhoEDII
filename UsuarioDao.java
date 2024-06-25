import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
public class UsuarioDao{
    private ConectaDB conexao;

    public UsuarioDao(){
        conexao = new ConectaDB();
    }

    public void inserirUsuario(Usuario usuario){
        ConectaDB conexao = new ConectaDB();
        String sql = "INSERT INTO usuario (nome, email) values (?, ?)";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getEmail());
            pst.execute();
            System.out.println("Inserção ok: "+ usuario);
        } catch (Exception e) {
            System.out.println("Falha na inserção: "+ e.getMessage());
        }
    }


    public LinkedList<Usuario> consultarTodosUsuarios(){
        String sql = "SELECT * FROM usuario";
        LinkedList<Usuario> lista = new LinkedList<Usuario>();
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            ResultSet resultados = pst.executeQuery();
            while (resultados.next()){
                String nome = resultados.getString("nome");
                String email = resultados.getString("email");
                int id = resultados.getInt("id_usuario");
                Usuario obj = new Usuario(nome);
                obj.setEmail(email);
                obj.setId_Usuario(id);
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Falha na consulta usuario: "+ e.getMessage());
        }
        return null;
    }

    public Usuario consultarUsuario (int id){
       
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        Usuario lista = null;
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            //executar consulta
            pst.setInt(1, id);
            ResultSet resultados = pst.executeQuery();
            if (resultados.next()){ 
                String nome = resultados.getString("nome");
                String email = resultados.getString("email");
                

                Usuario usuario = new Usuario(nome);
                
                usuario.setEmail(email);
                usuario.setId_Usuario(id);
                return usuario;
            }else{
                System.out.println("Não possui registro com o ID "+ id);
            }

        } catch (Exception e) {
            System.out.println("Falha na consulta: "+ e.getMessage());
        }
        return null;
    }

    public void excluirUsuario(int id){
        Usuario us = consultarUsuario(id);
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";  
        
        try {
            if (us.getId_Usuario() == id){
                PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
                pst.setInt(1, id);
                
                System.out.println("Usuario excluido com sucesso");
                pst.execute();
            }else{
                System.out.println(id + " não está cadastrado");
            }
        } catch (Exception e) {
            System.out.println("Falha na consulta usuario: "+ e.getMessage());
        }
    }

    public void alterarUsuario(Usuario usuario, int id){
        String sql = "UPDATE usuario SET nome = ?, email = ?WHERE id_usuario = ?";
        try{
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getEmail());
            pst.setInt(3, id);
            pst.execute();

            System.out.println("Usuario atualizado com sucesso.");
        } catch (Exception e) {
            System.out.println("Falha na consulta do usuario: "+ e.getMessage());
        }
    }
}
