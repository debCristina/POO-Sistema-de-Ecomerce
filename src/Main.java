import menu.MenuCliente; // Importa a classe MenuCliente do pacote menu.
import java.util.Scanner; //Importa a classe Scanner para leitura da entrada de dados do usuário.

/**
 * A classe Main é responsável por inicializar o sistema de gestão do E-comerce.
 * Esta classe apresenta ao usuário o menu principal e permite gerenciar os clientes ou sair do programa.
 *
 * @author Samantha Yumi
 * @since 1.0
*/
    
public class Main {
    
    /**
    * Método principal que apresentará ao usuário um menu de opções e executará as ações conforme sua escolha.
    *
    * @param args Argumento da linha de comando
    */
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Scanner para leitura da escolha do usuário
        int opcaoUsuario = 0; //Variável que armazena a opção escolhida.
        
        // A estrutura de repetição do... while realizará um loop para exibir o menu de opções do usuário ate que a opção seja sair. 
        do{
            System.out.println("""
                    ---- Sistema de Gestão ----
                    [1] Gerenciar Clientes
                    [0] Sair""");
            System.out.print("Escolha uma opção: ");
            opcaoUsuario = scanner.nextInt(); // Lê a opção escolhida.
        
            // A estrutura de decisão switch verifica a opção escolhida.
            switch (opcaoUsuario) {

                // Cria um objeto da classe menu e chama o método que motra as operações de gerenciamento de clientes.
                case 1:
                    MenuCliente menuCliente = new MenuCliente(); 
                    menuCliente.menuCliente(); 
                    break;
                    
                // Encerra o programa caso a opcao seja 0
                case 0:
                    System.out.println("Saindo...");
                    break;

                // Informa ao usuário que a opção é inválida 
                default: 
                    System.out.println("Opção inválida");
                    break;
            }
        } while(opcaoUsuario != 0); // Continua o programa até o usuário escolher finalizar. 
    }
}
