package View;


import Model.Usuario;
import Util.BancoUtils;
import java.util.Scanner;
import controller.UsuarioController;
import java.util.List;


/**
 * MVC: CONCEITO DE PADRÃO DE ARQUITETURA MODEL - RECEBE AS INFORMAÇÕES, DADOS E
 * A LÓGICA DO CÓDIGO VIEW - ONDE O USUÁRIO VÊ E INTERAGE CONTROLLER -
 * INTERMEDIÁRIO ENTRE VIEW E MODEL
 *
 *
 *
 *
 * @author admin
 */
public class Main { // CREATE READ UPDATE DELETE

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioController userController = new UsuarioController();

        BancoUtils.criarTabelaUsuarios(); // começar criando a tabela usuários
        
        int op = -1;
        while (op != 0) {
            System.out.println(" # MENU CRUD DE USUÁRIOS # ");
            System.out.println("1. Inserir Usuário");
            System.out.println("2. Atualizar Usuário");
            System.out.println("3. Deletar Usuário");
            System.out.println("4. Consultar Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeInserir = sc.nextLine();
                    System.out.print("Email: ");
                    String emailInserir = sc.nextLine();
                    userController.adicionarUsuario(nomeInserir, emailInserir);
                    break;
                case 2:
                    System.out.println("Nome do usuário para atualizar: ");
                    String nomeAtualizar = sc.nextLine();
                    System.out.println("Novo email: ");
                    String novoEmail = sc.nextLine();
                    userController.atualizarUsuario(nomeAtualizar,novoEmail);
                    break;
                case 3:
                    System.out.println("Nome do usuário para deletar: ");
                    String nomeDeletar = sc.nextLine();
                    userController.deletarUsuario(nomeDeletar);
                    break;
                case 4:
                    List<Usuario>usuarios = userController.listarUsuarios();
                    if (usuarios.isEmpty()) { // a lista de usuarios está vazia
                        System.out.println("Nenhum usuário cadastrado!");
                    } else {
                        System.out.println(" - Lista de Usuários - ");
                        for (Usuario u : usuarios) {
                            System.out.println(u);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa . . .");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}