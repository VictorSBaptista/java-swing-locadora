package util;

/**
 * Classe auxiliar respons�vel por armazenar m�todos de convers�o de dados
 * @author Victor Baptista
 * @since 09/03/2021
 * @version 1.0
 */
public class Util {

	/*
	 * M�todo respons�vel por converter String em Inteiro
	 */
	public static Integer getInt(String args) {
		return Integer.parseInt(args);
	}
	
	/*
	 * M�todo respons�vel por converter String em Double
	 */
	public static Double getDouble(String args) {
		return Double.parseDouble(args);
	}
	
	/*
	 * M�todo respons�vel por converter String em Boolean
	 */
	public static boolean getBoolean(String args) {
		return Boolean.parseBoolean(args);
	}
}
