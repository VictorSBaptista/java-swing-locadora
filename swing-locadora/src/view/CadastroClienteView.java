package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EstadoController;
import model.Cliente;
import model.Data;
import model.Endereco;
import model.Estado;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe responsável por criar a tela de cadastro de Cliente
 * 
 * @author Victor Baptista
 * @since 04/03/2021
 * @version 1.0
 */
public class CadastroClienteView {

	/*
	 * Declarando os atributos da tela
	 */
	private JFrame janela;
	// declarando as labels para exibir os rótulos na tela
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbCpf;
	private JLabel lbRg;
	private JLabel lbDataNascimento;
	private JLabel lbIdade;
	private JLabel lbTelefone;
	private JLabel lbCelular;
	private JLabel lbEmail;
	private JLabel lbLogradouro;
	private JLabel lbNomeEndereco;
	private JLabel lbNumero;
	private JLabel lbComplemento;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbCep;
	// declarando os campos de textos para o usuário digitar as informações
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextField tfEmail;
	private JTextField tfLogradouro;
	private JTextField tfNomeEndereco;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfCidade;
	// declarando os campos de texto formatados
	private JFormattedTextField tfCpf;
	private JFormattedTextField tfRg;
	private JFormattedTextField tfDataNascimento;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCelular;
	private JFormattedTextField tfCep;
	// declarando os atributos de formatação
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtDataNascimento;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	private MaskFormatter fmtCep;
	// declarando os componentes JComboBox
	private JComboBox cbxEstados;
	// declarando os componentes radio button
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	// declarando o componente ButtonGroup responsável por gerenciar os componentes
	// radio button
	private ButtonGroup grpSexo;
	// declarando os componentes JButton para executar ação de clique
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// declarando o componentes JPanel para a organização dos componentes
	private JPanel painelEndereco;
	private JPanel painelContato;
	private JPanel painelSexo;
	private JPanel painelPrincipal;

	// vetor auxiliar para armazenar os estados
	private String estados[] = {};

	/*
	 * Método responsável por criar a tela
	 */
	public void iniciaGui() throws ParseException {// início do método iniciGui
		/*
		 * Configuração dos campos de formatação
		 */
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtRg = new MaskFormatter("##.###.###-#");
		fmtDataNascimento = new MaskFormatter("##/##/####");
		fmtTelefone = new MaskFormatter("(##) ####-####");
		fmtCelular = new MaskFormatter("(##) #####-####");
		fmtCep = new MaskFormatter("#####-###");

		/*
		 * Configuração do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o título da tela
		janela.setTitle("Cadastro de Cliente");
		// configurando as proporções da tela - largura, altura
		janela.setSize(620, 455);
		// configurando a posição da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * Configuração do primeiro componente JLabel - (lbCodigo)
		 */
		lbCodigo = new JLabel();
		// configurando o texto inicial da label
		lbCodigo.setText("Código:");
		// configurando a posição e proporção do componente
		lbCodigo.setBounds(20, 20, 70, 25);

		/*
		 * Configuração do segundo componente JLabel - (lbNome)
		 */
		lbNome = new JLabel();
		// configurando o texto inicial da label
		lbNome.setText("Nome:");
		// configurando a posição e proporção do componente
		lbNome.setBounds(250, 20, 70, 25);

		/*
		 * Configuração do terceiro componente JLabel - lbCpf
		 */
		lbCpf = new JLabel();
		// configurando o texto inicial do componente
		lbCpf.setText("CPF:");
		// configurando a posição e proporção do componente
		lbCpf.setBounds(20, 90, 50, 25);

		/*
		 * Configuração do quarto componente JLabel - lbRg
		 */
		lbRg = new JLabel();
		// configurando o texto inicial do componente
		lbRg.setText("RG:");
		// configurando a posição e proporção do componente
		lbRg.setBounds(250, 90, 50, 20);

		/*
		 * Configuração do quinto componente JLabel - lbDataNascimento
		 */
		lbDataNascimento = new JLabel();
		// configurando o texto inicial do componente
		lbDataNascimento.setText("Data de Nascimento:");
		// configurando a posição e proporção do componente
		lbDataNascimento.setBounds(20, 55, 120, 20);

		/*
		 * Configuração do sexto componente JLabel - (lbIdade)
		 */
		lbIdade = new JLabel();
		// configurando o texto inicial da label
		lbIdade.setText("Idade:");
		// configurando a posição e proporção do componente
		lbIdade.setBounds(250, 55, 70, 25);

		/*
		 * Configuração do sétimo componente JLabel - lbTelefone
		 */
		lbTelefone = new JLabel();
		// configurando o texto inicial do componente
		lbTelefone.setText("Telefone:");
		// configurando a posição e proporção do componente
		lbTelefone.setBounds(10, 22, 110, 20);

		/*
		 * Configuração do oitavo componente JLabel - lbCelular
		 */
		lbCelular = new JLabel();
		// configurando o texto inicial do componente
		lbCelular.setText("Celular:");
		// configurando a posição e proporção do componente
		lbCelular.setBounds(190, 22, 110, 20);

		/*
		 * Configuração do nono componente JLabel - lbEmail
		 */
		lbEmail = new JLabel();
		// configurando o texto inicial do componente
		lbEmail.setText("Email:");
		// configurando a posição e proporção do componente
		lbEmail.setBounds(350, 22, 110, 20);

		/*
		 * Configuração do décimo primeiro componente JLabel - lbLogradouro
		 */
		lbLogradouro = new JLabel();
		// configurando o texto inicial do componente
		lbLogradouro.setText("Logradouro:");
		// configurando a posição e proporção do componente
		lbLogradouro.setBounds(10, 30, 110, 20);

		/*
		 * Configuração do décimo segundo componente JLabel - lbNomeEndereco
		 */
		lbNomeEndereco = new JLabel();
		// configurando o texto inicial do componente
		lbNomeEndereco.setText("Nome do Endereço:");
		// configurando a posição e proporção do componente
		lbNomeEndereco.setBounds(10, 65, 110, 20);

		/*
		 * Configuração do décimo terceiro componente JLabel - lbNumero
		 */
		lbNumero = new JLabel();
		// configurando o texto inicial do componente
		lbNumero.setText("Número:");
		// configurando a posição e proporção do componente
		lbNumero.setBounds(10, 100, 110, 20);

		/*
		 * Configuração do décimo quarto componente JLabel - lbComplemento
		 */
		lbComplemento = new JLabel();
		// configurando o texto inicial do componente
		lbComplemento.setText("Complemento:");
		// configurando a posição e proporção do componente
		lbComplemento.setBounds(260, 100, 110, 20);

		/*
		 * Configuração do décimo quinto componente JLabel - lbCidade
		 */
		lbCidade = new JLabel();
		// configurando o texto inicial do componente
		lbCidade.setText("Cidade:");
		// configurando a posição e proporção do componente
		lbCidade.setBounds(10, 135, 110, 20);

		/*
		 * Configuração do décimo sexto componente JLabel - lbEstado
		 */
		lbEstado = new JLabel();
		// configurando o texto inicial do componente
		lbEstado.setText("Estado:");
		// configurando a posição e proporção do componente
		lbEstado.setBounds(440, 125, 110, 20);

		/*
		 * Configuração do décimo sétimo componente JLabel - lbCep
		 */
		lbCep = new JLabel();
		// configurando o texto inicial do componente
		lbCep.setText("CEP:");
		// configurando a posição e proporção do componente
		lbCep.setBounds(260, 135, 110, 20);

		/*
		 * Configuração do primeiro componente JTextField - (tfCodigo)
		 */
		tfCodigo = new JTextField();
		// configurar a posição e a proporção do componente
		tfCodigo.setBounds(80, 20, 150, 25);

		/*
		 * Configuração do segundo componente JTextField - (tfNome)
		 */
		tfNome = new JTextField();
		// configurar a posição e a proporção do componente
		tfNome.setBounds(300, 20, 290, 25);

		/*
		 * Configuração do terceiro componente JTextField - (tfIdade)
		 */
		tfIdade = new JTextField();
		// configurar a posição e a proporção do componente
		tfIdade.setBounds(300, 55, 100, 25);

		/*
		 * Configuração do quarto componente JTextField - (tfEmail)
		 */
		tfEmail = new JTextField();
		// configurar a posição e a proporção do componente
		tfEmail.setBounds(390, 20, 180, 25);

		/*
		 * Configuração do sexto componente JTextField - (tfLogradouro)
		 */
		tfLogradouro = new JTextField();
		// configurar a posição e a proporção do componente
		tfLogradouro.setBounds(150, 30, 400, 25);

		/*
		 * Configuração do sétimo componente JTextField - (tfNomeEndereco)
		 */
		tfNomeEndereco = new JTextField();
		// configurar a posição e a proporção do componente
		tfNomeEndereco.setBounds(150, 65, 400, 25);

		/*
		 * Configuração do oitavo componente JTextField - (tfNumero)
		 */
		tfNumero = new JTextField();
		// configurar a posição e a proporção do componente
		tfNumero.setBounds(150, 100, 100, 25);

		/*
		 * Configuração do nono componente JTextField - (tfComplemento)
		 */
		tfComplemento = new JTextField();
		// configurar a posição e a proporção do componente
		tfComplemento.setBounds(350, 100, 200, 25);

		/*
		 * Configuração do décimo componente JTextField - (tfComplemento)
		 */
		tfCidade = new JTextField();
		// configurar a posição e a proporção do componente
		tfCidade.setBounds(150, 135, 100, 25);

		/*
		 * Configuração o primeiro componente JFormattedTextField - tfCpf
		 */
		tfCpf = new JFormattedTextField(fmtCpf);
		// configurando a posição e proporção do componente
		tfCpf.setBounds(80, 92, 150, 25);

		/*
		 * Configuração o segundo componente JFormattedTextField - tfRg
		 */
		tfRg = new JFormattedTextField(fmtRg);
		// configurando a posição e proporção do componente
		tfRg.setBounds(300, 92, 100, 25);

		/*
		 * Configuração o terceiro componente JFormattedTextField - tfDataNascimento
		 */
		tfDataNascimento = new JFormattedTextField(fmtDataNascimento);
		// configurando a posição e proporção do componente
		tfDataNascimento.setBounds(155, 55, 75, 25);

		/*
		 * Configuração o quarto componente JFormattedTextField - tfTelefone
		 */
		tfTelefone = new JFormattedTextField(fmtTelefone);
		// configurando a posição e proporção do componente
		tfTelefone.setBounds(80, 21, 100, 25);

		/*
		 * Configuração o quinto componente JFormattedTextField - tfCelular
		 */
		tfCelular = new JFormattedTextField(fmtCelular);
		// configurando a posição e proporção do componente
		tfCelular.setBounds(240, 21, 105, 25);

		/*
		 * Configuração o sexto componente JFormattedTextField - tfCep
		 */
		tfCep = new JFormattedTextField(fmtCep);
		// configurando a posição e proporção do componente
		tfCep.setBounds(350, 135, 75, 25);

		/*
		 * Configuração do primeiro componente JComboBox - (cbxEstados)
		 */
		cbxEstados = new JComboBox(estados);
		// configurando a posição e proporção do componente
		cbxEstados.setBounds(430, 143, 140, 25);

		/*
		 * Configuração do primeiro componente JRadioButton - (rbMasculino)
		 */
		rbMasculino = new JRadioButton();
		// configurando o texto inicial do radio button
		rbMasculino.setText("Masculino");
		// configurar a posição e a proporção do componente
		rbMasculino.setBounds(40, 17, 85, 25);

		/*
		 * Configuração do segundo componente JRadioButton - (rbFeminino)
		 */
		rbFeminino = new JRadioButton();
		// configurando o texto inicial do radio button
		rbFeminino.setText("Feminino");
		// configurar a posição e a proporção do componente
		rbFeminino.setBounds(40, 47, 80, 25);

		/*
		 * Configuração do componente ButtonGroup - (grpSexo)
		 */
		grpSexo = new ButtonGroup();
		// adicionando os componentes JRaldioButton ao componente ButtonGroup
		grpSexo.add(rbMasculino);
		grpSexo.add(rbFeminino);

		/*
		 * Configuração do primeiro componente JButton - (btSalvar)
		 */
		btSalvar = new JButton();
		// configurando o texto exibido no componente
		btSalvar.setText("Salvar");
		// configurar a posição e a proporção do componente
		btSalvar.setBounds(155, 375, 135, 25);
		//
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});

		/*
		 * Configuração do segundo componente JButton - (btCancelar)
		 */
		btCancelar = new JButton();
		// configurando o texto exibido no componente
		btCancelar.setText("Cancelar");
		// configurar a posição e a proporção do componente
		btCancelar.setBounds(315, 375, 135, 25);
		//
		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// método para limpar os campos da tela
				limparTela();
				// método para bloquear os campos da tela
				bloquearTela();
			}
		});

		/*
		 * Configuração do segundo componente JButton - (btNovo)
		 */
		btNovo = new JButton();
		// configurando o texto exibido no componente
		btNovo.setText("NOVO");
		// configurar a posição e a proporção do componente
		btNovo.setBounds(155, 375, 135, 25);
		//
		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// método para liberar a edição da tela
				liberarTela();
			}
		});

		/*
		 * Configuração do segundo componente JButton - (btSair)
		 */
		btSair = new JButton();
		// configurando o texto exibido no componente
		btSair.setText("SAIR");
		// configurar a posição e a proporção do componente
		btSair.setBounds(315, 375, 135, 25);
		//
		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// fecha a janela e mantém o menu aberto
				janela.dispose();
			}
		});

		/*
		 * Configuração do componente JPanel - (painelContato)
		 */
		painelContato = new JPanel();
		// configurando a posição e a proporção do componente
		painelContato.setBounds(10, 125, 580, 55);
		// configurar o layout do painel
		painelContato.setLayout(null);
		// configurar a borda do painel
		painelContato.setBorder(new TitledBorder("Contato"));
		// adicionado os componentes de endereço no painel
		painelContato.add(lbTelefone);
		painelContato.add(lbCelular);
		painelContato.add(lbEmail);
		painelContato.add(tfTelefone);
		painelContato.add(tfCelular);
		painelContato.add(tfEmail);

		/*
		 * Configuração do componente JPanel - (painelSexo)
		 */
		painelSexo = new JPanel();
		// configurando a posição e a proporção do componente
		painelSexo.setBounds(420, 46, 170, 80);
		// configurar o layout do painel
		painelSexo.setLayout(null);
		// configurar a borda do painel
		painelSexo.setBorder(new TitledBorder("Sexo"));
		// adicionado os componentes de endereço no painel
		painelSexo.add(rbMasculino);
		painelSexo.add(rbFeminino);

		/*
		 * Configuração do componente JPanel - (painelEndereco)
		 */
		painelEndereco = new JPanel();
		// configurando a posição e a proporção do componente
		painelEndereco.setBounds(10, 180, 580, 180);
		// configurar o layout do painel
		painelEndereco.setLayout(null);
		// configurar a borda do painel
		painelEndereco.setBorder(new TitledBorder("Endereço"));
		// adicionado os componentes de endereço no painel
		painelEndereco.add(lbLogradouro);
		painelEndereco.add(lbNomeEndereco);
		painelEndereco.add(lbNumero);
		painelEndereco.add(lbComplemento);
		painelEndereco.add(lbCidade);
		painelEndereco.add(lbEstado);
		painelEndereco.add(lbCep);
		painelEndereco.add(tfLogradouro);
		painelEndereco.add(tfNomeEndereco);
		painelEndereco.add(tfNumero);
		painelEndereco.add(tfComplemento);
		painelEndereco.add(tfCidade);
		painelEndereco.add(tfCep);
		painelEndereco.add(cbxEstados);

		/*
		 * Configuração do componente JPanel - (painelPrincipal)
		 */
		painelPrincipal = (JPanel) janela.getContentPane();
		// configura o layout o painel
		painelPrincipal.setLayout(null);
		// adiciona os compononetes ao painel
		painelPrincipal.add(painelEndereco);
		painelPrincipal.add(painelContato);
		painelPrincipal.add(painelSexo);
		painelPrincipal.add(lbCodigo);
		painelPrincipal.add(lbNome);
		painelPrincipal.add(lbCpf);
		painelPrincipal.add(lbRg);
		painelPrincipal.add(lbDataNascimento);
		painelPrincipal.add(lbIdade);
		painelPrincipal.add(tfCodigo);
		painelPrincipal.add(tfNome);
		painelPrincipal.add(tfCpf);
		painelPrincipal.add(tfRg);
		painelPrincipal.add(tfDataNascimento);
		painelPrincipal.add(tfIdade);
		painelPrincipal.add(btSalvar);
		painelPrincipal.add(btCancelar);
		painelPrincipal.add(btNovo);
		painelPrincipal.add(btSair);

		// chamando o método para carregar a combo de estados
		carregarComboEstados();

		// bloqueando a tela ao iniciar
		bloquearTela();

		// configurando a ação do 'X' do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// configurando a visibilidade da tela
		janela.setVisible(true);

	}// fim do método iniciaGui

	/*
	 * Método para bloquear a tela de cadastro
	 */
	private void bloquearTela() {
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		tfCpf.setEditable(false);
		tfRg.setEditable(false);
		tfDataNascimento.setEditable(false);
		tfIdade.setEditable(false);
		tfTelefone.setEditable(false);
		tfCelular.setEditable(false);
		tfEmail.setEditable(false);
		tfLogradouro.setEditable(false);
		tfNomeEndereco.setEditable(false);
		tfNumero.setEditable(false);
		tfComplemento.setEditable(false);
		tfCep.setEditable(false);
		tfCidade.setEditable(false);
		cbxEstados.setEnabled(false);
		rbMasculino.setEnabled(false);
		rbFeminino.setEnabled(false);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}

	/*
	 * Método para liberar os campos da tela de cadastro
	 */
	private void liberarTela() {
		tfCodigo.setEditable(true);
		tfNome.setEditable(true);
		tfCpf.setEditable(true);
		tfRg.setEditable(true);
		tfDataNascimento.setEditable(true);
		tfIdade.setEditable(true);
		tfTelefone.setEditable(true);
		tfCelular.setEditable(true);
		tfEmail.setEditable(true);
		tfLogradouro.setEditable(true);
		tfNomeEndereco.setEditable(true);
		tfNumero.setEditable(true);
		tfComplemento.setEditable(true);
		tfCep.setEditable(true);
		tfCidade.setEditable(true);
		cbxEstados.setEnabled(true);
		rbMasculino.setEnabled(true);
		rbFeminino.setEnabled(true);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
		tfCodigo.grabFocus();
	}

	/*
	 * Método para limpar os campos da tela de cadastro
	 */
	private void limparTela() {
		tfCodigo.setText(null);
		tfNome.setText(null);
		tfCpf.setText(null);
		tfRg.setText(null);
		tfDataNascimento.setText(null);
		tfIdade.setText(null);
		tfTelefone.setText(null);
		tfCelular.setText(null);
		tfEmail.setText(null);
		tfLogradouro.setText(null);
		tfNomeEndereco.setText(null);
		tfNumero.setText(null);
		tfComplemento.setText(null);
		tfCep.setText(null);
		tfCidade.setText(null);
		grpSexo.clearSelection();
		cbxEstados.setSelectedIndex(0);
	}

	/*
	 * Método para preencher a combo de estados
	 */
	private void carregarComboEstados() {
		// valor inicial da combo
		cbxEstados.addItem("-Selecione Estado-");

		// laço de repetição para carregar a como de estados
		for (Estado estado : new EstadoController().getEstados()) {
			cbxEstados.addItem(estado.getNome());
		}
	}// fim do método carregarComboEstados

	/*
	 * Método responsável por receber a ação do clique salvar
	 */
	public void salvar() {

		// salvar o cliente apenas se todos os dados estiverem válidos
		if (validar()) {
			/*
			 * Procedimentos de gravação do objeto Cliente no arquivo txt
			 */
			Cliente cliente = getCliente();

			// chamando o método responsável por gravar o arquivo txt
			new ClienteController().gravarTxtCliente(cliente);

			// limpar a tela preenchida
			limparTela();

			// bloquear a tela
			bloquearTela();

			// exibindo a menasgem de sucesso ao usuário
			JOptionPane.showMessageDialog(null, Mensagem.clienteGravado, Titulo.cadastroCliente, 1);
		}
	}// fim do método salvar

	/*
	 * Método responsável por validar os campos da tela
	 */
	private boolean validar() {

		// validação do campo código
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornando false ao método
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// informando ao usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo data de nascimento
		if (Valida.isEmptyOrNullFormat(tfDataNascimento.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.dataNascimentoVazia, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfDataNascimento.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo idade
		if (Valida.isEmptyOrNull(tfIdade.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazia, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornando false ao método
			return false;
		} else if (!Valida.isInteger(tfIdade.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do radio button de sexo
		if (!rbMasculino.isSelected()) {
			if (!rbFeminino.isSelected()) {
				// informando ao usuário que o sexo não foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroCliente, 0);
				// colocando o foco no campo com erro
				rbMasculino.grabFocus();
				// retornando false ao método
				return false;
			}
		}

		// validação do campo número do cpf
		if (Valida.isEmptyOrNullFormat(tfCpf.getText())) {
			// informando ao usuário que o cpf não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCpf.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo número do rg
		if (Valida.isEmptyOrNullFormat(tfRg.getText())) {
			// informando ao usuário que o rg não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfRg.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo telefone
		if (Valida.isEmptyOrNullFormat(tfTelefone.getText())) {
			// informando ao usuário que o telefone não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.telefoneVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfTelefone.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo celular
		if (Valida.isEmptyOrNullFormat(tfCelular.getText())) {
			// informando ao usuário que o celular não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCelular.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo email
		if (Valida.isEmptyOrNull(tfEmail.getText())) {
			// informando ao usuário que o email não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfEmail.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo logradouro
		if (Valida.isEmptyOrNull(tfLogradouro.getText())) {
			// informando ao usuário que o logradouro não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfLogradouro.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo nome
		if (Valida.isEmptyOrNull(tfNomeEndereco.getText())) {
			// informando ao usuário que o nome do endereço não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeEnderecoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNomeEndereco.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo número do endereço
		if (Valida.isEmptyOrNull(tfNumero.getText())) {
			// informando ao usuário que o número do endereço não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNumero.grabFocus();
			// retornando false ao método
			return false;
		} else if (!Valida.isInteger(tfNumero.getText())) {
			// informando ao usuário que o número do endereço não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNumero.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo cidade
		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			// informando ao usuário que a cidade não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazia, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo número do cep
		if (Valida.isEmptyOrNullFormat(tfCep.getText())) {
			// informando ao usuário que o cep não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCep.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação da combo de estado
		if (cbxEstados.getSelectedIndex() == 0) {
			// informando ao usuário que o estado não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			cbxEstados.grabFocus();
			// retornando false ao método
			return false;
		}

		//
		return true;

	}// fim do método validar

	/*
	 * Método responsável por valorizar um objeto vendedor utilizando os campos da
	 * tela
	 */
	private Cliente getCliente() {
		// intanciando objeto cliente para retorno do método
		Cliente cliente = new Cliente();
		//
		Data data = new Data();
		Endereco endereco = new Endereco();
		//
		String aux[] = tfDataNascimento.getText().split("/");

		// valorizando objeto cliente
		cliente.setCodigo(Util.getInt(tfCodigo.getText()));
		cliente.setNome(tfNome.getText());
		cliente.setCpf(tfCpf.getText());
		cliente.setRg(tfRg.getText());
		cliente.setIdade(Util.getInt(tfIdade.getText()));
		cliente.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');
		cliente.setTelefone(tfTelefone.getText());
		cliente.setCelular(tfCelular.getText());
		cliente.setEmail(tfEmail.getText());

		//
		endereco.setCodigo(Util.getInt(tfCodigo.getText()));
		endereco.setLogradouro(tfLogradouro.getText());
		endereco.setEndereco(tfNomeEndereco.getText());
		endereco.setNumero(Util.getInt(tfNumero.getText()));
		endereco.setComplemento(tfComplemento.getText());
		endereco.setBairro(null);
		endereco.setCidade(tfCidade.getText());
		endereco.setEstado(cbxEstados.getSelectedItem() + "");
		endereco.setCep(tfCep.getText());

		//
		data.setDia(Util.getInt(aux[0]));
		data.setMes(Util.getInt(aux[1]));
		data.setAno(Util.getInt(aux[2]));

		//
		cliente.setEndereco(endereco);
		cliente.setDataNascimento(data);

		// retornando o objeto cliente valorizado
		return cliente;

	}// fim do método getCliente
}// fim da classe
