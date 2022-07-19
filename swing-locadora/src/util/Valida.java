package util;

/**
 * Classe respons�vel por armazenar os m�todos de valida��o do projeto
* @author Victor Baptista
 * @since 08/03/2021
 * @version 1.0
 */
public class Valida {

	/*
	 * M�todo respons�vel por verificar se o campo � diferende de vazio ou nulo
	 */
	public static boolean isEmptyOrNull(String args) {
		//verificando se o argumento est� preenchido
		return (args.trim().equals("") || args == null);
	}
	
	/*
	 * M�todo respons�vel por verificar se o campo � diferende de vazio ou nulo
	 */
	public static boolean isEmptyOrNullFormat(String args) {
		String aux = args.trim().replaceAll("[()-./]", "");
		//String aux = args.trim().replace("(", "").replace(")", "").replace("-", "").replace("/", "").replace(".", "");
		//verificando se o argumento est� preenchido
		return (aux.trim().equals("")  || args == null);
	}
	
	/*
	 * M�todo respons�vel por verificar se o campo � um inteiro
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
	 * M�todo respons�vel por verificar se o campo � um double
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
