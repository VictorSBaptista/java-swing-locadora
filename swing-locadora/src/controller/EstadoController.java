package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

import model.Estado;
import util.Mensagem;
import util.Titulo;

/**
 * Classe respons�vel por controlar os m�todos do obejto estado
 * 
 * @author Victor Baptista
 * @since 08/03/2021
 * @versino 1.0
 */
public class EstadoController {

	// declarar o nome do arquivo txt utilizado
	private String arquivo = "estados.txt";

	/*
	 * M�todo respons�vel por retornar uma lista de estados
	 */
	public ArrayList<Estado> getEstados() {// in�cio do m�todo
		// Objeto para retornar o m�todo
		ArrayList<Estado> estados = buscarTodos();

		//
		return estados;

	}// fim do m�todo getEstados

	/*
	 * M�todo para ler o arquivo de estados
	 */
	private ArrayList<Estado> buscarTodos() {
		// Objeto para retornar o m�todo
		ArrayList<Estado> estados = new ArrayList<Estado>();

		try {
			// declarar um atributo para ler o arquivo de estados
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// la�o de repeti��o para a leitura do arquivo com o comando hasNext
			while (leitor.hasNext()) {
				// objeto auxiliar para retornar no m�todo
				Estado estado = getEstado(leitor.nextLine());
				// atribuindo o objeto de estado na lista de retorno
				estados.add(estado);
			}

		} catch (FileNotFoundException e) {
			// exibindo pro usu�rio uma mensagem de erro
			JOptionPane.showMessageDialog(null, Mensagem.erroLerArquivo, Titulo.cadastroVendedor, 0);
			// exibe no console o log de erro do Java
			e.printStackTrace();
		}

		// retornando a lista de estados
		return estados;
	}

	/*
	 * M�todo para retornar um objeto do tipo estado
	 */
	private Estado getEstado(String linha) {

		// vari�vel auxiliar para converter a linha em objeto
		String aux[] = linha.split(";");
		// retornando o objeto estado
		return new Estado(aux[0], aux[1]);
	}
}// fim da classe
