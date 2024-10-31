import menu.MenuCliente;

import java.util.Scanner;

//Classe principal Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcaoUsuario = 0;
        // loop para exibir o menu de opcoes do usuario ate que a opcao seja sair
        do{
            System.out.println("""
                    ---- Sistema de Gestão ----
                    [1] Gerenciar Clientes
                    [0] Sair""");
            System.out.print("Escolha uma opção: ");
            opcaoUsuario = scanner.nextInt();
            //verifica a opcao escolhida
            switch (opcaoUsuario) {
                case 1:
                    MenuCliente menuCliente = new MenuCliente(); // cria um objeto da classe menu
                    menuCliente.menuCliente(); //exibe o menu de operacoes do cliente
                    break;
                case 0:
                    //encerra o programa caso a opcao seja 0
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opcaoUsuario != 0);
    }

}
