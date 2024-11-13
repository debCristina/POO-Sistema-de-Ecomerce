package model;

import java.sql.Date; // Importa a classe Date do pacote java.sql para representar datas.

/**
 * A classe Cliente contém os atributos e métodos que representam um cliente no sistema.
 * Fornece métodos para acessar e modificar as propriedades de um cliente, como ID, nome, email, telefone e data de cadastro.
 *
 * @author Filipe S.
 * @since 1.0
 */
public class Cliente {
    private int idCliente;          // Identificador único do cliente.
    private String nome;            // Nome do cliente.
    private String email;           // Email do cliente.
    private String telefone;        // Telefone do cliente.
    private String dataCadastro;    // Data de cadastro do cliente no sistema.

    // Construtor padrão para criar um objeto Cliente.
    public Cliente() {
    }

    // Retorna o ID do cliente.
    public int getIdCliente() {
        return idCliente;
    }

    // Define o ID do cliente.
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Retorna o nome do cliente.
    public String getNome() {
        return nome;
    }

    // Define o nome do cliente.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o email do cliente.
    public String getEmail() {
        return email;
    }

    // Define o email do cliente.
    public void setEmail(String email) {
        this.email = email;
    }

    // Retorna o telefone do cliente.
    public String getTelefone() {
        return telefone;
    }

    // Define o telefone do cliente.
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Retorna a data de cadastro do cliente.
    public String getDataCadastro() {
        return dataCadastro;
    }

    // Define a data de cadastro do cliente.
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
