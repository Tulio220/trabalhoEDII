import java.util.LinkedList;
import java.util.Scanner;

public class MainDB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca bib = new Biblioteca();
        Biblioteca user = new Biblioteca();
        LivroDAO objDAO = new LivroDAO();
        UsuarioDao userDao = new UsuarioDao();
         
        while (true) { 
            System.out.println("-----MENU-----");
            System.out.println("1- Cadastro de livros:");
            System.out.println("2- Cadastro de usuários:");
            System.out.println("0- Sair:");
            System.out.println("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if(opcao == 1){
                System.out.println("-----MENU-----");
                System.out.println("1- Inserir Livro:");
                System.out.println("2- Busca livro por ID:");
                System.out.println("3- Remover livro por ID:");
                System.out.println("4- Listar livros:");
                System.out.println("0- Menu anterior:");
                int opcao2 = scanner.nextInt();
                scanner.nextLine();

                if (opcao2 == 1){
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o ano de publicação do livro:");
                    int ano = scanner.nextInt();

                    Livro livro = new Livro(titulo);
                    livro.setAutor(autor);
                    livro.setAnoPublicacao(ano);

                    objDAO.inserir(livro);

                }else if (opcao2 == 2){
                    System.out.println("Digite o ID do livro que deseja buscar:");
                    int id = scanner.nextInt();
                    
                    System.out.println(objDAO.consultar(id));
                    

                }else if (opcao2 == 3){
                    System.out.println("Digite o ID do livro que deseja remover:");
                    int id = scanner.nextInt();

                    objDAO.excluir(id);

                }else if (opcao2 == 4){
                    LinkedList<Livro> dados = objDAO.consultarTodos();
                    int j = dados.size();
                    for (Livro valor : dados) {
                        System.out.println(valor);
                        
                    }
                    
                }else if (opcao2 == 0){
                    System.out.println("Retornando...");
                
                }else{
                    System.out.println("Opcao inválida. Tente novamente.");
                }
            }else if (opcao == 2){
                System.out.println("-----MENU-----");
                System.out.println("1- Inserir usuário:");
                System.out.println("2- Buscar usuário por ID:");
                System.out.println("3- Remover usuário por ID:");
                System.out.println("4- Listar usuários:");
                System.out.println("0- Menu anterior:");
                int opcao2 = scanner.nextInt();
                scanner.nextLine();

                if (opcao2 == 1){
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o e-mail do usuário:");
                    String email = scanner.nextLine();

                    Usuario usuario = new Usuario(nome);
                    usuario.setEmail(email);

                    userDao.inserirUsuario(usuario);

                }else if (opcao2 == 2){
                    System.out.println("Digite o ID do usuario que deseja buscar:");
                    int id = scanner.nextInt();
                    
                    System.out.println(userDao.consultarUsuario(id));
                    

                }else if (opcao2 == 3){
                    System.out.println("Digite o ID do usuário que deseja remover:");
                    int id = scanner.nextInt();

                    userDao.excluirUsuario(id);

                }else if (opcao2 == 4){
                    LinkedList<Usuario> dados = userDao.consultarTodosUsuarios();
                    int j = dados.size();
                    for (Usuario valor : dados) {
                        System.out.println(valor);
                        
                    }
                    
                }else if (opcao2 == 0){
                    System.out.println("Retornando...");
                
                }else{
                    System.out.println("Opcao inválida. Tente novamente.");
                }

            }else if  (opcao== 0){
                System.out.println("Saindo...");
                scanner.close();
                return;
            }else{
                System.out.println("Opçcão inválida, tente novamente.");
                }
        }
    }
}
