package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Classe responsável por criar o Menu de telas
 * 
 * @author Victor Baptista
 * @since 05/03/2021
 * @version 1.0
 */
public class MenuPrincipalView {

	/*
	 * Declarando os atributos da tela
	 */
	private JFrame janela;
	// declarando o componente para a barra de menu
	private JMenuBar barraMenu;
	// declarando os componentes de menu
	private JMenu menu1;
	private JMenu menu2;
	private JMenu menu3;
	// declarando os itens de menu
	private JMenuItem itemMenu1;
	private JMenuItem itemMenu2;
	private JMenuItem itemMenu3;
	private JMenuItem itemMenu4;
	private JMenuItem itemMenu5;
	private JMenuItem itemMenu6;
	private JMenuItem itemMenu7;
	private JMenuItem itemMenu8;

	/*
	 * Método responsável por criar a tela
	 */
	public void iniciaGui() {// início do método iniciaGui

		/*
		 * Criando as instancias dos objetos
		 */
		janela = new JFrame();
		barraMenu = new JMenuBar();
		menu1 = new JMenu();
		menu2 = new JMenu();
		menu3 = new JMenu();
		itemMenu1 = new JMenuItem();
		itemMenu2 = new JMenuItem();
		itemMenu3 = new JMenuItem();
		itemMenu4 = new JMenuItem();
		itemMenu5 = new JMenuItem();
		itemMenu6 = new JMenuItem();
		itemMenu7 = new JMenuItem();
		itemMenu8 = new JMenuItem();

		/*
		 * Configuração de texto do menu
		 */
		menu1.setText("Cadastro");
		menu2.setText("Consulta");
		menu3.setText("Sair");

		/*
		 * Configuração do texto dos itens de menu
		 */
		itemMenu1.setText("Cliente");
		itemMenu2.setText("Vendedor");
		itemMenu3.setText("Filme");
		itemMenu4.setText("Locação");
		itemMenu5.setText("Cliente");
		itemMenu6.setText("Vendedor");
		itemMenu7.setText("Filme");
		itemMenu8.setText("Sair");

		/*
		 * Adicionando o menu na barra de menus
		 */
		barraMenu.add(menu1);
		barraMenu.add(menu2);
		barraMenu.add(menu3);

		/*
		 * Adicionando os itens de menu no menu1
		 */
		menu1.add(itemMenu1);
		menu1.add(itemMenu2);
		menu1.add(itemMenu3);
		menu1.add(itemMenu4);

		/*
		 * Adicionando os itens de menu no menu2
		 */
		menu2.add(itemMenu5);
		menu2.add(itemMenu6);
		menu2.add(itemMenu7);

		/*
		 * Adicionando os itens de menu no menu3
		 */
		menu3.add(itemMenu8);

		/*
		 * Adicionando as ações aos itens de menu
		 */
		//Atribui ao item menu1 a tela de Cadastro de Cliente
		itemMenu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new CadastroClienteView().iniciaGui();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//Atribui ao item menu2 a tela de Cadastro de Vendedor
		itemMenu2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarVendedorView().iniciaGui();
			}
		});

		//Atribui ao item menu3 a tela de Cadastro de Filme
		itemMenu3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarFilmeView().iniciaGui();
			}
		});

		//Atribui ao item menu4 a tela de Cadastro de Locação
		itemMenu4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarLocacaoView().iniciaGui();
			}
		});

		//Atribui ao item menu5 a tela de Consulta de Cliente
		itemMenu5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultarClienteView().iniciaGui();
			}
		});
		
		//Atribui ao item menu6 a tela de Consulta de Vendedor
		itemMenu6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultarVendedorView().iniciaGui();
			}
		});
		
		//Atribui ao item menu7 a tela de Consulta de Filme
		itemMenu7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultarFilmeView().iniciaGui();
			}
		});
		
		////Atribui ao item menu8 a opção de sair do sistema
		itemMenu8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Mensagem de confirmação para sair do programa
				int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				// caso o usuário escolha a opção sim, o programa finaliza
				if (opcao == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		/*
		 * Configuração do JFrame - janel
		 */
		// adicionando a barra de menu à janela
		janela.setJMenuBar(barraMenu);
		// configurando o título do menu
		janela.setTitle("LOCADORA");
		// configurando a ação do 'X' do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// configurando o tamanho maximizado
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// configurando a visibilidade da tela
		janela.setVisible(true);

	}// fim do método iniciaGui
}// fim da classe
