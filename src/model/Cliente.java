//COMENTADO POR FILIPE S.

package model;

import java.sql.Date;

public class Cliente {
    private int idCliente;          // Identificador único do cliente
    private String nome;            // Nome do cliente
    private String email;           // Email do cliente
    private String telefone;        // Telefone do cliente
    private String dataCadastro;    // Data em que o cliente foi cadastrado

    // Construtor vazio
    public Cliente() {
    }

    // Método getter para obter o ID do cliente
    public int getIdCliente() {
        return idCliente;
    }

    // Método setter para modificar o ID do cliente
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Método getter para obter o nome do cliente
    public String getNome() {
        return nome;
    }

    // Método setter para modificar o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para obter o email do cliente
    public String getEmail() {
        return email;
    }

    // Método setter para modificar o email do cliente
    public void setEmail(String email) {
        this.email = email;
    }

    // Método getter para obter o telefone do cliente
    public String getTelefone() {
        return telefone;
    }

    // Método setter para modificar o telefone do cliente
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método getter para obter a data de cadastro do cliente
    public String getDataCadastro() {
        return dataCadastro;
    }

    // Método setter para modificar a data de cadastro do cliente
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
