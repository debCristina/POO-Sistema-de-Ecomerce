package menu;

import dao.ClienteDAO;
import model.Cliente;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por exibir e gerenciar o menu de operações para Cliente.
 * 
 * @author Wictor Emanoel
 * @version 1.0
 * @since 13/11/2024
 */
public class MenuCliente {

    /**
     * Método de exibição do menu.
     * Este método apresenta ao usuário as opções disponíveis para gerenciar clientes.
     */
    public void menuCliente() {
        Cliente cliente = new Cliente(); // Cria um objeto Cliente que representa os dados do Cliente
        ClienteDAO clienteDAO = new ClienteDAO(); // Cria um objeto ClienteDAO para operações do banco de dados
        Scanner scanner = new Scanner(System.in); // Cria um objeto da classe Scanner para entrada de dados do usuário
        int opcaoUsuario = 0; // Declaração da variável de opção do usuário no menu

        // Loop que exibe o menu e chama os métodos CRUD até que o usuário deseje sair
        do {
            System.out.println("""
                ---- Cliente ----
                [1] Cadastrar cliente
                [2] Listar clientes
                [3] Atualizar cliente
                [4] Remover cliente
                [0] Sair
                """);
            System.out.println("Opção: ");
            opcaoUsuario = scanner.nextInt(); // Lê a opção do usuário
            scanner.nextLine(); // Limpa o buffer de entrada

            // Executa a operação escolhida pelo usuário
            switch (opcaoUsuario) {
                case 1:
                    cadastrarCliente(scanner, cliente, clienteDAO); // Chama o método para cadastrar um novo cliente
                    break;
                case 2:
                    listarClientes(clienteDAO); // Chama o método listar clientes
                    break;
                case 3:
                    atualizarCliente(scanner, clienteDAO); // Chama o método atualizar cliente
                    break;
                case 4:
                    deletarCliente(scanner, clienteDAO); // Chama o método deletar cliente
                    break;
                case 0:
                    System.out.println("Saindo..."); // Encerra o loop
                    break;
                default:
                    System.out.println("Opção inválida"); // Informa opção inválida se a opção digitada pelo usuário não corresponder a nenhuma das opções disponíveis
            }
        } while (opcaoUsuario != 0); // Continua o loop enquanto a opção do usuário for diferente de 0
    }

    /**
     * Método que cria um novo cliente.
     * 
     * @param scanner Objeto Scanner para entrada de dados do usuário.
     * @param cliente Objeto Cliente que representa os dados do cliente.
     * @param clienteDAO Objeto ClienteDAO para operações do banco de dados.
     */
    private void cadastrarCliente(Scanner scanner, Cliente cliente, ClienteDAO clienteDAO) {
        System.out.println("---- Cadastro Cliente ----");
        System.out.println("Nome do cliente: ");
        cliente.setNome(scanner.nextLine()); // Define o nome do cliente
        System.out.println("Email do cliente: ");
        cliente.setEmail(scanner.nextLine()); // Define o email do cliente
        System.out.println("Telefone do cliente (Apenas números): ");
        cliente.setTelefone(scanner.nextLine()); // Define o telefone do cliente

        // Valida a data de cadastro do usuário para o formato yyyy-mm-dd
        System.out.println("Data cadastro (yyyy-mm-dd):");
        String dataCadastro = scanner.nextLine();
        if (!dataCadastro.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            System.out.println("Data inválida. Verifique o formato (yyyy-MM-dd) e tente novamente.");
            return; // Encerra o cadastro se a data for inválida
        }
        cliente.setDataCadastro(dataCadastro); // Define a data de cadastro
        clienteDAO.inserir(cliente); // Chama o método da classe ClienteDAO para inserir o cliente no banco de dados
    }

    /**
     * Método para buscar e exibir um cliente pelo ID.
     * 
     * @param clienteDAO Objeto ClienteDAO para operações do banco de dados.
     * @param scanner Objeto Scanner para entrada de dados do usuário.
     */
    private void buscarCliente(ClienteDAO clienteDAO, Scanner scanner) {
        System.out.println("Id para busca: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = clienteDAO.buscarPorId(idCliente); // Chama o método buscarPorId para buscar o cliente no banco de dados

        // Exibe as informações do cliente
        System.out.printf("""
            Id: %d
            Nome: %s
            Email: %s
            Telefone: %s
            Data de cadastro: %s
            """, cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getDataCadastro());
    }

    /**
     * Método para listar todos os clientes cadastrados.
     * 
     * @param clienteDAO Objeto ClienteDAO para operações do banco de dados.
     */
    private void listarClientes(ClienteDAO clienteDAO) {
        List<Cliente> clientes = clienteDAO.listar(); // Chama o método da classe ClienteDAO que retorna uma lista de clientes do banco de dados

        // Itera sobre cada cliente da lista e exibe suas informações
        for (Cliente cliente : clientes) {
            System.out.printf("""
                Id: %d
                Nome: %s
                Email: %s
                Telefone: %s
                Data de cadastro: %s
                """, cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getDataCadastro());
        }
    }

    /**
     * Método para atualizar os dados de um cliente.
     * 
     * @param scanner Objeto Scanner para entrada de dados do usuário.
     * @param clienteDAO Objeto ClienteDAO para operações do banco de dados.
     */
    private void atualizarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        System.out.println("Id para atualização: ");
        int idCliente = scanner.nextInt(); // Recebe o ID para atualização
        scanner.nextLine(); // Limpa o buffer
        Cliente clienteAtualizar = clienteDAO.buscarPorId(idCliente); // Chama o método buscar para encontrar o cliente com o ID informado

        // Verifica se o cliente existe no banco de dados
        if (clienteAtualizar == null) {
            System.out.println("Cliente não encontrado");
        } else {
            // Se o cliente existir, recebe os dados para atualização
            System.out.println("---- Atualização de cliente ----");
            System.out.println("Novo nome do cliente: ");
            clienteAtualizar.setNome(scanner.nextLine()); // Atualiza o nome
            System.out.println("Novo e-mail do cliente: ");
            clienteAtualizar.setEmail(scanner.nextLine()); // Atualiza o email
            System.out.println("Novo telefone do cliente: ");
            clienteAtualizar.setTelefone(scanner.nextLine()); // Atualiza o telefone
            clienteDAO.atualizar(clienteAtualizar); // Chama o método para salvar as atualizações no banco de dados
        }
    }

    /**
     * Método para deletar um cliente do banco de dados.
     * 
     * @param scanner Objeto Scanner para entrada de dados do usuário.
     * @param clienteDAO Objeto ClienteDAO para operações do banco de dados.
     */
    private void deletarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        System.out.println("Id para remoção: ");
        int idCliente = scanner.nextInt(); // Recebe um ID para remoção
        Cliente clienteDeletar = clienteDAO.buscarPorId(idCliente); // Utiliza o método buscarPorId para encontrar o cliente

        // Verifica se o cliente existe
        if (clienteDeletar == null) {
            System.out.println("Cliente não encontrado");
        } else {
            clienteDAO.remover(idCliente); // Chama o método para remover o cliente do banco de dados
        }
    }
}
