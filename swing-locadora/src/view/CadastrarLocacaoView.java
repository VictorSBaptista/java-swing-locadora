package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por criar a tela de cadastro de Locações
 * 
 * @author Victor Baptista
 * @since 04/03/2021
 * @version 1.0
 */
public class CadastrarLocacaoView {

	/*
	 * Declarando os atributos da tela
	 */
	private JFrame janela;
	// declarando as labels para exibir os rótulos na tela
	private JLabel lbNomeVendedor;
	private JLabel lbNomeFilme;
	private JLabel lbFormaPagamento;
	private JLabel lbValorTotal;
	private JLabel lbValorPago;
	private JLabel lbTroco;
	// declarando os campos de textos para o usuário digitar as informações
	private JTextField tfValorTotal;
	private JTextField tfValorPago;
	private JTextField tfTroco;
	// declarando os componentes JComboBox
	private JComboBox cbxVendedores;
	private JComboBox cbxFilmes;
	// declarando a tabela para armazenar os dados do filme selecinado
	private JTable tabela;
	// declarando o scroll auxiliar para exibir os registros da tabela
	private JScrollPane scroll;
	// declarando os componentes radio button
	private JRadioButton rbDinheiro;
	private JRadioButton rbCheque;
	private JRadioButton rbDebito;
	private JRadioButton rbCredito;
	// declarando o componente ButtonGroup responsável por gerenciar os componentes
	// radio button
	private ButtonGroup grpFormaPagamento;
	// declarando os componentes JButton para executar ação de clique
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btIncluir;
	// declarando o componente JPanel para a organização dos componentes
	private JPanel painel;

	// vetores TEMPORÁRIOS auxiliares para armazenar os estados
	private String vendedores[] = { "-Selecione um Vendedor-", "Vendedor1", "Vendedor2" };
	private String filmes[] = { "-Selecione um Filme-", "Filme1", "Filme2" };

	// declaração do vetor auxiliar para armazenar o nome das colunas da tabela
	private String colunas[] = { "Código", "Nome", "Valor", "Disponível","Promoção", "Valor Promocional" };
	// matriz auxiliar para armazenar os dados exibidos na tabela
	private String linhas[][];

	/*
	 * Método responsável por criar a tela
	 */
	public void iniciaGui() {// início do método inciaGui

		/*
		 * Configuração do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o título da tela
		janela.setTitle("Cadastro de Locação");
		// configurando as proporções da tela - largura, altura
		janela.setSize(580, 380);
		// configurando a posição da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * Configuração do primeiro componente JLabel - (lbNomeVendedor)
		 */
		lbNomeVendedor = new JLabel();
		// configurando o texto inicial da label
		lbNomeVendedor.setText("Nome do Vendedor:");
		// configurando a posição e proporção do componente
		lbNomeVendedor.setBounds(10, 17, 120, 25);

		/*
		 * Configuração do segundo componente JLabel - (lbNomeFilme)
		 */
		lbNomeFilme = new JLabel();
		// configurando o texto inicial da label
		lbNomeFilme.setText("Nome do Filme:");
		// configurando a posição e proporção do componente
		lbNomeFilme.setBounds(10, 52, 100, 25);

		/*
		 * Configuração do terceiro componente JLabel - (lbFormaPagamento)
		 */
		lbFormaPagamento = new JLabel();
		// configurando o texto inicial da label
		lbFormaPagamento.setText("Forma de Pagamento:");
		// configurando a posição e proporção do componente
		lbFormaPagamento.setBounds(10, 214, 125, 25);

		/*
		 * Configuração do quarto componente JLabel - (lbValorTotal)
		 */
		lbValorTotal = new JLabel();
		// configurando o texto inicial da label
		lbValorTotal.setText("Valor Total:");
		// configurando a posição e proporção do componente
		lbValorTotal.setBounds(315, 210, 70, 25);

		/*
		 * Configuração do quinto componente JLabel - (lbValorPago)
		 */
		lbValorPago = new JLabel();
		// configurando o texto inicial da label
		lbValorPago.setText("Valor Pago:");
		// configurando a posição e proporção do componente
		lbValorPago.setBounds(315, 230, 70, 25);

		/*
		 * Configuração do sexto componente JLabel - (lbTroco)
		 */
		lbTroco = new JLabel();
		// configurando o texto inicial da label
		lbTroco.setText("Troco:");
		// configurando a posição e proporção do componente
		lbTroco.setBounds(315, 250, 70, 25);

		/*
		 * Configuração do primeiro componente JTextField - (tfValorTotal)
		 */
		tfValorTotal = new JTextField();
		// configura o texto inicial do componente
		tfValorTotal.setText("R$0,00");
		// configurar a posição e a proporção do componente
		tfValorTotal.setBounds(385, 210, 120, 25);

		/*
		 * Configuração do segundo componente JTextField - (tfValorPago)
		 */
		tfValorPago = new JTextField();
		// configurar a posição e a proporção do componente
		tfValorPago.setBounds(385, 230, 120, 25);

		/*
		 * Configuração do terceiro componente JTextField - (tfTroco)
		 */
		tfTroco = new JTextField();
		// configura o texto inicial do componente
		tfTroco.setText("R$0,00");
		// configurar a posição e a proporção do componente
		tfTroco.setBounds(385, 250, 120, 25);

		/*
		 * Configuração do primeiro componente JComboBox - (cbxVendedores)
		 */
		cbxVendedores = new JComboBox(vendedores);
		// configurando a posição e proporção do componente
		cbxVendedores.setBounds(135, 20, 410, 20);

		/*
		 * Configuração do segundo componente JComboBox - (cbxFilmes)
		 */
		cbxFilmes = new JComboBox(filmes);
		// configurando a posição e proporção do componente
		cbxFilmes.setBounds(135, 55, 295, 20);

		/*
		 * Configuração da tabela JTable - (tabela)
		 */
		// definir o modelo utilizado na tabela - quantidade de linhas e colunas
		DefaultTableModel modelo = new DefaultTableModel(linhas, colunas);
		tabela = new JTable(modelo);
		// configurar a posição e a proporção do componente
		tabela.setBounds(2, 95, 550, 105);
		// configurar a ação do usuário quando clica no registro armazenado
		tabela.setEnabled(false);

		/*
		 * Configuração do JScrollPane
		 */
		scroll = new JScrollPane(tabela);
		// configurar o local de exibição do scroll
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// configurar a posição e a proporção do componente
		scroll.setBounds(2, 95, 560, 105);

		/*
		 * Configuração do primeiro componente JRadioButton - (rbDinheiro)
		 */
		rbDinheiro = new JRadioButton();
		// configurando o texto inicial do radio button
		rbDinheiro.setText("Dinheiro");
		// configurar a posição e a proporção do componente
		rbDinheiro.setBounds(135, 215, 85, 25);

		/*
		 * Configuração do segundo componente JRadioButton - (rbCheque)
		 */
		rbCheque = new JRadioButton();
		// configurando o texto inicial do radio button
		rbCheque.setText("Cheque");
		// configurar a posição e a proporção do componente
		rbCheque.setBounds(135, 235, 85, 25);

		/*
		 * Configuração do terceiro componente JRadioButton - (rbDebito)
		 */
		rbDebito = new JRadioButton();
		// configurando o texto inicial do radio button
		rbDebito.setText("Débito");
		// configurar a posição e a proporção do componente
		rbDebito.setBounds(135, 255, 85, 25);

		/*
		 * Configuração do quarto componente JRadioButton - (rbCredito)
		 */
		rbCredito = new JRadioButton();
		// configurando o texto inicial do radio button
		rbCredito.setText("Crédito");
		// configurar a posição e a proporção do componente
		rbCredito.setBounds(135, 275, 85, 25);

		/*
		 * Configuração do componente ButtonGroup - (grpFormaPagamento)
		 */
		grpFormaPagamento = new ButtonGroup();
		// adicionando os componentes JRaldioButton ao componente ButtonGroup
		grpFormaPagamento.add(rbDinheiro);
		grpFormaPagamento.add(rbCheque);
		grpFormaPagamento.add(rbDebito);
		grpFormaPagamento.add(rbCredito);

		/*
		 * Configuração do primeiro componente JButton - (btSalvar)
		 */
		btSalvar = new JButton();
		// configurando o texto exibido no componente
		btSalvar.setText("SALVAR");
		// configurar a posição e a proporção do componente
		btSalvar.setBounds(180, 310, 100, 25);

		/*
		 * Configuração do segundo componente JButton - (btCancelar)
		 */
		btCancelar = new JButton();
		// configurando o texto exibido no componente
		btCancelar.setText("CANCELAR");
		// configurar a posição e a proporção do componente
		btCancelar.setBounds(290, 310, 100, 25);

		/*
		 * Configuração do terceiro componente JButton - (btIncluir)
		 */
		btIncluir = new JButton();
		// configurando o texto exibido no componente
		btIncluir.setText("INCLUIR");
		// configurar a posição e a proporção do componente
		btIncluir.setBounds(450, 55, 100, 25);

		/*
		 * Configuração do componente JPanel - (painel)
		 */
		painel = (JPanel) janela.getContentPane();
		// configura o layout o painel
		painel.setLayout(null);
		// adiciona os compononetes ao painel
		painel.add(lbNomeVendedor);
		painel.add(lbNomeFilme);
		painel.add(lbFormaPagamento);
		painel.add(lbValorTotal);
		painel.add(lbValorPago);
		painel.add(lbTroco);
		painel.add(tfValorTotal);
		painel.add(tfValorPago);
		painel.add(tfTroco);
		painel.add(cbxVendedores);
		painel.add(cbxFilmes);
		painel.add(scroll);
		painel.add(rbDinheiro);
		painel.add(rbCheque);
		painel.add(rbDebito);
		painel.add(rbCredito);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btIncluir);

		// configurando a visibilidade da tela
		janela.setVisible(true);

	}// fim do método iniciaGui
}// fim da classe