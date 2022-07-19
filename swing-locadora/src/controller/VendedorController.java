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

import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe respons�vel por controlar os processos de grava��o e leitura da tela
 * de Vendedor
 * 
 * @author Victor Baptista
 * @since 09/03/2021
 * @version 1.0
 */
public class VendedorController {

	// declarando o nome do arquivo txt a ser utilizado
	private String arquivo = "vendedor.txt";

	/*
	 * M�todo respons�vel por gravar registro em um arquivo txt
	 */
	public void gravarTxtVendedor(Vendedor vendedor) {// in�cio do m�todo

		// classe auxiliar para carregar ou um arquivo existente ou criar um novo
		// arquivo
		File file = new File(arquivo);

		//
		try {
			// Classe auxiliar para gerar um objeto de mem�ria para a grava��o do arquivo
			FileOutputStream arquivoOutput = new FileOutputStream(file, true);

			// classe auxiliar para gerar o arquivo e seu conte�do
			PrintStream gravador = new PrintStream(arquivoOutput);

			// gravando o conte�do do arquivo
			gravador.print(vendedor.getCodigo());
			gravador.print(";");
			gravador.print(vendedor.getNome());
			gravador.print(";");
			gravador.print(vendedor.getAreaVenda());
			gravador.print(";");
			gravador.print(vendedor.getCidade());
			gravador.print(";");
			gravador.print(vendedor.getEstado());
			gravador.print(";");
			gravador.print(vendedor.getSexo());
			gravador.print(";");
			gravador.print(vendedor.getIdade());
			gravador.print(";");
			gravador.print(vendedor.getSalario());
			gravador.print("\n");

			// fechando o processo de grava��o
			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroVendedor, 0);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroVendedor, 0);
			e.printStackTrace();
		}
	}// fim do m�todo gravarTxtVendedor

	/*
	 * M�todo respons�vel por retornar uma lista de vendedores
	 */
	public ArrayList<Vendedor> getVendedores() {
		// objeto de lista para retornar no m�todo
		ArrayList<Vendedor> vendedores = buscarTodos();

		//
		return vendedores;
	}// fim do m�todo getVendedores

	/*
	 * M�todo respons�vel por ler o arquivo de vendedor
	 */
	private ArrayList<Vendedor> buscarTodos() {
		// lista auxiliar de retorno
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

		//
		try {
			// classe scanner auxiliar para ler o arquivo de vendedor
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// la�o de repeti��o para ler as linhas do arquivo
			while (leitor.hasNext()) {
				// objeto auxiliar para retornar no m�todo
				Vendedor vendedor = getVendedor(leitor.nextLine());
				// atribuindo o objeto na lista de retorno
				vendedores.add(vendedor);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		// retorno a lista de vendedores
		return vendedores;
	}// fim do m�todo buscarTodos

	/*
	 * M�todo respons�bel por retornar um objeto do tipo vendedor
	 */
	private Vendedor getVendedor(String args) {
		// objeto auxliar para retorno do m�todo
		Vendedor vendedor = new Vendedor();
		// vari�vel auxiliar para quebrar o registro do arquivo
		String aux[] = args.split(";");

		// valorizando o objeto vendedor
		vendedor.setCodigo(Util.getInt(aux[0]));
		vendedor.setNome(aux[1]);
		vendedor.setAreaVenda(aux[2]);
		vendedor.setCidade(aux[3]);
		vendedor.setEstado(aux[4]);
		// charAt serve para pegar apenas a posi��o indicada
		vendedor.setSexo(aux[5].charAt(0));
		vendedor.setIdade(Util.getInt(aux[6]));
		vendedor.setSalario(Util.getDouble(aux[7]));

		// retornando o objeto valorizado
		return vendedor;
	}// fim do m�todo getVendedor
}// fim da classe
