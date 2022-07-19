package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Filme;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe responsável por controlar os processos de gravação e leitura da tela
 * de Filme
 * 
 * @author Victor Baptista
 * @since 09/03/2021
 * @version 1.0
 */
public class FilmeController {

	// declarando o nome do arquivo txt a ser utilizado
	private String arquivo = "filme.txt";

	/*
	 * Método responsável por gravar registro em um arquivo txt
	 */
	public void gravarTxtFilme(Filme filme) {// início do método

		// classe auxiliar para carregar ou um arquivo existente ou criar um novo
		// arquivo
		File file = new File(arquivo);

		//
		try {
			// Classe auxiliar para gerar um objeto de memória para a gravação do arquivo
			FileOutputStream arquivoOutput = new FileOutputStream(file, true);

			// classe auxiliar para gerar o arquivo e seu conteúdo
			PrintStream gravador = new PrintStream(arquivoOutput);

			// gravando o conteúdo do arquivo
			gravador.print(filme.getCodigo());
			gravador.print(";");
			gravador.print(filme.getNome());
			gravador.print(";");
			gravador.print(filme.getValor());
			gravador.print(";");
			gravador.print(filme.isDisponivel());
			gravador.print(";");
			gravador.print(filme.isPromocao());
			gravador.print(";");
			gravador.print(filme.getValorPromocao());
			gravador.print(";");
			gravador.print(filme.getGenero());
			gravador.print("\n");

			// fechando o processo de gravação
			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoFilme, Titulo.cadastroFilme, 0);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoFilme, Titulo.cadastroFilme, 0);
			e.printStackTrace();
		}
	}// fim do método gravarTxtFilme
	
	/*
	 * Método responsável por retornar uma lista de filmes
	 */
	public ArrayList<Filme> getFilmes() {
		// objeto de lista para retornar no método
		ArrayList<Filme> filmes = buscarTodos();

		//
		return filmes;
	}// fim do método getFilmes

	/*
	 * Método responsável por ler o arquivo de filme
	 */
	private ArrayList<Filme> buscarTodos() {
		// lista auxiliar de retorno
		ArrayList<Filme> filmes = new ArrayList<Filme>();

		//
		try {
			// classe scanner auxiliar para ler o arquivo de filme
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// laço de repetição para ler as linhas do arquivo
			while (leitor.hasNext()) {
				// objeto auxiliar para retornar no método
				Filme filme = getFilme(leitor.nextLine());
				// atribuindo o objeto na lista de retorno
				filmes.add(filme);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		// retorno a lista de filmes
		return filmes;
	}// fim do método buscarTodos

	/*
	 * Método responsábel por retornar um objeto do tipo filme
	 */
	private Filme getFilme(String args) {
		// objeto auxliar para retorno do método
		Filme filme = new Filme();
		// variável auxiliar para quebrar o registro do arquivo
		String aux[] = args.split(";");

		// valorizando o objeto filme
		filme.setCodigo(Util.getInt(aux[0]));
		filme.setNome(aux[1]);
		filme.setValor(Util.getDouble(aux[2]));
		filme.setDisponivel(Util.getBoolean(aux[3]));
		filme.setPromocao(Util.getBoolean(aux[4]));
		filme.setValorPromocao(Util.getDouble(aux[5]));
		
		// retornando o objeto valorizado
		return filme;
	}//fim do método getFilme
}// fim da classe
