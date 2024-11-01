// Comentado por Samantha Yumi.

import menu.MenuCliente; // Importa a classe MenuCliente do pacote menu

import java.util.Scanner; //Importa a classe Scanner para leitura da entrada de dados do usuario.

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
            opcaoUsuario = scanner.nextInt(); // Lê a opção escolhida
            
            //verifica a opcao escolhida
            switch (opcaoUsuario) {
                case 1:
                    MenuCliente menuCliente = new MenuCliente(); // Cria um objeto da classe menu
                    menuCliente.menuCliente(); // Chama o metodo que mostra as operacoes de gerenciamento de clientes
                    break;
                case 0:
                    // Encerra o programa caso a opcao seja 0
                    System.out.println("Saindo...");
                    break;
                default: 
                    // Outras opcoes que nao estao no menu
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opcaoUsuario != 0);
    }

}
