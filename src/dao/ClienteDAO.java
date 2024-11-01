// Este código foi comentado por Vinicios Trindade Costa para facilitar a compreensão das operações realizadas na classe ClienteDAO.
package dao;

import model.Cliente;
import util.ConexaoUtil;

import java.sql.*; // Importa classes para manipulação de SQL
import java.util.ArrayList; // Importa a classe ArrayList para criar listas dinâmicas
import java.util.List; // Importa a interface List para manipulação de listas

// Classe que gerencia as operações de acesso a dados da tabela Cliente
public class ClienteDAO {
    private ConexaoUtil conexao;
    private Connection conn;

    public ClienteDAO() {
        this.conexao = new ConexaoUtil();
        this.conn = this.conexao.getConexao();
    }

    // Método para cadastrar um novo cliente (Create)
    public void inserir(Cliente cliente) {
        // Define a instrução SQL para inserir um novo cliente na tabela
        String sql = "INSERT INTO clientes (nome, email, telefone, data_cadastro) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL
            // Define os valores dos parâmetros na instrução SQL
            stmt.setString(1, cliente.getNome()); // Atribui o nome do cliente
            stmt.setString(2, cliente.getEmail()); // Atribui o email do cliente
            stmt.setString(3, cliente.getTelefone()); // Atribui o telefone do cliente
            stmt.setString(4, cliente.getDataCadastro()); // Atribui a data de cadastro do cliente
            stmt.execute(); // Executa a instrução SQL para inserir o cliente
            System.out.println("Cliente inserido com sucesso."); // Confirma a inserção
        } catch (SQLException e) {
            // Em caso de erro ao inserir, imprime a mensagem de erro
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    // Método para listar todos os clientes (Read)
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>(); // Cria uma lista para armazenar os clientes
        String sql = "SELECT * FROM clientes"; // Define a instrução SQL para selecionar todos os clientes
        try (Statement stmt = conn.createStatement(); // Cria um Statement para executar a consulta
             ResultSet rs = stmt.executeQuery(sql)) { // Executa a consulta e armazena o resultado
            // Percorre o ResultSet e cria objetos Cliente para cada linha
            while (rs.next()) {
                Cliente cliente = new Cliente(); // Cria um novo objeto Cliente
                cliente.setIdCliente(rs.getInt("cliente_id")); // Atribui o ID do cliente
                cliente.setNome(rs.getString("nome")); // Atribui o nome do cliente
                cliente.setEmail(rs.getString("email")); // Atribui o email do cliente
                cliente.setTelefone(rs.getString("telefone")); // Atribui o telefone do cliente
                cliente.setDataCadastro(rs.getString("data_cadastro")); // Atribui a data de cadastro do cliente
                clientes.add(cliente); // Adiciona o cliente à lista
            }
        } catch (SQLException e) {
            // Em caso de erro ao listar, imprime a mensagem de erro
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes; // Retorna a lista de clientes
    }

    // Método para atualizar dados de um cliente (Update)
    public void atualizar(Cliente cliente) {
        // Define a instrução SQL para atualizar os dados de um cliente
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE cliente_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL
            // Define os valores dos parâmetros na instrução SQL
            stmt.setString(1, cliente.getNome()); // Atribui o novo nome do cliente
            stmt.setString(2, cliente.getEmail()); // Atribui o novo email do cliente
            stmt.setString(3, cliente.getTelefone()); // Atribui o novo telefone do cliente
            stmt.setInt(4, cliente.getIdCliente()); // Atribui o ID do cliente a ser atualizado
            stmt.executeUpdate(); // Executa a instrução SQL para atualizar o cliente
            System.out.println("Cliente atualizado com sucesso."); // Confirma a atualização
        } catch (SQLException e) {
            // Em caso de erro ao atualizar, imprime a mensagem de erro
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // Método para excluir um cliente (Delete)
    public void remover(int idCliente) {
        // Define a instrução SQL para deletar um cliente com base no seu ID
        String sql = "DELETE FROM clientes WHERE cliente_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL
            stmt.setInt(1, idCliente); // Define o ID do cliente a ser removido
            stmt.execute(); // Executa a instrução SQL para remover o cliente
            System.out.println("Cliente removido com sucesso."); // Confirma a remoção
        } catch (SQLException e) {
            // Em caso de erro ao remover, imprime a mensagem de erro
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }

    // Método para buscar um cliente específico pelo ID
    public Cliente buscarPorId(int idCliente) {
        // Define a instrução SQL para selecionar um cliente específico pelo ID
        String sql = "SELECT * FROM clientes WHERE cliente_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL
            stmt.setInt(1, idCliente); // Define o ID do cliente a ser buscado
            ResultSet rs = stmt.executeQuery(); // Executa a consulta e armazena o resultado
            if (rs.next()) { // Verifica se algum cliente foi encontrado
                Cliente cliente = new Cliente(); // Cria um novo objeto Cliente
                cliente.setIdCliente(rs.getInt("cliente_id")); // Atribui o ID do cliente
                cliente.setNome(rs.getString("nome")); // Atribui o nome do cliente
                cliente.setEmail(rs.getString("email")); // Atribui o email do cliente
                cliente.setTelefone(rs.getString("telefone")); // Atribui o telefone do cliente
                cliente.setDataCadastro(rs.getString("data_cadastro")); // Atribui a data de cadastro do cliente
                return cliente; // Retorna o cliente encontrado
            }
        } catch (SQLException e) {
            // Em caso de erro ao buscar, imprime a mensagem de erro
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }
        return null; // Retorna null se nenhum cliente for encontrado
    }
}
