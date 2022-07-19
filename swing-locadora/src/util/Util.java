package util;

/**
 * Classe auxiliar responsável por armazenar métodos de conversão de dados
 * @author Victor Baptista
 * @since 09/03/2021
 * @version 1.0
 */
public class Util {

	/*
	 * Método responsável por converter String em Inteiro
	 */
	public static Integer getInt(String args) {
		return Integer.parseInt(args);
	}
	
	/*
	 * Método responsável por converter String em Double
	 */
	public static Double getDouble(String args) {
		return Double.parseDouble(args);
	}
	
	/*
	 * Método responsável por converter String em Boolean
	 */
	public static boolean getBoolean(String args) {
		return Boolean.parseBoolean(args);
	}
}
