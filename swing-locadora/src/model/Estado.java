package model;

/**
 * Classe responsável por armazenar os atributos e métodos do objeto Estado
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
	 * Método construtor da classe
	 */
	public Estado() {
	}

	/*
	 * Construtor com parâmetros
	 */
	public Estado(String uf, String nome) {
		this.uf = uf;
		this.nome = nome;
	}

	/*
	 * Métodos getters e setters dos atributos do objeto
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
