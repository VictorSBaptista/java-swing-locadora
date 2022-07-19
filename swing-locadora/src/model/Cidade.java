package model;

/**
 * Classe respons�vel por armazenar os atributos e m�todos do objeto Cidade
 * 
 * @author Victor Baptista
 * @since 04/03/2021
 * @version 1.0
 */
public class Cidade {

	/*
	 * Declarando os atributos do objeto Cidade
	 */
	private String nome;

	/*
	 * Construtor da classe
	 */
	public Cidade() {
	}

	/*
	 * M�todos getters e setters dos atributos
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}