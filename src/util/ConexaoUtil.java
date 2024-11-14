package util;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Responsável por gerenciar a conexão entre o banco de dados MySQL e a aplicação.
 * Ela encapsula as informações de configuração do banco de dados, como o servidor, porta, nome do banco de dados,
 *  usuário e senha, permitindo que essas configurações sejam facilmente alteradas para diferentes ambientes
 * <p></p>
 *
 * @author Débora Ferreira
 * @version 1.0
 * @since 31/11/2024
 */
public class ConexaoUtil {
    private String caminho = "localhost";
    private String porta = "3306";
    private String nomeBancoDeDados = "db_loja";
    private String usuario = "root";
    private String senha = System.getenv("DB_MYSQL_PASSWORD");
    private String url = "jdbc:mysql://"+caminho+":"+porta+"/"+nomeBancoDeDados+"?serverTimezone=UTC&useSSL=false";

    /**
     * Cria uma nova conexão com o banco de dados MySQL.
     * Este método tenta estabelecer uma conexão com o banco de dados através da classe DriverManager e o método getConnection utilizando informações como url, usuario e senha.
     *
     * <p><b>Exemplo de uso:</b></p>
     *   <pre>{@code
     *  ConexaoUtil conexaoUtil = new ConexaoUtil();
     *  Connection conn = conexaoUtil.getConexao();
     *  if (conn != null) {
     *      System.out.println("Conexão estabelecida com sucesso!");
     *  } else {
     *       System.out.println("Falha ao conectar-se ao banco de dados.");
     *  }
     *  }</pre>
     *
     * @return {@code Connection} representa a conexão com o banco de dados ou null caso ocorra algum erro
     */
    public Connection getConexao () {
        try {
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            return conn;
        }catch (Exception e){
            return null;
        }
    }
}
