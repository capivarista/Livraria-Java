package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Conexao instancia;
    private static final String URL = "jdbc:mysql://jva/livro";
    private static final String USUARIO = "root";
    private static final String SENHA = "admin";
    private static final String DRIVE = "com.mysql.cj.jdbc.Driver";

    private static Connection conexao;

    private Conexao() {
    }

    public static Conexao getInstancia() {
        if (instancia == null) {
            instancia = new Conexao();
        }
        return instancia;
    }

    public Connection abrirConexao() {
        try {
            Class.forName(DRIVE);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            conexao.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    public void fecharConexao() {
        try {
            if (instancia != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        } finally {
            conexao = null;
        }
    }
}
