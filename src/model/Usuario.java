package model;

public class Usuario {
	private int id;
	private String nome;
	private String dataDeNacimento;
	private String cpf;
	private String e_mail;
	private String senha;

	public Usuario(int id, String nome, String dataDeNacimento, String cpf, String e_mail, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataDeNacimento = dataDeNacimento;
		this.cpf = cpf;
		this.e_mail = e_mail;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDeNacimento() {
		return dataDeNacimento;
	}

	public void setDataDeNacimento(String dataDeNacimento) {
		this.dataDeNacimento = dataDeNacimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
