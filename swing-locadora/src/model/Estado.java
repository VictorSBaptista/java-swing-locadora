package model;

/**
 * Classe respons�vel por armazenar os atributos e m�todos do objeto Estado
 * 
 * @author Victor Baptista
 * @since 04/03/2021
 * @version 1.0
 */
public class Estado {

	/*
	 * Declarando os atributos do objeto Estado
	 */
	private String uf;
	private String nome;

	/*
	 * M�todo construtor da classe
	 */
	public Estado() {
	}

	/*
	 * Construtor com par�metros
	 */
	public Estado(String uf, String nome) {
		this.uf = uf;
		this.nome = nome;
	}

	/*
	 * M�todos getters e setters dos atributos do objeto
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
