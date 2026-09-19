package br.unip.exercicio.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JanelaBorderLayout extends JFrame implements WindowListener {
	
	private JPanel painelCadastro;
	private JPanel painelBusca;
	
	// Aqui estou criando um construtor para a criação da janela;
	private JanelaBorderLayout() {
		addWindowListener(this);
		
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

		
		return PainelBusca.getInstance();
	}
	
	
	private JPanel montaPainelCadastro() {
	
		return PainelCadastro.getInstance();
	}
	

	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new JanelaBorderLayout().setVisible(true);
		});
	}
	


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
	System.out.println("Fechou!");
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Minimizou!");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
