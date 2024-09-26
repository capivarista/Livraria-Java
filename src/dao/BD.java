package dao;

import java.sql.Connection;

import controller.Conexao;

public class BD {

	public static void main(String[] args) {
		try {
			Connection connection = Conexao.getInstancia().abrirConexao();

			System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}