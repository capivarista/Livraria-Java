package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.Conexao;
import model.Livro;
import model.Usuario;

public class DAO {
	// Declaração de objetos PreparedStatement e ResultSet
	private static PreparedStatement prepareStatement = null;
	private static ResultSet resultSet = null;

	// Informações do banco de dados
/*	private static String DRIVE = "org.sqlite.JDBC";
	private static String BD = "jdbc:sqlite:resources/bdlivro.db";*/

	// Consultas SQL para operações CRUD em uma tabela de livros
	private static String CADASTRAR_LIVRO = " INSERT INFO LIVRO " + " (ID,TIULODOLIVRO, NUMERODEPAGINAS, AUTOR, PRECO )"
			+ " VALUES ( NULL, ?,?,?,?)";

	private static String CONSULTAR_LIVRO = "SELECT * FROM LIVRO" + " WHERE ID = ?";

	private static String ALTERAR_LIVRO = " UPDATE LIVRO SET "
			+ " SET TIULODOLIVRO = ? , NUMERODEPAGINAS = ?, AUTOR = ?, PRECO = ? " + " WHERE ID = ?";

	private static String EXCLUIR_LIVRO = " DELETE FROM LIVRO " + " WHERE ID = ?";

	private static String LISTAR_LIVRO = " SELECT * FROM LIVRO " + " WHERE 1=1";

	// Consulta SQL para verificar usuário e senha
	private static String CONSULTAR_USUARIO = " SELECT USUARIO, SENHA " + " FROM USUARIO " + " WHERE USUARIO = ?"
			+ " AND SENHA = ?";

	public DAO() {

	}

	 public void cadastrarLivro(Livro livro) {
	        Connection connection = Conexao.getInstancia().abrirConexao();

	        String query = CADASTRAR_LIVRO;
	        try {
	            prepareStatement = connection.prepareStatement(query);

	            int i = 1;
	            prepareStatement.setString(i++, livro.getTituloDoLivro());
	            prepareStatement.setInt(i++, livro.getNumeroDePáginas());
	            prepareStatement.setString(i++, livro.getAutor());
	            prepareStatement.setDouble(i++, livro.getPreco());

	            prepareStatement.executeUpdate();

	            JOptionPane.showMessageDialog(null, "Livro incluído com sucesso");

	            connection.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	    }

	    public Livro consultarLivro(String id) throws Exception {
	        Connection connection = Conexao.getInstancia().abrirConexao();

	        Livro livro = null;
	        String query = CONSULTAR_LIVRO;
	        try {
	            prepareStatement = connection.prepareStatement(query);

	            int i = 1;
	            prepareStatement.setString(i++, id);

	            resultSet = prepareStatement.executeQuery();

	            while (resultSet.next()) {
	                livro = new Livro(resultSet.getInt("ID"), resultSet.getString("TIULODOLIVRO"),
	                        resultSet.getInt("NUMERODEPAGINAS"), resultSet.getString("AUTOR"),
	                        resultSet.getDouble("PRECO"));
	            }

	            connection.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	        if (livro == null) {
	            JOptionPane.showMessageDialog(null, "Não foi possível localizar o livro selecionado", "",
	                    JOptionPane.WARNING_MESSAGE);
	            throw new Exception("Não foi possível localizar o livro selecionado");
	        }
	        return livro;
	    }

	    public void alterarLivro(int id, Livro livro) {
	        Connection connection = Conexao.getInstancia().abrirConexao();

	        String query = ALTERAR_LIVRO;
	        try {
	            prepareStatement = connection.prepareStatement(query);

	            int i = 1;
	            prepareStatement.setString(i++, livro.getTituloDoLivro());
	            prepareStatement.setInt(i++, livro.getNumeroDePáginas());
	            prepareStatement.setString(i++, livro.getAutor());
	            prepareStatement.setDouble(i++, livro.getPreco());
	            prepareStatement.setInt(i++, id);

	            prepareStatement.executeUpdate();
	            connection.commit();

	            JOptionPane.showMessageDialog(null, "Livro alterado com sucesso");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	    }

	    public void excluirLivro(int id) {
	        Connection connection = Conexao.getInstancia().abrirConexao();

	        String query = EXCLUIR_LIVRO;
	        try {
	            prepareStatement = connection.prepareStatement(query);

	            int i = 1;
	            prepareStatement.setInt(i++, id);

	            prepareStatement.executeUpdate();
	            connection.commit();

	            JOptionPane.showMessageDialog(null, "Livro foi excluído com sucesso");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	    }

	    public ArrayList<Livro> listarLivros() throws Exception {
	        Connection connection = Conexao.getInstancia().abrirConexao();

	        ArrayList<Livro> livros = new ArrayList<>();
	        String query = LISTAR_LIVRO;

	        try {
	            prepareStatement = connection.prepareStatement(query);

	            resultSet = prepareStatement.executeQuery();

	            while (resultSet.next()) {
	                livros.add(new Livro(resultSet.getInt("ID"), resultSet.getString("TIULODOLIVRO"),
	                        resultSet.getInt("NUMERODEPAGINAS"), resultSet.getString("AUTOR"),
	                        resultSet.getDouble("PRECO")));
	            }

	            connection.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	        if (livros.size() <= 0) {
	            JOptionPane.showMessageDialog(null, "Não há livros cadastrados", "", JOptionPane.WARNING_MESSAGE);
	            throw new Exception("Não há livros cadastrados");
	        }
	        return livros;
	    }

	    public Usuario consultarUsuario(String nomeUsuario, String senhaCriptografada) throws Exception {
	        Connection connection = Conexao.getInstancia().abrirConexao();

	        Usuario usuario = null;
	        String query = CONSULTAR_USUARIO;

	        try {
	            prepareStatement = connection.prepareStatement(query);

	            int i = 1;
	            prepareStatement.setString(i++, nomeUsuario);
	            prepareStatement.setString(i++, senhaCriptografada);

	            resultSet = prepareStatement.executeQuery();

	            while (resultSet.next()) {
	                usuario = new Usuario(resultSet.getInt("ID"), resultSet.getString("NOME"),
	                        resultSet.getString("SENHA"), query, query, query);
	            }

	            connection.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            fecharConexao();
	        }
	        if (usuario == null) {
	            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos", "", JOptionPane.WARNING_MESSAGE);
	            throw new Exception("Usuário ou senha incorretos");
	        }
	        return usuario;
	    }

	    private void fecharConexao() {

	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (prepareStatement != null) {
	                prepareStatement.close();
	            }
	            Conexao.getInstancia().fecharConexao();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}