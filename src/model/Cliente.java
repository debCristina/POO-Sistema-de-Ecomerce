
package model;

import java.sql.Date; // Importa a classe Date do pacote java.sql para representar datas.

/**
 * A classe {@code Cliente} representa um cliente no sistema de gerenciamento.
 * Ela contém atributos essenciais que descrevem o cliente, como ID, nome, email, telefone e a data de cadastro.
 * Além disso, oferece métodos para acessar e modificar essas informações.
 * 
 * A classe utiliza tipos básicos e String para armazenar os dados do cliente, com métodos getters e setters
 * que seguem o padrão de encapsulamento da programação orientada a objetos.
 * 
 * @author Filipe S.
 * @version 1.0
 * @since 12/11/2024
 */
public class Cliente {
    private int idCliente;          // Identificador único do cliente no sistema.
    private String nome;            // Nome completo do cliente.
    private String email;           // Endereço de e-mail do cliente.
    private String telefone;        // Número de telefone do cliente.
    private String dataCadastro;    // Data em que o cliente foi registrado no sistema.

    /**
     * Construtor padrão que cria uma instância de {@code Cliente} sem valores predefinidos.
     * Esse construtor permite a criação de objetos Cliente vazios, que podem ser preenchidos posteriormente.
     */
    public Cliente() {
    }

    /**
     * Retorna o identificador único do cliente.
     * Este método é utilizado para recuperar o ID que é utilizado para distinguir
     * cada cliente de forma única dentro do sistema.
     * 
     * <p><b>Exemplo de uso:</b></p>
     * <pre>{@code
     * Cliente cliente = new Cliente();
     * int id = cliente.getIdCliente();
     * System.out.println("ID do cliente: " + id);
     * }</pre>
     * 
     * @return O identificador único do cliente. Retorna um valor inteiro que representa o ID.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Define o identificador único do cliente.
     * Este método permite que o ID do cliente seja atribuído ou alterado conforme necessário.
     * 
     * @param idCliente O identificador único que será associado ao cliente. 
     *                  Este valor deve ser único para cada cliente no sistema.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Retorna o nome completo do cliente.
     * Este método é utilizado para recuperar o nome do cliente registrado no sistema.
     * 
     * <p><b>Exemplo de uso:</b></p>
     * <pre>{@code
     * Cliente cliente = new Cliente();
     * String nome = cliente.getNome();
     * System.out.println("Nome do cliente: " + nome);
     * }</pre>
     * 
     * @return O nome completo do cliente. Retorna uma string contendo o nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome completo do cliente.
     * Este método permite que o nome do cliente seja atribuído ou alterado.
     * 
     * @param nome O nome completo que será associado ao cliente. 
     *             Este valor deve representar corretamente o nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o endereço de e-mail do cliente.
     * Este método é utilizado para recuperar o e-mail associado ao cliente.
     * 
     * <p><b>Exemplo de uso:</b></p>
     * <pre>{@code
     * Cliente cliente = new Cliente();
     * String email = cliente.getEmail();
     * System.out.println("Email do cliente: " + email);
     * }</pre>
     * 
     * @return O endereço de e-mail do cliente. Retorna uma string contendo o e-mail.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de e-mail do cliente.
     * Este método permite que o e-mail do cliente seja atribuído ou alterado.
     * 
     * @param email O novo endereço de e-mail que será associado ao cliente.
     *              Este valor deve ser uma string válida representando um e-mail.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o número de telefone do cliente.
     * Este método é utilizado para recuperar o telefone do cliente registrado no sistema.
     * 
     * <p><b>Exemplo de uso:</b></p>
     * <pre>{@code
     * Cliente cliente = new Cliente();
     * String telefone = cliente.getTelefone();
     * System.out.println("Telefone do cliente: " + telefone);
     * }</pre>
     * 
     * @return O número de telefone do cliente. Retorna uma string contendo o telefone.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o número de telefone do cliente.
     * Este método permite que o telefone do cliente seja atribuído ou alterado.
     * 
     * @param telefone O novo número de telefone que será associado ao cliente.
     *                 Este valor deve ser uma string válida representando um número de telefone.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna a data de cadastro do cliente no sistema.
     * Este método é utilizado para recuperar a data em que o cliente foi registrado no sistema.
     * 
     * <p><b>Exemplo de uso:</b></p>
     * <pre>{@code
     * Cliente cliente = new Cliente();
     * String dataCadastro = cliente.getDataCadastro();
     * System.out.println("Data de cadastro do cliente: " + dataCadastro);
     * }</pre>
     * 
     * @return A data de cadastro do cliente. Retorna uma string representando a data no formato "yyyy-MM-dd".
     */
    public String getDataCadastro() {
        return dataCadastro;
    }

    /**
     * Define a data de cadastro do cliente.
     * Este método permite que a data de cadastro do cliente seja atribuída ou alterada.
     * 
     * @param dataCadastro A nova data de cadastro do cliente. Este valor deve ser uma string 
     *                     representando a data no formato "yyyy-MM-dd".
     */
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
