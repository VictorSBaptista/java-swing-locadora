package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.FilmeController;
import model.Filme;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe responsável por criar a tela de cadastro de Filme
 * 
 * @author Victor Baptista
 * @since 04/03/2021
 * @version 1.0
 */
public class CadastrarFilmeView {
	/*
	 * Declarando os atributos da tela
	 */
	private JFrame janela;
	// declarando as labels para exibir os rótulos na tela
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbValor;
	private JLabel lbDisponivel;
	private JLabel lbPromocao;
	private JLabel lbValorPromocao;
	private JLabel lbGenero;
	// declarando os campos de textos para o usuário digitar as informações
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfValor;
	private JTextField tfValorPromocao;
	// declarando os componentes radio button
	private JRadioButton rbDisponivelSim;
	private JRadioButton rbDisponivelNao;
	private JRadioButton rbPromocaoSim;
	private JRadioButton rbPromocaoNao;
	// declarando os componentes ButtonGroup responsáveis por gerenciar os
	// componentes radio button
	private ButtonGroup grpDisponivel;
	private ButtonGroup grpPromocao;
	// declarando os componentes checkbox que permitem a seleção de mais de uma
	// opção
	private JCheckBox cbAcao;
	private JCheckBox cbFiccao;
	private JCheckBox cbTerror;
	private JCheckBox cbComedia;
	private JCheckBox cbOutro;
	// declarando os componentes JButton para executar ação de clique
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// declarando o componente JPanel para a organização dos componentes
	private JPanel painel;

	/*
	 * Método responsável por criar a tela
	 */
	public void iniciaGui() {// início do método iniciaGui

		/*
		 * Configuração do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o título da tela
		janela.setTitle("Cadastro de Filme");
		// configurando as proporções da tela - largura, altura
		janela.setSize(580, 350);
		// configurando a posição da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * Configuração do primeiro componente JLabel - (lbCodigo)
		 */
		lbCodigo = new JLabel();
		// configurando o texto inicial da label
		lbCodigo.setText("Código:");
		// configurando a posição e proporção do componente
		lbCodigo.setBounds(20, 15, 70, 25);

		/*
		 * Configuração do segundo componente JLabel - (lbNome)
		 */
		lbNome = new JLabel();
		// configurando o texto inicial da label
		lbNome.setText("Nome:");
		// configurando a posição e proporção do componente
		lbNome.setBounds(20, 45, 70, 25);

		/*
		 * Configuração do terceiro componente JLabel - (lbValor)
		 */
		lbValor = new JLabel();
		// configurando o texto inicial da label
		lbValor.setText("Valor:");
		// configurando a posição e proporção do componente
		lbValor.setBounds(20, 75, 70, 25);

		/*
		 * Configuração do quarto componente JLabel - (lbDisponivel)
		 */
		lbDisponivel = new JLabel();
		// configurando o texto inicial da label
		lbDisponivel.setText("Disponível:");
		// configurando a posição e proporção do componente
		lbDisponivel.setBounds(20, 105, 70, 25);

		/*
		 * Configuração do quinto componente JLabel - (lbPromocao)
		 */
		lbPromocao = new JLabel();
		// configurando o texto inicial da label
		lbPromocao.setText("Promoção:");
		// configurando a posição e proporção do componente
		lbPromocao.setBounds(20, 135, 70, 25);

		/*
		 * Configuração do sexto componente JLabel - (lbValorPromocao)
		 */
		lbValorPromocao = new JLabel();
		// configurando o texto inicial da label
		lbValorPromocao.setText("Valor Promoção:");
		// configurando a posição e proporção do componente
		lbValorPromocao.setBounds(20, 165, 100, 25);

		/*
		 * Configuração do sétimo componente JLabel - (lbGenero)
		 */
		lbGenero = new JLabel();
		// configurando o texto inicial da label
		lbGenero.setText("Gênero:");
		// configurando a posição e proporção do componente
		lbGenero.setBounds(20, 195, 70, 25);

		/*
		 * Configuração do primeiro componente JTextField - (tfCodigo)
		 */
		tfCodigo = new JTextField();
		// configurar a posição e a proporção do componente
		tfCodigo.setBounds(118, 18, 410, 25);

		/*
		 * Configuração do segundo componente JTextField - (tfNome)
		 */
		tfNome = new JTextField();
		// configurar a posição e a proporção do componente
		tfNome.setBounds(118, 48, 410, 25);

		/*
		 * Configuração do terceiro componente JTextField - (tfValor)
		 */
		tfValor = new JTextField();
		// configurar a posição e a proporção do componente
		tfValor.setBounds(118, 78, 410, 25);

		/*
		 * Configuração do quarto componente JTextField - (tfValorPromocao)
		 */
		tfValorPromocao = new JTextField();
		// configurar a posição e a proporção do componente
		tfValorPromocao.setBounds(118, 168, 410, 25);

		/*
		 * Configuração do primeiro componente JRadioButton - (rbDisponivelSim)
		 */
		rbDisponivelSim = new JRadioButton();
		// configurando o texto inicial do radio button
		rbDisponivelSim.setText("Sim");
		// configurar a posição e a proporção do componente
		rbDisponivelSim.setBounds(118, 107, 50, 25);

		/*
		 * Configuração do segundo componente JRadioButton - (rbDisponivelNao)
		 */
		rbDisponivelNao = new JRadioButton();
		// configurando o texto inicial do radio button
		rbDisponivelNao.setText("Não");
		// configurar a posição e a proporção do componente
		rbDisponivelNao.setBounds(175, 107, 50, 25);

		/*
		 * Configuração do primeiro componente JRadioButton - (rbPromocaoSim)
		 */
		rbPromocaoSim = new JRadioButton();
		// configurando o texto inicial do radio button
		rbPromocaoSim.setText("Sim");
		// configurar a posição e a proporção do componente
		rbPromocaoSim.setBounds(118, 137, 50, 25);

		/*
		 * Configuração do primeiro componente JRadioButton - (rbPromocaoNao)
		 */
		rbPromocaoNao = new JRadioButton();
		// configurando o texto inicial do radio button
		rbPromocaoNao.setText("Não");
		// configurar a posição e a proporção do componente
		rbPromocaoNao.setBounds(175, 137, 50, 25);

		/*
		 * Configuração do primeiro componente ButtonGroup - (grpDisponivel)
		 */
		grpDisponivel = new ButtonGroup();
		// adicionando os componentes JRaldioButton ao componente ButtonGroup
		grpDisponivel.add(rbDisponivelSim);
		grpDisponivel.add(rbDisponivelNao);

		/*
		 * Configuração do segundo componente ButtonGroup - (grpPromocao)
		 */
		grpPromocao = new ButtonGroup();
		// adicionando os componentes JRaldioButton ao componente ButtonGroup
		grpPromocao.add(rbPromocaoSim);
		grpPromocao.add(rbPromocaoNao);

		/*
		 * Configuração do primeiro componente JCheckBox - (cbAcao)
		 */
		cbAcao = new JCheckBox();
		// configurando o texto exibido no componente
		cbAcao.setText("Ação");
		// configurando a posição e proporção do componente
		cbAcao.setBounds(118, 197, 55, 25);

		/*
		 * Configuração do segundo componente JCheckBox - (cbFiccao)
		 */
		cbFiccao = new JCheckBox();
		// configurando o texto exibido no componente
		cbFiccao.setText("Ficção");
		// configurando a posição e proporção do componente
		cbFiccao.setBounds(175, 197, 65, 25);

		/*
		 * Configuração do terceiro componente JCheckBox - (cbTerro)
		 */
		cbTerror = new JCheckBox();
		// configurando o texto exibido no componente
		cbTerror.setText("Terror");
		// configurando a posição e proporção do componente
		cbTerror.setBounds(240, 197, 65, 25);

		/*
		 * Configuração do quarto componente JCheckBox - (cbComedia)
		 */
		cbComedia = new JCheckBox();
		// configurando o texto exibido no componente
		cbComedia.setText("Comédia");
		// configurando a posição e proporção do componente
		cbComedia.setBounds(305, 197, 75, 25);

		/*
		 * Configuração do quinto componente JCheckBox - (cbOutro)
		 */
		cbOutro = new JCheckBox();
		// configurando o texto exibido no componente
		cbOutro.setText("Outro");
		// configurando a posição e proporção do componente
		cbOutro.setBounds(380, 197, 65, 25);

		/*
		 * Configuração do primeiro componente JButton - (btSalvar)
		 */
		btSalvar = new JButton();
		// configurando o texto exibido no componente
		btSalvar.setText("Salvar");
		// configurar a posição e a proporção do componente
		btSalvar.setBounds(118, 245, 135, 25);
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
		btCancelar.setBounds(275, 245, 135, 25);
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
		btNovo.setBounds(118, 245, 135, 25);
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
		btSair.setBounds(275, 245, 135, 25);
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
		painel.add(lbValor);
		painel.add(lbDisponivel);
		painel.add(lbPromocao);
		painel.add(lbValorPromocao);
		painel.add(lbGenero);
		painel.add(tfCodigo);
		painel.add(tfNome);
		painel.add(tfValor);
		painel.add(tfValorPromocao);
		painel.add(rbDisponivelSim);
		painel.add(rbDisponivelNao);
		painel.add(rbPromocaoSim);
		painel.add(rbPromocaoNao);
		painel.add(cbAcao);
		painel.add(cbFiccao);
		painel.add(cbTerror);
		painel.add(cbComedia);
		painel.add(cbOutro);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);

		// bloqueando a tela ao iniciar
		bloquearTela();

		// configurando a ação do 'X' do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// configura a visibilidade da janela
		janela.setVisible(true);

	}// fim do método iniciaGui

	/*
	 * Método para bloquear a tela de cadastro
	 */
	private void bloquearTela() {
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		tfValor.setEditable(false);
		tfValorPromocao.setEditable(false);
		rbDisponivelSim.setEnabled(false);
		rbDisponivelNao.setEnabled(false);
		rbPromocaoSim.setEnabled(false);
		rbPromocaoNao.setEnabled(false);
		cbAcao.setEnabled(false);
		cbFiccao.setEnabled(false);
		cbComedia.setEnabled(false);
		cbTerror.setEnabled(false);
		cbOutro.setEnabled(false);
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
		tfValor.setEditable(true);
		tfValorPromocao.setEditable(true);
		rbDisponivelSim.setEnabled(true);
		rbDisponivelNao.setEnabled(true);
		rbPromocaoSim.setEnabled(true);
		rbPromocaoNao.setEnabled(true);
		cbAcao.setEnabled(true);
		cbFiccao.setEnabled(true);
		cbComedia.setEnabled(true);
		cbTerror.setEnabled(true);
		cbOutro.setEnabled(true);
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
		tfValor.setText(null);
		tfValorPromocao.setText(null);
		grpDisponivel.clearSelection();
		grpPromocao.clearSelection();
		cbAcao.setSelected(false);
		cbFiccao.setSelected(false);
		cbComedia.setSelected(false);
		cbTerror.setSelected(false);
		cbOutro.setSelected(false);

	}

	/*
	 * Método responsável por receber a ação do clique salvar
	 */
	public void salvar() {

		// salvar o filme apenas se todos os dados estiverem válidos
		if (validar()) {
			/*
			 * Procedimentos de gravação do objeto Filme no arquivo txt
			 */
			Filme filme = getFilme();

			// chamando o método responsável por gravar o arquivo txt
			new FilmeController().gravarTxtFilme(filme);

			// limpar a tela preenchida
			limparTela();

			// bloquear a tela
			bloquearTela();

			// exibindo a menasgem de sucesso ao usuário
			JOptionPane.showMessageDialog(null, Mensagem.filmeGravado, Titulo.cadastroFilme, 1);
		}
	}// fim do método salvar

	/*
	 * Método responsável por validar os campos da tela
	 */
	private boolean validar() {

		// validação do campo código
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornando false ao método
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// informando ao usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// informando ao usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do campo valor
		if (Valida.isEmptyOrNull(tfValor.getText())) {
			// informando ao usuário que o valor não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.valorVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValor.grabFocus();
			// retornando false ao método
			return false;
		} else if (!Valida.isDouble(tfValor.getText())) {
			// informando ao usuário que o valor não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValor.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do radio button de disponibilidade
		if (!rbDisponivelSim.isSelected()) {
			if (!rbDisponivelNao.isSelected()) {
				// informando ao usuário que o sexo não foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.disponivelVazio, Titulo.cadastroFilme, 0);
				// colocando o foco no campo com erro
				rbDisponivelSim.grabFocus();
				// retornando false ao método
				return false;
			}
		}

		// validação do radio button de promoção
		if (!rbPromocaoSim.isSelected()) {
			if (!rbPromocaoNao.isSelected()) {
				// informando ao usuário que o sexo não foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.promocaoVazio, Titulo.cadastroFilme, 0);
				// colocando o foco no campo com erro
				rbPromocaoSim.grabFocus();
				// retornando false ao método
				return false;
			}
		}

		// validação do campo valor de promoção
		if (Valida.isEmptyOrNull(tfValorPromocao.getText())) {
			// informando ao usuário que o valor promoção não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.valorPromocaoVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValorPromocao.grabFocus();
			// retornando false ao método
			return false;
		} else if (!Valida.isDouble(tfValorPromocao.getText())) {
			// informando ao usuário que o valor promoção não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.valorPromocaoInvalido, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValorPromocao.grabFocus();
			// retornando false ao método
			return false;
		}

		// validação do checkbox de gênero
		if (!cbAcao.isSelected() && !cbFiccao.isSelected() && !cbComedia.isSelected() && !cbTerror.isSelected()
				&& !cbOutro.isSelected()) {
			// informando ao usuário que o gênero não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.generoVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			cbAcao.grabFocus();
			// retornando false ao método
			return false;
		}

		return true;
	}// fim do método validar

	/*
	 * Método responsável por valorizar um objeto filme utilizando os campos da tela
	 */
	private Filme getFilme() {
		// instanciando objeto filme para retorno do método
		Filme filme = new Filme();

		// valorizando objeto vendedor
		filme.setCodigo(Util.getInt(tfCodigo.getText()));
		filme.setNome(tfNome.getText());
		filme.setValor(Util.getDouble(tfValor.getText()));
		filme.setValorPromocao(Util.getDouble(tfValorPromocao.getText()));
		// condicional ternária - if em uma linha
		filme.setDisponivel((rbDisponivelSim.isSelected()) ? true : false);
		filme.setPromocao((rbPromocaoSim.isSelected()) ? true : false);

		// atribui ao objeto filme os gêneros selecionados pelo usuário
		if (cbAcao.isSelected()) {
			if (filme.getGenero() == null) {
				filme.setGenero(cbAcao.getText() + ";");
			} else {
				filme.setGenero(filme.getGenero() + cbAcao.getText() + ";");
			}
		}
		if (cbFiccao.isSelected()) {
			filme.setGenero(filme.getGenero() + cbFiccao.getText() + ";");
		}
		if (cbTerror.isSelected()) {
			filme.setGenero(filme.getGenero() + cbTerror.getText() + ";");
		}
		if (cbComedia.isSelected()) {
			filme.setGenero(filme.getGenero() + cbComedia.getText() + ";");
		}
		if (cbOutro.isSelected()) {
			filme.setGenero(filme.getGenero() + cbOutro.getText() + ";");
		}

		// retornando o objeto filme valorizado
		return filme;

	}// fim do método getFilme
}// fim da classe
