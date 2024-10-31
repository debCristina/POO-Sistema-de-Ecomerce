package util;

import java.sql.Connection;
import java.sql.DriverManager;

//Classe que estabelece conexao com o banco de dados
// Responsável pelos comentarios da classe: Débora Cristina
public class ConexaoUtil {
    // Configurações de conexão
    private String caminho = "localhost"; //endereco do servidor do banco de dados
    private String porta = "3306"; //porta do mysql
    private String nomeBancoDeDados = "db_loja"; //nome do banco de dados
    private String usuario = "root"; //nome de usuario do banco de dados
    private String senha = System.getenv("DB_MYSQL_PASSWORD"); //senha do banco de dados, obtida através de variavel de ambiente para segurança

    //URL de conexão
    private String url = "jdbc:mysql://"+caminho+":"+porta+"/"+nomeBancoDeDados+"?serverTimezone=UTC&useSSL=false";

    //Metodo para obter a conexão com o banco de dados
    public Connection getConexao () {
        try {
            //Estabelece a conexao carregando o driver do jdbc com informacoes de url, usuario e senha
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            return conn; //retorno da conexao
        }catch (Exception e){
            //Em caso de erro é exibido uma mensagem
            System.out.println("Erro ao conectar-se com o banco de dados" +e.getMessage());
            return null; //retorno nulo para falta de conexao
        }
    }
}
