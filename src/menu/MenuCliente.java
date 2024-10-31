package menu;
import dao.ClienteDAO;
import model.Cliente;
import java.util.List;
import java.util.Scanner;

// Classe responsável por exibir e gerenciar o menu de operações para Cliente
public  class  MenuCliente{
    //Metodo de exibicao do menu
    public void menuCliente() {

        //Criando um objeto Cliente que representa os dados do Cliente
        Cliente cliente = new Cliente();
        //Criando um objeto ClienteDAO para operacoes do banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        //Criando um objeto da classe Scannerpara entrada de dados do usuario
        Scanner scanner = new Scanner(System.in);
        //declaracao da variavel de opcao do usuario no menu
        int opcaoUsuario = 0;

        //Loop que exibe o menu e chama os metodos crud até que o usuário deseje sair
        do {
            //exibe o menu de opcoes
            System.out.println("""
                    ---- Cliente ----
                    [1] Cadastrar cliente
                    [2] Listar clientes
                    [3] Atualizar cliente
                    [4] Remover cliente
                    [0] Sair""");

            System.out.println("Opcao: ");
            opcaoUsuario = scanner.nextInt(); // Lê a opcao do usuario
            scanner.nextLine(); //limpa o buffer de entrada

            //executa a operacao escolhida pelo usuario
            switch (opcaoUsuario) {
                case 1:
                    //chamda do metodo para cadastrar um novo cliente
                    cadastrarCliente(scanner, cliente, clienteDAO);
                    break;
                case 2:
                    //chamada do metodo listar clientes
                    listarClientes(clienteDAO);
                    break;
                case 3:
                    // chama o metodo atualizar cliente
                    atualizarCliente(scanner, clienteDAO);
                    break;
                case 4:
                    //chama o metodo deletar cliente
                    deletarCliente(scanner, clienteDAO);
                    break;
                case 0:
                    //encerra o loop
                    System.out.println("Saindo...");
                    break;
                default:
                    //informa opcao invalida se a opcao digitada pelo usuario nao corresponder a nenhuma das opcoes disponiveis
                    System.out.println("Opção inválida");
            }

        } while (opcaoUsuario != 0); // continua o loop enquanto a opcao do usuario for diferente de 0
    }

    //metodo que cria um novo cliente
    private void cadastrarCliente(Scanner scanner, Cliente cliente, ClienteDAO clienteDAO ) {
        System.out.println("---- Cadastro Cliente ----");
        System.out.println("Nome do cliente: ");
        cliente.setNome(scanner.nextLine()); //define o nome do cliente

        System.out.println("Email do cliente: ");
        cliente.setEmail(scanner.nextLine()); //define o email do cliente

        System.out.println("Telefone do cliente (Apenas números): ");
        cliente.setTelefone(scanner.nextLine()); //define o telefone do cliente

        //valida a data de cadastro do usuario para o formato yyyy-mm-dd
        System.out.println("Data cadastro (yyyy-mm-dd):");
        String dataCadastro = scanner.nextLine();
        if (!dataCadastro.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            System.out.println("Data inválida. Verifique o formato (yyyy-MM-dd) e tente novamente.");
            return; // encerra o cadastro de a data for invalida
        }
        cliente.setDataCadastro(dataCadastro); // define a data de cadastro
        clienteDAO.inserir(cliente); //chama o metodo da classe clienteDAO para insere o cliente no banco de dados
    }

    //Metodo para buscar e exibir um cliente pelo id
    private void buscarCliente(ClienteDAO clienteDAO, Scanner scanner) {
        System.out.println("Id para busca: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = clienteDAO.buscarPorId(idCliente); //chama o metodo buscaPorId para buscar o cliente no banco de dados
        //exibe as informacoes do cliente
        System.out.printf("""
                        Id: %d
                        Nome: %s
                        Email: %s
                        Telefone: %s
                        Data de cadastro: %s
                        """, cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(),cliente.getTelefone(), cliente.getDataCadastro());
    }

    //metodo para listar todos os clientes cadastrados
    private void listarClientes(ClienteDAO clienteDAO) {
        List<Cliente> clientes = clienteDAO.listar(); //chama o metodo da classe ClienteDAO que retorna uma lista de clientes do banco de dados
        //itera sobre cada cliente da lista e exibe suas informacoes
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

    //metodo para atualizar os dados de um cliente
    private void atualizarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        System.out.println("Id para atualização: ");
        int idCliente = scanner.nextInt(); //recebe o id para atualizacao
        scanner.nextLine(); //limpa o buffer

        Cliente clienteAtualizar = clienteDAO.buscarPorId(idCliente); //chama o metodo buscar para encontrar o cliente com o id informado

        //verifica se o cliente existe no banco de dados
        if (clienteAtualizar == null) {
            System.out.println("Cliente não encontrado");
        } else {
            //se o cliente existir recebe os dados para atualizacao
            System.out.println("---- Atualização de cliente ----");
            System.out.println("Novo nome do cliente: ");
            clienteAtualizar.setNome(scanner.nextLine()); // atualiza o nome

            System.out.println("Novo e-mail do cliente: ");
            clienteAtualizar.setEmail(scanner.nextLine()); // atuaiza o email

            System.out.println("Novo telefone do cliente: ");
            clienteAtualizar.setTelefone(scanner.nextLine()); // atualiza o telefone

            clienteDAO.atualizar(clienteAtualizar); //chama o metodo para salvar as atualizacoes no banco de dados
        }
    }

    //metodo para deletar um cliente do banco de dados
    private void deletarCliente(Scanner scanner,ClienteDAO clienteDAO) {
        System.out.println("Id para remoção: ");
        int idCliente = scanner.nextInt(); //recebe um id para remocao

        Cliente clienteDeletar = clienteDAO.buscarPorId(idCliente); //uutiliza o metodo buscaPorId para encontrar o cliente
        //verifica o se o cliente existe
        if (clienteDeletar == null) {
            System.out.println("Cliente não encontrado");
        } else{
            clienteDAO.remover(idCliente); // chama o metodo para remover o cliente do banco de dados
        }
    }
}

