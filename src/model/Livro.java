package model;

public class Livro {
	protected int id;
	protected String tituloDoLivro;
	protected int numeroDePáginas;
	protected String autor;
	protected double preco;

	public Livro() {

	}

	public Livro( int id,String tituloDoLivro, int numeroDePáginas, String autor, double preco) {
		super();
		this.id = id;
		this.tituloDoLivro = tituloDoLivro;
		this.numeroDePáginas = numeroDePáginas;
		this.autor = autor;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTituloDoLivro() {
		return tituloDoLivro;
	}

	public void setTituloDoLivro(String tituloDoLivro) {
		this.tituloDoLivro = tituloDoLivro;
	}

	public int getNumeroDePáginas() {
		return numeroDePáginas;
	}

	public void setNumeroDePáginas(int numeroDePáginas) {
		this.numeroDePáginas = numeroDePáginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
