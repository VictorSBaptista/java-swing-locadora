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
 * Classe responsável por criar a tela de cadastro de Vendedor
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
	// declarando as labels para exibir os rótulos na tela
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbAreaVenda;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbSexo;
	private JLabel lbIdade;
	private JLabel lbSalario;
	// declarando os campos de textos para o usuário digitar as informações
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
	// declarando o componente ButtonGroup responsável por gerenciar os componentes
	// radio button
	private ButtonGroup grpSexo;
	// declarando os componentes JButton para executar ação de clique
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// declarando o componente JPanel para a organização dos componentes
	private JPanel painel;

	// vetor auxiliar para armazenar os estados
	private String estados[] = {};

	/*
	 * Método responsável por criar a tela
	 */
	public void iniciaGui() {// INÍCIO DO MÉTODO iniciaGui

		/*
		 * Configuração do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o título da tela
		janela.setTitle("Cadastro de Vendedor");
		// configurando as proporções da tela - largura, altura
		janela.setSize(580, 355);
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
		lbNome.setBounds(20, 50, 70, 25);

		/*
		 * Configuração do terceiro componente JLabel - (lbAreaVenda)
		 */
		lbAreaVenda = new JLabel();
		// configurando o texto inicial da label
		lbAreaVenda.setText("Área de Venda:");
		// configurando a posição e proporção do componente
		lbAreaVenda.setBounds(20, 80, 100, 25);

		/*
		 * Configuração do quarto componente JLabel - (lbCidade)
		 */
		lbCidade = new JLabel();
		// configurando o texto inicial da label
		lbCidade.setText("Cidade:");
		// configurando a posição e proporção do componente
		lbCidade.setBounds(20, 110, 70, 25);

		/*
		 * Configuração do quinto componente JLabel - (lbEstado)
		 */
		lbEstado = new JLabel();
		// configurando o texto inicial da label
		lbEstado.setText("Estado:");
		// configurando a posição e proporção do componente
		lbEstado.setBounds(20, 140, 70, 25);

		/*
		 * Configuração do sexto componente JLabel - (lbSexo)
		 */
		lbSexo = new JLabel();
		// configurando o texto inicial da label
		lbSexo.setText("Sexo:");
		// configurando a posição e proporção do componente
		lbSexo.setBounds(20, 170, 70, 25);

		/*
		 * Configuração do sétimo componente JLabel - (lbIdade)
		 */
		lbIdade = new JLabel();
		// configurando o texto inicial da label
		lbIdade.setText("Idade:");
		// configurando a posição e proporção do componente
		lbIdade.setBounds(20, 200, 70, 25);

		/*
		 * Configuração do oitavo componente JLabel - (lbSalario)
		 */
		lbSalario = new JLabel();
		// configurando o texto inicial da label
		lbSalario.setText("Salário:");
		// configurando a posição e proporção do componente
		lbSalario.setBounds(20, 230, 70, 25);

		/*
		 * Configuração do primeiro componente JTextField - (tfCodigo)
		 */
		tfCodigo = new JTextField();
		// configurar a posição e a proporção do componente
		tfCodigo.setBounds(120, 22, 400, 25);

		/*
		 * Configuração do segundo componente JTextField - (tfNome)
		 */
		tfNome = new JTextField();
		// configurar a posição e a proporção do componente
		tfNome.setBounds(120, 52, 400, 25);

		/*
		 * Configuração do terceiro componente JTextField - (tfAreaVenda)
		 */
		tfAreaVenda = new JTextField();
		// configurar a posição e a proporção do componente
		tfAreaVenda.setBounds(120, 82, 400, 25);

		/*
		 * Configuração do quarto componente JTextField - (tfCidade)
		 */
		tfCidade = new JTextField();
		// configurar a posição e a proporção do componente
		tfCidade.setBounds(120, 112, 400, 25);

		/*
		 * Configuração do quinto componente JTextField - (tfIdade)
		 */
		tfIdade = new JTextField();
		// configurar a posição e a proporção do componente
		tfIdade.setBounds(120, 202, 400, 25);

		/*
		 * Configuração do sexto componente JTextField - (tfSalario)
		 */
		tfSalario = new JTextField();
		// configurar a posição e a proporção do componente
		tfSalario.setBounds(120, 232, 400, 25);

		/*
		 * Configuração do componente JComboBox - (cbxEstados)
		 */
		// atribui a lista final no jComboBox
		cbxEstados = new JComboBox(estados);
		// configurando a posição e proporção do componente
		cbxEstados.setBounds(120, 142, 280, 25);

		/*
		 * Configuração do primeiro componente JRadioButton - (rbMasculino)
		 */
		rbMasculino = new JRadioButton();
		// configurando o texto inicial do radio button
		rbMasculino.setText("Masculino");
		// configurar a posição e a proporção do componente
		rbMasculino.setBounds(120, 172, 85, 25);

		/*
		 * Configuração do segundo componente JRadioButton - (rbFeminino)
		 */
		rbFeminino = new JRadioButton();
		// configurando o texto inicial do radio button
		rbFeminino.setText("Feminino");
		// configurar a posição e a proporção do componente
		rbFeminino.setBounds(220, 172, 80, 25);

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
		btSalvar.setBounds(120, 270, 135, 25);
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
		btCancelar.setBounds(275, 270, 135, 25);
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
		btNovo.setBounds(120, 270, 135, 25);
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
		btSair.setBounds(275, 270, 135, 25);
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

		// chamando o método para carregar a combo de estados
		carregarComboEstados();

		// bloqueando a tela ao iniciar
		bloquearTela();

		// configurando a ação do 'X' do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// configurando a visibilidade da janela
		janela.setVisible(true);

	}// FIM DO MÉTODO iniciaGui

	/*
	 * Método para bloquear a tela de cadastro
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
	 * Método para liberar os campos da tela de cadastro
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
	 * Método para limpar os campos da tela de cadastro
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
	 * Método para preencher a combo de estados
	 */
	private void carregarComboEstados() {
		// valor inicial da combo
		cbxEstados.addItem("-Selecione Estado-");

		// laço de repetição para carregar a como de estados
		for (Estado estado : new EstadoController().getEstados()) {
			cbxEstados.addItem(estado.getNome());
		}
	}

	/*
	 * Método responsável por receber a ação do clique salvar
	 */
	public void salvar() {

		// salvar o vendedor apenas se todos os dados estiverem válidos
		if (validar()) {
			/*
			 * Procedimentos de gravação do objeto Vendedor no arquivo txt
			 */
			Vendedor vendedor = getVendedor();

			// chamando o método responsável por gravar o arquivo txt
			new VendedorController().gravarTxtVendedor(vendedor);

			// limpar a tela preenchida
			limparTela();

			// bloquear a tela
			bloquearTela();

			// exibindo a menasgem de sucesso ao usuário
			JOptionPane.showMessageDialog(null, Mensagem.vendedorGravado, Titulo.cadastroVendedor, 1);
		}
	}

	/*
	 * Método responsável por validar os campos da tela
	 */
	private boolean validar() {

		// validação do campo código
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornando false ao método
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// informando ao usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo área de venda
		if (Valida.isEmptyOrNull(tfAreaVenda.getText())) {
			// informando ao usuário que a área de venda não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.areaVendaVazia, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfAreaVenda.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo cidade
		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			// informando ao usuário que a cidade não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazia, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação da combo de estado
		if (cbxEstados.getSelectedIndex() == 0) {
			// informando ao usuário que o estado não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			cbxEstados.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do radio button de sexo
		if (!rbMasculino.isSelected()) {
			if (!rbFeminino.isSelected()) {
				// informando ao usuário que o sexo não foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroVendedor, 0);
				// colocando o foco no campo com erro
				rbMasculino.grabFocus();
				// retornando false ao método
				return false;
			}
		}

		// validação do campo idade
		if (Valida.isEmptyOrNull(tfIdade.getText())) {
			// informando ao usuário que a idade não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazia, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornando false ao método
			return false;
		} else if (!Valida.isInteger(tfIdade.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo salario
		if (Valida.isEmptyOrNull(tfSalario.getText())) {
			// informando ao usuário que o salário não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfSalario.grabFocus();
			// retornando false ao método
			return false;
		} else if (!Valida.isDouble(tfSalario.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfSalario.grabFocus();
			// retornando false ao método
			return false;
		}

		// retornando true caso esteja tudo válido
		return true;
	}// fim do método validar

	/*
	 * Método responsável por valorizar um objeto vendedor utilizando os campos da
	 * tela
	 */
	private Vendedor getVendedor() {
		// intanciando objeto vendedor para retorno do método
		Vendedor vendedor = new Vendedor();

		// valorizando objeto vendedor
		vendedor.setCodigo(Util.getInt(tfCodigo.getText()));
		vendedor.setNome(tfNome.getText());
		vendedor.setAreaVenda(tfAreaVenda.getText());
		vendedor.setCidade(tfCidade.getText());
		vendedor.setEstado(cbxEstados.getSelectedItem() + "");

		// condicional ternária - if em uma linha
		vendedor.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');

		vendedor.setIdade(Util.getInt(tfIdade.getText()));
		vendedor.setSalario(Util.getDouble(tfSalario.getText()));

		// retornando o objeto vendedor valorizado
		return vendedor;

	}// fim do método getVendedor

}// fim da classe
