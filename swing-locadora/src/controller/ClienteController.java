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

import model.Cliente;
import model.Endereco;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe respons�vel por controlar os processos de grava��o e leitura da tela
 * de Cliente
 * 
 * @author Victor Baptista
 * @since 09/03/2021
 * @version 1.0
 */
public class ClienteController {

	// declarando o nome do arquivo txt a ser utilizado
	private String arquivo = "cliente.txt";

	/*
	 * M�todo respons�vel por gravar registro em um arquivo txt
	 */
	public void gravarTxtCliente(Cliente cliente) {// in�cio do m�todo

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
			gravador.print(cliente.getCodigo());
			gravador.print(";");
			gravador.print(cliente.getNome());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getCodigo());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getEndereco());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getNumero());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getCidade());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getEstado());
			gravador.print(";");
			gravador.print(cliente.getEndereco().getCep());
			gravador.print(";");
			gravador.print(cliente.getCpf());
			gravador.print(";");
			gravador.print(cliente.getRg());
			gravador.print(";");
			gravador.print(cliente.getDataNascimento().toString());
			gravador.print(";");
			gravador.print(cliente.getSexo());
			gravador.print(";");
			gravador.print(cliente.getIdade());
			gravador.print(";");
			gravador.print(cliente.getTelefone());
			gravador.print(";");
			gravador.print(cliente.getCelular());
			gravador.print(";");
			gravador.print(cliente.getEmail());
			gravador.print("\n");

			// fechando o processo de grava��o
			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoCliente, Titulo.cadastroCliente, 0);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoCliente, Titulo.cadastroCliente, 0);
			e.printStackTrace();
		}
	}// fim do m�todo gravarTxtCliente

	/*
	 * M�todo respons�vel por retornar uma lista de vendedores
	 */
	public ArrayList<Cliente> getClientes() {
		// objeto de lista para retornar no m�todo
		ArrayList<Cliente> clientes = buscarTodos();

		//
		return clientes;
	}// fim do m�todo getClientes

	/*
	 * M�todo respons�vel por ler o arquivo de cliente
	 */
	private ArrayList<Cliente> buscarTodos() {
		// lista auxiliar de retorno
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		//
		try {
			// classe scanner auxiliar para ler o arquivo de cliente
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// la�o de repeti��o para ler as linhas do arquivo
			while (leitor.hasNext()) {
				// objeto auxiliar para retornar no m�todo
				Cliente cliente = getCliente(leitor.nextLine());
				// atribuindo o objeto na lista de retorno
				clientes.add(cliente);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		// retorno a lista de clientes
		return clientes;
	}// fim do m�todo buscarTodos

	/*
	 * M�todo respons�bel por retornar um objeto do tipo cliente
	 */
	private Cliente getCliente(String args) {
		// objeto auxliar para retorno do m�todo
		Cliente cliente = new Cliente();
		//
		Endereco endereco = new Endereco();

		// vari�vel auxiliar para quebrar o registro do arquivo
		String aux[] = args.split(";");

		// valorizando o objeto cliente
		cliente.setNome(aux[1]);
		cliente.setSexo(aux[14].charAt(0));
		cliente.setIdade(Util.getInt(aux[15]));
		cliente.setCelular(aux[17]);

		endereco.setCidade(aux[8]);

		cliente.setEndereco(endereco);

		// retornando o objeto valorizado
		return cliente;
	}// fim do m�todo getCliente
}// fim da classe
