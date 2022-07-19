package controller;

import javax.swing.UIManager;

import view.MenuPrincipalView;

/**
 * Classe principal responsável por executar o projeto
 * 
 * @author Victor Baptista
 * @since 08/03/2021
 * @version 1.0
 */
public class Main {

	/*
	 * Método responsável por executar a classe
	 */
	public static void main(String[] args) {
		/*
		 * Configurando o estilo inicial do projeto
		 */
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		//inicia o menu principal
		new MenuPrincipalView().iniciaGui();
	}

}
