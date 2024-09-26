package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Criptografia {
	// Algoritmos de hash disponíveis
	public static final String SHA256 = "SHA-256";
	public static final String MD5 = "MD5";

	// Atributos da classe
	protected String informacao;
	protected String padrao;

	// Construtor da classe
	public Criptografia(String informacao, String padrao) {
		super();
		this.informacao = informacao;
		this.padrao = padrao;
	}

	public String getInformacao() {
		return informacao;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}

	public String getPadrao() {
		return padrao;
	}

	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}

	// Método para realizar a criptografia da informação
	public String criotografar() {
		String informacao = getInformacao();

		MessageDigest messageDigest;
		StringBuilder hexString = null;

		try {
			// Inicializa o objeto MessageDigest com o algoritmo escolhido
			messageDigest = MessageDigest.getInstance(getPadrao());

			// Obtém o hash da informação
			byte[] hash = messageDigest.digest(informacao.getBytes(StandardCharsets.UTF_8));
			hexString = new StringBuilder(2 * hash.length);

			// Definir a capacidade inicial do StringBuilder
			// Converte o hash em uma representação hexadecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Retorna o hash em formato hexadecimal (uppercase)
		return hexString.toString().toUpperCase();
	}
}
