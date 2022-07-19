package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.EstadoController;
import controller.VendedorController;
import model.Estado;
import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe respons�vel por criar a tela de cadastro de Vendedor
 * 
 * @author Victor Baptista
 * @since 04/03/2021
 * @version 1.0
 */
public class CadastrarVendedorView {

	/*
	 * Declarando os atributos da tela
	 */
	private JFrame janela;
	// declarando as labels para exibir os r�tulos na tela
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbAreaVenda;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbSexo;
	private JLabel lbIdade;
	private JLabel lbSalario;
	// declarando os campos de textos para o usu�rio digitar as informa��es
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfAreaVenda;
	private JTextField tfCidade;
	private JTextField tfIdade;
	private JTextField tfSalario;
	// declarando o componente JComboBox
	private JComboBox cbxEstados;
	// declarando os componentes radio button
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	// declarando o componente ButtonGroup respons�vel por gerenciar os componentes
	// radio button
	private ButtonGroup grpSexo;
	// declarando os componentes JButton para executar a��o de clique
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// declarando o componente JPanel para a organiza��o dos componentes
	private JPanel painel;

	// vetor auxiliar para armazenar os estados
	private String estados[] = {};

	/*
	 * M�todo respons�vel por criar a tela
	 */
	public void iniciaGui() {// IN�CIO DO M�TODO iniciaGui

		/*
		 * Configura��o do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o t�tulo da tela
		janela.setTitle("Cadastro de Vendedor");
		// configurando as propor��es da tela - largura, altura
		janela.setSize(580, 355);
		// configurando a posi��o da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * Configura��o do primeiro componente JLabel - (lbCodigo)
		 */
		lbCodigo = new JLabel();
		// configurando o texto inicial da label
		lbCodigo.setText("C�digo:");
		// configurando a posi��o e propor��o do componente
		lbCodigo.setBounds(20, 20, 70, 25);

		/*
		 * Configura��o do segundo componente JLabel - (lbNome)
		 */
		lbNome = new JLabel();
		// configurando o texto inicial da label
		lbNome.setText("Nome:");
		// configurando a posi��o e propor��o do componente
		lbNome.setBounds(20, 50, 70, 25);

		/*
		 * Configura��o do terceiro componente JLabel - (lbAreaVenda)
		 */
		lbAreaVenda = new JLabel();
		// configurando o texto inicial da label
		lbAreaVenda.setText("�rea de Venda:");
		// configurando a posi��o e propor��o do componente
		lbAreaVenda.setBounds(20, 80, 100, 25);

		/*
		 * Configura��o do quarto componente JLabel - (lbCidade)
		 */
		lbCidade = new JLabel();
		// configurando o texto inicial da label
		lbCidade.setText("Cidade:");
		// configurando a posi��o e propor��o do componente
		lbCidade.setBounds(20, 110, 70, 25);

		/*
		 * Configura��o do quinto componente JLabel - (lbEstado)
		 */
		lbEstado = new JLabel();
		// configurando o texto inicial da label
		lbEstado.setText("Estado:");
		// configurando a posi��o e propor��o do componente
		lbEstado.setBounds(20, 140, 70, 25);

		/*
		 * Configura��o do sexto componente JLabel - (lbSexo)
		 */
		lbSexo = new JLabel();
		// configurando o texto inicial da label
		lbSexo.setText("Sexo:");
		// configurando a posi��o e propor��o do componente
		lbSexo.setBounds(20, 170, 70, 25);

		/*
		 * Configura��o do s�timo componente JLabel - (lbIdade)
		 */
		lbIdade = new JLabel();
		// configurando o texto inicial da label
		lbIdade.setText("Idade:");
		// configurando a posi��o e propor��o do componente
		lbIdade.setBounds(20, 200, 70, 25);

		/*
		 * Configura��o do oitavo componente JLabel - (lbSalario)
		 */
		lbSalario = new JLabel();
		// configurando o texto inicial da label
		lbSalario.setText("Sal�rio:");
		// configurando a posi��o e propor��o do componente
		lbSalario.setBounds(20, 230, 70, 25);

		/*
		 * Configura��o do primeiro componente JTextField - (tfCodigo)
		 */
		tfCodigo = new JTextField();
		// configurar a posi��o e a propor��o do componente
		tfCodigo.setBounds(120, 22, 400, 25);

		/*
		 * Configura��o do segundo componente JTextField - (tfNome)
		 */
		tfNome = new JTextField();
		// configurar a posi��o e a propor��o do componente
		tfNome.setBounds(120, 52, 400, 25);

		/*
		 * Configura��o do terceiro componente JTextField - (tfAreaVenda)
		 */
		tfAreaVenda = new JTextField();
		// configurar a posi��o e a propor��o do componente
		tfAreaVenda.setBounds(120, 82, 400, 25);

		/*
		 * Configura��o do quarto componente JTextField - (tfCidade)
		 */
		tfCidade = new JTextField();
		// configurar a posi��o e a propor��o do componente
		tfCidade.setBounds(120, 112, 400, 25);

		/*
		 * Configura��o do quinto componente JTextField - (tfIdade)
		 */
		tfIdade = new JTextField();
		// configurar a posi��o e a propor��o do componente
		tfIdade.setBounds(120, 202, 400, 25);

		/*
		 * Configura��o do sexto componente JTextField - (tfSalario)
		 */
		tfSalario = new JTextField();
		// configurar a posi��o e a propor��o do componente
		tfSalario.setBounds(120, 232, 400, 25);

		/*
		 * Configura��o do componente JComboBox - (cbxEstados)
		 */
		// atribui a lista final no jComboBox
		cbxEstados = new JComboBox(estados);
		// configurando a posi��o e propor��o do componente
		cbxEstados.setBounds(120, 142, 280, 25);

		/*
		 * Configura��o do primeiro componente JRadioButton - (rbMasculino)
		 */
		rbMasculino = new JRadioButton();
		// configurando o texto inicial do radio button
		rbMasculino.setText("Masculino");
		// configurar a posi��o e a propor��o do componente
		rbMasculino.setBounds(120, 172, 85, 25);

		/*
		 * Configura��o do segundo componente JRadioButton - (rbFeminino)
		 */
		rbFeminino = new JRadioButton();
		// configurando o texto inicial do radio button
		rbFeminino.setText("Feminino");
		// configurar a posi��o e a propor��o do componente
		rbFeminino.setBounds(220, 172, 80, 25);

		/*
		 * Configura��o do componente ButtonGroup - (grpSexo)
		 */
		grpSexo = new ButtonGroup();
		// adicionando os componentes JRaldioButton ao componente ButtonGroup
		grpSexo.add(rbMasculino);
		grpSexo.add(rbFeminino);

		/*
		 * Configura��o do primeiro componente JButton - (btSalvar)
		 */
		btSalvar = new JButton();
		// configurando o texto exibido no componente
		btSalvar.setText("Salvar");
		// configurar a posi��o e a propor��o do componente
		btSalvar.setBounds(120, 270, 135, 25);
		//
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});

		/*
		 * Configura��o do segundo componente JButton - (btCancelar)
		 */
		btCancelar = new JButton();
		// configurando o texto exibido no componente
		btCancelar.setText("Cancelar");
		// configurar a posi��o e a propor��o do componente
		btCancelar.setBounds(275, 270, 135, 25);
		//
		btCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// m�todo para limpar os campos da tela
				limparTela();
				// m�todo para bloquear os campos da tela
				bloquearTela();
			}
		});

		/*
		 * Configura��o do segundo componente JButton - (btNovo)
		 */
		btNovo = new JButton();
		// configurando o texto exibido no componente
		btNovo.setText("NOVO");
		// configurar a posi��o e a propor��o do componente
		btNovo.setBounds(120, 270, 135, 25);
		//
		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// m�todo para liberar a edi��o da tela
				liberarTela();
			}
		});

		/*
		 * Configura��o do segundo componente JButton - (btSair)
		 */
		btSair = new JButton();
		// configurando o texto exibido no componente
		btSair.setText("SAIR");
		// configurar a posi��o e a propor��o do componente
		btSair.setBounds(275, 270, 135, 25);
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
		painel.add(lbCodigo);
		painel.add(lbNome);
		painel.add(lbAreaVenda);
		painel.add(lbCidade);
		painel.add(lbEstado);
		painel.add(lbSexo);
		painel.add(lbIdade);
		painel.add(lbSalario);
		painel.add(tfCodigo);
		painel.add(tfNome);
		painel.add(tfAreaVenda);
		painel.add(tfCidade);
		painel.add(tfIdade);
		painel.add(tfSalario);
		painel.add(cbxEstados);
		painel.add(rbMasculino);
		painel.add(rbFeminino);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);

		// chamando o m�todo para carregar a combo de estados
		carregarComboEstados();

		// bloqueando a tela ao iniciar
		bloquearTela();

		// configurando a a��o do 'X' do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// configurando a visibilidade da janela
		janela.setVisible(true);

	}// FIM DO M�TODO iniciaGui

	/*
	 * M�todo para bloquear a tela de cadastro
	 */
	private void bloquearTela() {
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		tfAreaVenda.setEditable(false);
		tfCidade.setEditable(false);
		cbxEstados.setEnabled(false);
		tfIdade.setEditable(false);
		tfSalario.setEditable(false);
		rbMasculino.setEnabled(false);
		rbFeminino.setEnabled(false);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}

	/*
	 * M�todo para liberar os campos da tela de cadastro
	 */
	private void liberarTela() {
		tfCodigo.setEditable(true);
		tfNome.setEditable(true);
		tfAreaVenda.setEditable(true);
		tfCidade.setEditable(true);
		cbxEstados.setEnabled(true);
		tfIdade.setEditable(true);
		tfSalario.setEditable(true);
		rbMasculino.setEnabled(true);
		rbFeminino.setEnabled(true);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
		tfCodigo.grabFocus();
	}

	/*
	 * M�todo para limpar os campos da tela de cadastro
	 */
	private void limparTela() {
		tfCodigo.setText(null);
		tfNome.setText(null);
		tfAreaVenda.setText(null);
		tfCidade.setText(null);
		tfIdade.setText(null);
		tfSalario.setText(null);
		grpSexo.clearSelection();
		cbxEstados.setSelectedIndex(0);
	}

	/*
	 * M�todo para preencher a combo de estados
	 */
	private void carregarComboEstados() {
		// valor inicial da combo
		cbxEstados.addItem("-Selecione Estado-");

		// la�o de repeti��o para carregar a como de estados
		for (Estado estado : new EstadoController().getEstados()) {
			cbxEstados.addItem(estado.getNome());
		}
	}

	/*
	 * M�todo respons�vel por receber a a��o do clique salvar
	 */
	public void salvar() {

		// salvar o vendedor apenas se todos os dados estiverem v�lidos
		if (validar()) {
			/*
			 * Procedimentos de grava��o do objeto Vendedor no arquivo txt
			 */
			Vendedor vendedor = getVendedor();

			// chamando o m�todo respons�vel por gravar o arquivo txt
			new VendedorController().gravarTxtVendedor(vendedor);

			// limpar a tela preenchida
			limparTela();

			// bloquear a tela
			bloquearTela();

			// exibindo a menasgem de sucesso ao usu�rio
			JOptionPane.showMessageDialog(null, Mensagem.vendedorGravado, Titulo.cadastroVendedor, 1);
		}
	}

	/*
	 * M�todo respons�vel por validar os campos da tela
	 */
	private boolean validar() {

		// valida��o do campo c�digo
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// informando ao usu�rio que o c�digo n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornando false ao m�todo
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// informando ao usu�rio que o c�digo n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornando false ao m�todo
			return false;
		}

		// valida��o do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// informando ao usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornando false ao m�todo
			return false;
		}

		// valida��o do campo �rea de venda
		if (Valida.isEmptyOrNull(tfAreaVenda.getText())) {
			// informando ao usu�rio que a �rea de venda n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.areaVendaVazia, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfAreaVenda.grabFocus();
			// retornando false ao m�todo
			return false;
		}

		// valida��o do campo cidade
		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			// informando ao usu�rio que a cidade n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazia, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornando false ao m�todo
			return false;
		}

		// valida��o da combo de estado
		if (cbxEstados.getSelectedIndex() == 0) {
			// informando ao usu�rio que o estado n�o foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			cbxEstados.grabFocus();
			// retornando false ao m�todo
			return false;
		}

		// valida��o do radio button de sexo
		if (!rbMasculino.isSelected()) {
			if (!rbFeminino.isSelected()) {
				// informando ao usu�rio que o sexo n�o foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroVendedor, 0);
				// colocando o foco no campo com erro
				rbMasculino.grabFocus();
				// retornando false ao m�todo
				return false;
			}
		}

		// valida��o do campo idade
		if (Valida.isEmptyOrNull(tfIdade.getText())) {
			// informando ao usu�rio que a idade n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazia, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornando false ao m�todo
			return false;
		} else if (!Valida.isInteger(tfIdade.getText())) {
			// informando ao usu�rio que o c�digo n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornando false ao m�todo
			return false;
		}

		// valida��o do campo salario
		if (Valida.isEmptyOrNull(tfSalario.getText())) {
			// informando ao usu�rio que o sal�rio n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfSalario.grabFocus();
			// retornando false ao m�todo
			return false;
		} else if (!Valida.isDouble(tfSalario.getText())) {
			// informando ao usu�rio que o c�digo n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfSalario.grabFocus();
			// retornando false ao m�todo
			return false;
		}

		// retornando true caso esteja tudo v�lido
		return true;
	}// fim do m�todo validar

	/*
	 * M�todo respons�vel por valorizar um objeto vendedor utilizando os campos da
	 * tela
	 */
	private Vendedor getVendedor() {
		// intanciando objeto vendedor para retorno do m�todo
		Vendedor vendedor = new Vendedor();

		// valorizando objeto vendedor
		vendedor.setCodigo(Util.getInt(tfCodigo.getText()));
		vendedor.setNome(tfNome.getText());
		vendedor.setAreaVenda(tfAreaVenda.getText());
		vendedor.setCidade(tfCidade.getText());
		vendedor.setEstado(cbxEstados.getSelectedItem() + "");

		// condicional tern�ria - if em uma linha
		vendedor.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');

		vendedor.setIdade(Util.getInt(tfIdade.getText()));
		vendedor.setSalario(Util.getDouble(tfSalario.getText()));

		// retornando o objeto vendedor valorizado
		return vendedor;

	}// fim do m�todo getVendedor

}// fim da classe
