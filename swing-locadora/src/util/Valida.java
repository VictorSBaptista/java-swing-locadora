package util;

/**
 * Classe responsável por armazenar os métodos de validação do projeto
* @author Victor Baptista
 * @since 08/03/2021
 * @version 1.0
 */
public class Valida {

	/*
	 * Método responsável por verificar se o campo é diferende de vazio ou nulo
	 */
	public static boolean isEmptyOrNull(String args) {
		//verificando se o argumento está preenchido
		return (args.trim().equals("") || args == null);
	}
	
	/*
	 * Método responsável por verificar se o campo é diferende de vazio ou nulo
	 */
	public static boolean isEmptyOrNullFormat(String args) {
		String aux = args.trim().replaceAll("[()-./]", "");
		//String aux = args.trim().replace("(", "").replace(")", "").replace("-", "").replace("/", "").replace(".", "");
		//verificando se o argumento está preenchido
		return (aux.trim().equals("")  || args == null);
	}
	
	/*
	 * Método responsável por verificar se o campo é um inteiro
	 */
	public static boolean isInteger(String args) {
		try {
			Integer.parseInt(args);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*
	 * Método responsável por verificar se o campo é um double
	 */
	public static boolean isDouble(String args) {
		try {
			Double.parseDouble(args);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
