package br.unip.sicc.exercicio.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JanelaBorderLayout extends JFrame {
	
	private JPanel painelCadastro;
	private JPanel painelBusca;
	
	// Aqui estou criando um construtor para a criação da janela;
	private JanelaBorderLayout() {
		
		painelCadastro = montaPainelCadastro();
		painelBusca = montaPainelBusca();
		
		this.add(painelCadastro, BorderLayout.WEST);
		this.add(painelBusca, BorderLayout.CENTER);
		
		// Definindo o titulo da janela;
		this.setTitle("Controle de Cartas");
		//Definindo o tamanho da janela;
		this.setSize(800, 300);
		//Definindo encerramento da janela;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Centralizando a Janela na tela;
		this.setLocationRelativeTo(null);
		
	}
	
	private JPanel montaPainelBusca() {
		JPanel painelBusca = new JPanel();
		
		painelBusca.setBackground(Color.RED);
		
		return painelBusca;
	}
	
	
	private JPanel montaPainelCadastro() {
	
		return new PainelCadastro();
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new JanelaBorderLayout().setVisible(true);
		});
	}
	
	
	
}
