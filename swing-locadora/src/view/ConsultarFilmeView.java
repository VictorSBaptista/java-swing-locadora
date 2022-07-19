package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.FilmeController;
import model.Filme;

/**
 * Classe respons�vel por criar a tela de consulta de Filmes cadastrados
 * 
 * @author Victor Baptista
 * @since 05/03/2021
 * @version 1.0
 */
public class ConsultarFilmeView {

	/*
	 * Declarando os atributos da tela
	 */
	private JFrame janela;
	// declarando a tabela para armazenar os dados do filme selecinado
	private JTable tabela;
	// declarando o scroll auxiliar para exibir os registros da tabela
	private JScrollPane scroll;
	// declarando o componente JButton para executar a��o de clique
	private JButton btSair;
	// declarando o componente JPanel para a organiza��o dos componentes
	private JPanel painel;

	// declara��o do vetor auxiliar para armazenar o nome das colunas da tabela
	private String colunas[] = { "C�digo", "Nome", "Valor", "Dispon�vel", "Promo��o", "Valor Promocional" };

	/*
	 * M�todo respons�vel por criar a tela
	 */
	public void iniciaGui() {// in�cio do m�todo iniciaGui

		/*
		 * Configura��o do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o t�tulo da tela
		janela.setTitle("Consulta de Filmes Cadastrados");
		// configurando as propor��es da tela - largura, altura
		janela.setSize(580, 400);
		// configurando a posi��o da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * Configura��o da tabela JTable - (tabela)
		 */
		// definir o modelo utilizado na tabela - quantidade de linhas e colunas
		DefaultTableModel modelo = new DefaultTableModel(null, colunas);
		tabela = new JTable(modelo);
		// configurar a posi��o e a propor��o do componente
		tabela.setBounds(2, 2, 562, 310);
		// configurar a a��o do usu�rio quando clica no registro armazenado
		tabela.setEnabled(false);

		/*
		 * Configura��o do JScrollPane
		 */
		scroll = new JScrollPane(tabela);
		// configurar o local de exibi��o do scroll
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// configurar a posi��o e a propor��o do componente
		scroll.setBounds(2, 2, 562, 310);

		/*
		 * Configura��o do componente JButton - (btSair)
		 */
		btSair = new JButton();
		// configurando o texto exibido no componente
		btSair.setText("SAIR");
		// configurar a posi��o e a propor��o do componente
		btSair.setBounds(210, 320, 150, 30);
		//
		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// fecha a janela e mant�m o menu aberto
				janela.dispose();
			}
		});

		/*
		 * Configura��o do componente JPanel - (painel)
		 */
		painel = (JPanel) janela.getContentPane();
		// configura o layout o painel
		painel.setLayout(null);
		// adiciona os compononetes ao painel
		painel.add(scroll);
		painel.add(btSair);

		// configurando a a��o do 'X' do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// chamando o m�todo para carregar a tabela com os dados registrados o arquivo
		carregarTabela();

		// configurando a visibilidade da janela
		janela.setVisible(true);

	}// fim do m�todo iniciaGui

	/*
	 * M�todo respons�vel por carregar a tabela com os dados dos filmes gravados no
	 * arquivo txt
	 */
	public void carregarTabela() {// in�cio do m�todo carregarTabela

		// obtendo o modelo da tabela criada
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		// limpando os dados(linhas) da tabela
		// modelo.removeRow(0);

		// la�o de repeti��o para preencher as linhas da tabela
		for (Filme filme : new FilmeController().getFilmes()) {
			// adicionando a linha na tabela
			modelo.addRow(new String[] { filme.getCodigo() + "", filme.getNome(), filme.getValor() + "",
					((filme.isDisponivel()) ? "Sim" : "N�o"), ((filme.isPromocao()) ? "Sim" : "N�o"),
					filme.getValorPromocao() + "" });
		}

	}// fim do m�todo carregarTabela
}// fim da classe
