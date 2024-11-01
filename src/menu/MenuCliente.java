// COMENTADO POR WICTOR EMANOEL

package menu;
import dao.ClienteDAO;
import model.Cliente;
import java.util.List;
import java.util.Scanner;

// Classe responsável por exibir e gerenciar o menu de operações para Cliente
public  class  MenuCliente{
    // Método de exibicao do menu
    public void menuCliente() {

        // Criando um objeto Cliente que representa os dados do Cliente
        Cliente cliente = new Cliente();
        // Criando um objeto ClienteDAO para operacoes do banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        // Criando um objeto da classe Scannerpara entrada de dados do usuario
        Scanner scanner = new Scanner(System.in);
        // Declaracao da variavel de opcao do usuario no menu
        int opcaoUsuario = 0;

        // Loop que exibe o menu e chama os metodos crud até que o usuário deseje sair
        do {
            // Exibe o menu de opcoes
            System.out.println("""
                    ---- Cliente ----
                    [1] Cadastrar cliente
                    [2] Listar clientes
                    [3] Atualizar cliente
                    [4] Remover cliente
                    [0] Sair""");

            System.out.println("Opcao: ");
            opcaoUsuario = scanner.nextInt(); // Lê a opção do usuário
            scanner.nextLine(); // Limpa o buffer de entrada

            // Executa a operacao escolhida pelo usuario
            switch (opcaoUsuario) {
                case 1:
                    // Chamada do método para cadastrar um novo cliente
                    cadastrarCliente(scanner, cliente, clienteDAO);
                    break;
                case 2:
                    // Chamada do método listar clientes
                    listarClientes(clienteDAO);
                    break;
                case 3:
                    // chama o metodo atualizar cliente
                    atualizarCliente(scanner, clienteDAO);
                    break;
                case 4:
                    // Chama o metodo deletar cliente
                    deletarCliente(scanner, clienteDAO);
                    break;
                case 0:
                    // Encerra o loop
                    System.out.println("Saindo...");
                    break;
                default:
                    //Informa opcao invalida se a opcao digitada pelo usuario nao corresponder a nenhuma das opcoes disponiveis
                    System.out.println("Opção inválida");
            }

        } while (opcaoUsuario != 0); // Continua o loop enquanto a opção do usuário for diferente de 0
    }

    // Método que cria um novo cliente
    private void cadastrarCliente(Scanner scanner, Cliente cliente, ClienteDAO clienteDAO ) {
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
            return; // Encerra o cadastro de a data for invalida
        }
        cliente.setDataCadastro(dataCadastro); // Define a data de cadastro
        clienteDAO.inserir(cliente); // Chama o método da classe clienteDAO para insere o cliente no banco de dados
    }

    // Método para buscar e exibir um cliente pelo id
    private void buscarCliente(ClienteDAO clienteDAO, Scanner scanner) {
        System.out.println("Id para busca: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = clienteDAO.buscarPorId(idCliente); // Chama o metodo buscaPorId para buscar o cliente no banco de dados
        // Exibe as informações do cliente
        System.out.printf("""
                        Id: %d
                        Nome: %s
                        Email: %s
                        Telefone: %s
                        Data de cadastro: %s
                        """, cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(),cliente.getTelefone(), cliente.getDataCadastro());
    }

    // Método para listar todos os clientes cadastrados
    private void listarClientes(ClienteDAO clienteDAO) {
        List<Cliente> clientes = clienteDAO.listar(); // Chama o metodo da classe ClienteDAO que retorna uma lista de clientes do banco de dados
        // Itera sobre cada cliente da lista e exibe suas informacoes
        for(Cliente cliente : clientes) {
            System.out.printf("""
                                
                                Id: %d
                                Nome: %s
                                Email: %s
                                Telefone: %s
                                Data de cadastro: %s
                                """, cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(),cliente.getTelefone(), cliente.getDataCadastro());
        }
    }

    // Método para atualizar os dados de um cliente
    private void atualizarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        System.out.println("Id para atualização: ");
        int idCliente = scanner.nextInt(); // Recebe o id para atualização
        scanner.nextLine(); // Limpa o buffer

        Cliente clienteAtualizar = clienteDAO.buscarPorId(idCliente); //chama o metodo buscar para encontrar o cliente com o id informado

        // Verifica se o cliente existe no banco de dados
        if (clienteAtualizar == null) {
            System.out.println("Cliente não encontrado");
        } else {
            // Se o cliente existir, recebe os dados para atualização
            System.out.println("---- Atualização de cliente ----");
            System.out.println("Novo nome do cliente: ");
            clienteAtualizar.setNome(scanner.nextLine()); // Atualiza o nome

            System.out.println("Novo e-mail do cliente: ");
            clienteAtualizar.setEmail(scanner.nextLine()); // Atuaiza o email

            System.out.println("Novo telefone do cliente: ");
            clienteAtualizar.setTelefone(scanner.nextLine()); // Atualiza o telefone

            clienteDAO.atualizar(clienteAtualizar); // Chama o metodo para salvar as atualizacoes no banco de dados
        }
    }

    // Método para deletar um cliente do banco de dados
    private void deletarCliente(Scanner scanner,ClienteDAO clienteDAO) {
        System.out.println("Id para remoção: ");
        int idCliente = scanner.nextInt(); // Recebe um id para remocao

        Cliente clienteDeletar = clienteDAO.buscarPorId(idCliente); // Utiliza o metodo buscaPorId para encontrar o cliente
        // Verifica o se o cliente existe
        if (clienteDeletar == null) {
            System.out.println("Cliente não encontrado");
        } else{
            clienteDAO.remover(idCliente); // Chama o método para remover o cliente do banco de dados
        }
    }
}

