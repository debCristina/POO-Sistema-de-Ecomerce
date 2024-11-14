<h1 align="center">Sistema de Ecomerce</h1>
<p align="center">
<img alt="Static Badge" src="https://img.shields.io/badge/Java-17-green">
<img alt="Static Badge" src="https://img.shields.io/badge/MySQL-8.0-blue">
<img alt="Static Badge" src="https://img.shields.io/badge/JDBC-8.0-blue">
<img alt="Static Badge" src="https://img.shields.io/badge/Status-Conclu%C3%ADdo-green">
</p>

## 📒 Documentação
A documentação do sistema está disponível no seguinte link: [Visualizar Documentação](https://debcristina.github.io/POO-Sistema-de-Ecomerce/)

## 🛍 Visão Geral

Bem-vindo ao *Sistema de Ecomerce*!  
Este é um sistema de integração com banco de dados MySQL que tem como objetivo o gerenciamento da tabela clientes no sistema.

## 🚀 Funcionalidades

### 👥 Gestão de Clientes
- Mantenha um registro completo dos clientes com a possibilidade de realizar operações de cadastro, atualização e remoção.

## 🛠 Tecnologias Utilizadas
- *Java*: Backend e operações de integração com o banco de dados.
- *MySQL*: Banco de dados relacional para armazenamento dos dados.
- *JDBC*: API para conexão e manipulação do banco de dados MySQL.
- *JavaDoc*: Usado para gerar a documentação do sistema.

## 💻 Como Executar o Projeto
1. Clone este repositório
   
 ```
bash
   git clone https://github.com/debCristina/POO-Sistema-de-Ecomerce.git
```   
3.  No arquivo `src/util/ConexaoUtil` configure com suas informações

   ```
    private String caminho = "localhost";
    private String porta = "3306";
    private String nomeBancoDeDados = "bd_loja";
    private String usuario = "root";
    private String senha = System.getenv("DB_MYSQL_PASSWORD");

   ```
   
- Configure o **caminho**, **porta de execução**, **nome do banco de dados**, **usuario* e a **variável de ambiente ${DB_MYSQL_PASSWORD}** pelos valores específicos do seu ambiente de desenvolvimento.
- Abra o projeto em sua IDE java preferida.
- Execute a aplicação e aproveite as funcionalidades disponíveis.

## 📅 Etapas do Projeto

1. *Modelagem do Banco de Dados*: Criação dos modelos conceitual, lógico e físico.
2. *Desenvolvimento da Aplicação*: Implementação das operações CRUD.
3. *Desenvolvimento da documentação*: Criação da documentação do sistema.
4. *Entrega*: Publicação do projeto no GitHub com código-fonte e documentação completa.

---

Desenvolvido por 
- Débora Cristina Silva Ferreira
- Filipe Silva da Fonseca
- Samantha Yumi Tanaka
- Vinicios Trindade Costa
- Wictor Emanoel Ponte Menezes

