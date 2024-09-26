package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

	// Nomes das colunas
	private static final String[] colunas = { "Título do Livro", "Número de Páginas", "AutorAutora" , "Preco"};

	private ArrayList<Livro> livros;

	// Retorna o número de linhas na tabela
	@Override
	public int getRowCount() {
		return livros.size();
	}

	// Retorna o número de colunas na tabel
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	// Obtém o valor a ser exibido em uma célula específica da tabela
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    // Mapeia cada coluna para o respectivo atributo do objeto Livro
	    Livro livro = livros.get(rowIndex);
	    if (columnIndex == 0) {
	        return livro.getTituloDoLivro();
	    } else if (columnIndex == 1) {
	        return livro.getNumeroDePáginas();
	    } else if (columnIndex == 2) {
	        return livro.getAutor();
	    } else if (columnIndex == 3) {
	        return livro.getPreco();
	    } else {
	        return null;
	    }
	}

	// Construtor que recebe a lista den livros
	public ModeloTabela(ArrayList<Livro> livros) {
		super();
		this.livros = livros;
	}

	// Retorna o nome da coluna com base no índice da coluna
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
}
