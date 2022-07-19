package model;

/**
 * Classe responsável por armazenar os atributos e métodos do objeto Data
 * 
 * @author Victor Baptista
 * @since 04/03/2021
 * @version 1.0
 */
public class Data {

	/*
	 * Declarando os atributos do objeto Data
	 */
	private int dia;
	private int mes;
	private int ano;

	/*
	 * Método construtor da classe
	 */
	public Data() {
	}

	/*
	 * Métodos getters e setters dos atributos
	 */
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	//
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
}
