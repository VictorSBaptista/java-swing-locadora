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
 * Classe responsável por criar a tela de consulta de Filmes cadastrados
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
	// declarando o componente JButton para executar ação de clique
	private JButton btSair;
	// declarando o componente JPanel para a organização dos componentes
	private JPanel painel;

	// declaração do vetor auxiliar para armazenar o nome das colunas da tabela
	private String colunas[] = { "Código", "Nome", "Valor", "Disponível", "Promoção", "Valor Promocional" };

	/*
	 * Método responsável por criar a tela
	 */
	public void iniciaGui() {// início do método iniciaGui

		/*
		 * Configuração do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o título da tela
		janela.setTitle("Consulta de Filmes Cadastrados");
		// configurando as proporções da tela - largura, altura
		janela.setSize(580, 400);
		// configurando a posição da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * Configuração da tabela JTable - (tabela)
		 */
		// definir o modelo utilizado na tabela - quantidade de linhas e colunas
		DefaultTableModel modelo = new DefaultTableModel(null, colunas);
		tabela = new JTable(modelo);
		// configurar a posição e a proporção do componente
		tabela.setBounds(2, 2, 562, 310);
		// configurar a ação do usuário quando clica no registro armazenado
		tabela.setEnabled(false);

		/*
		 * Configuração do JScrollPane
		 */
		scroll = new JScrollPane(tabela);
		// configurar o local de exibição do scroll
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// configurar a posição e a proporção do componente
		scroll.setBounds(2, 2, 562, 310);

		/*
		 * Configuração do componente JButton - (btSair)
		 */
		btSair = new JButton();
		// configurando o texto exibido no componente
		btSair.setText("SAIR");
		// configurar a posição e a proporção do componente
		btSair.setBounds(210, 320, 150, 30);
		//
		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// fecha a janela e mantém o menu aberto
				janela.dispose();
			}
		});

		/*
		 * Configuração do componente JPanel - (painel)
		 */
		painel = (JPanel) janela.getContentPane();
		// configura o layout o painel
		painel.setLayout(null);
		// adiciona os compononetes ao painel
		painel.add(scroll);
		painel.add(btSair);

		// configurando a ação do 'X' do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// chamando o método para carregar a tabela com os dados registrados o arquivo
		carregarTabela();

		// configurando a visibilidade da janela
		janela.setVisible(true);

	}// fim do método iniciaGui

	/*
	 * Método responsável por carregar a tabela com os dados dos filmes gravados no
	 * arquivo txt
	 */
	public void carregarTabela() {// início do método carregarTabela

		// obtendo o modelo da tabela criada
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		// limpando os dados(linhas) da tabela
		// modelo.removeRow(0);

		// laço de repetição para preencher as linhas da tabela
		for (Filme filme : new FilmeController().getFilmes()) {
			// adicionando a linha na tabela
			modelo.addRow(new String[] { filme.getCodigo() + "", filme.getNome(), filme.getValor() + "",
					((filme.isDisponivel()) ? "Sim" : "Não"), ((filme.isPromocao()) ? "Sim" : "Não"),
					filme.getValorPromocao() + "" });
		}

	}// fim do método carregarTabela
}// fim da classe
