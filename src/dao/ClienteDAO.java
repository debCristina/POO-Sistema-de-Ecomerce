package dao;

import model.Cliente;
import util.ConexaoUtil;

import java.sql.*;  // Importa classes para manipulação de SQL (Conexões, instruções e ResultSet)
import java.util.ArrayList;  // Importa a classe ArrayList para armazenar uma lista dinâmica de clientes
import java.util.List;  // Importa a interface List para facilitar a manipulação de listas genericas

/**
 * Classe responsável pela persistência de dados relacionados ao cliente.
 * Contém métodos para inserir, listar, atualizar e remover clientes.
 * 
 * @author Vinicios Trindade Costa
 * @version 1.0
 * @since 13/11/2024
 */

public class ClienteDAO {
    private ConexaoUtil conexao;  // Instância para manipular a conexão com o banco de dados
    private Connection conn;  // Representa a conexão ativa com o banco de dados

    /**
     * Construtor da classe ClienteDAO.
     * Estabelece a conexão com o banco de dados.
     * 
     * @throws SQLException Se houver problemas na conexão com o banco de dados.
     */
    public ClienteDAO() throws SQLException {
        this.conexao = new ConexaoUtil();  // Cria uma nova instância de ConexaoUtil para obter a conexão
        this.conn = this.conexao.getConexao();  // Obtém a conexão ativa com o banco de dados
    }

    /**
     * Insere um novo cliente no banco de dados.
     * 
     * @param cliente O cliente a ser inserido.
     * @throws SQLException Se ocorrer um erro durante a inserção no banco de dados.
     */
    public void inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, email, telefone, data_cadastro) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {  // Preparação da instrução SQL para inserção
            stmt.setString(1, cliente.getNome());  // Atribui o nome do cliente
            stmt.setString(2, cliente.getEmail());  // Atribui o email do cliente
            stmt.setString(3, cliente.getTelefone());  // Atribui o telefone do cliente
            stmt.setString(4, cliente.getDataCadastro());  // Atribui a data de cadastro do cliente
            stmt.execute();  // Executa a instrução SQL para inserção do cliente
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir cliente: " + e.getMessage(), e);
        }
    }

    /**
     * Retorna a lista de todos os clientes cadastrados.
     * 
     * @return Lista de clientes.
     * @throws SQLException Se ocorrer um erro durante a consulta ao banco de dados.
     */
    public List<Cliente> listar() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();  // Cria uma lista para armazenar os clientes
        String sql = "SELECT * FROM clientes";  // Consulta SQL para pegar todos os clientes
        
        try (Statement stmt = conn.createStatement();  // Cria um Statement para executar a consulta
             ResultSet rs = stmt.executeQuery(sql)) {  // Executa a consulta SQL e obtém o resultado
            while (rs.next()) {  // Itera sobre o ResultSet retornado pela consulta
                Cliente cliente = new Cliente();  // Cria um novo objeto Cliente
                cliente.setIdCliente(rs.getInt("cliente_id"));  // Atribui o ID do cliente
                cliente.setNome(rs.getString("nome"));  // Atribui o nome do cliente
                cliente.setEmail(rs.getString("email"));  // Atribui o email do cliente
                cliente.setTelefone(rs.getString("telefone"));  // Atribui o telefone do cliente
                cliente.setDataCadastro(rs.getString("data_cadastro"));  // Atribui a data de cadastro
                clientes.add(cliente);  // Adiciona o cliente à lista
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar clientes: " + e.getMessage(), e);
        }
        return clientes;  // Retorna a lista de clientes
    }

    /**
     * Atualiza os dados de um cliente no banco de dados.
     * 
     * @param cliente O cliente com os dados atualizados.
     * @throws SQLException Se ocorrer um erro durante a atualização dos dados.
     */
    public void atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE cliente_id = ?";  // Comando SQL para atualizar cliente
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {  // Prepara a instrução SQL
            stmt.setString(1, cliente.getNome());  // Atribui o novo nome
            stmt.setString(2, cliente.getEmail());  // Atribui o novo email
            stmt.setString(3, cliente.getTelefone());  // Atribui o novo telefone
            stmt.setInt(4, cliente.getIdCliente());  // Atribui o ID do cliente a ser atualizado
            stmt.executeUpdate();  // Executa a atualização
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar cliente: " + e.getMessage(), e);
        }
    }

    /**
     * Remove um cliente do banco de dados com base no seu ID.
     * 
     * @param idCliente O ID do cliente a ser removido.
     * @throws SQLException Se ocorrer um erro durante a remoção do cliente.
     */
    public void remover(int idCliente) throws SQLException {
        String sql = "DELETE FROM clientes WHERE cliente_id = ?";  // Comando SQL para remover o cliente
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {  // Prepara a instrução SQL para deletar
            stmt.setInt(1, idCliente);  // Define o ID do cliente a ser removido
            stmt.execute();  // Executa a instrução de remoção
        } catch (SQLException e) {
            throw new SQLException("Erro ao remover cliente: " + e.getMessage(), e);
        }
    }

    /**
     * Busca um cliente pelo seu ID.
     * 
     * @param idCliente O ID do cliente a ser buscado.
     * @return O cliente encontrado ou null se não encontrar.
     * @throws SQLException Se ocorrer um erro durante a consulta ao banco de dados.
     */
    public Cliente buscarPorId(int idCliente) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE cliente_id = ?";  // Comando SQL para buscar um cliente
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {  // Prepara a instrução SQL para consulta
            stmt.setInt(1, idCliente);  // Define o ID do cliente a ser buscado
            ResultSet rs = stmt.executeQuery();  // Executa a consulta
            
            if (rs.next()) {  // Verifica se algum cliente foi encontrado
                Cliente cliente = new Cliente();  // Cria um novo cliente
                cliente.setIdCliente(rs.getInt("cliente_id"));  // Atribui o ID do cliente
                cliente.setNome(rs.getString("nome"));  // Atribui o nome do cliente
                cliente.setEmail(rs.getString("email"));  // Atribui o email do cliente
                cliente.setTelefone(rs.getString("telefone"));  // Atribui o telefone do cliente
                cliente.setDataCadastro(rs.getString("data_cadastro"));  // Atribui a data de cadastro
                return cliente;  // Retorna o cliente encontrado
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar cliente: " + e.getMessage(), e);
        }
        return null;  // Retorna null se nenhum cliente for encontrado
    }
}
