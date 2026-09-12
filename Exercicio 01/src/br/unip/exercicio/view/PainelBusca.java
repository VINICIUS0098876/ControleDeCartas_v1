package br.unip.exercicio.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PainelBusca extends JPanel {
	private JLabel lblFiltro;
	private JComboBox cboFiltro;
	private JButton btnFiltro, btnSelecionar, btnExcluir;
	private JTable tabela;
	private JScrollPane scroll;
	
	private JPanel painelFiltro;
	private JPanel painelTabela;
	private JPanel painelBotoes;
	
	PainelBusca(){
		this.setLayout(new BorderLayout());
		
		
		painelFiltro = montaPainelFiltro();
		painelTabela = montaPainelTabela();
		painelBotoes = montaPainelBotoes();
		
		this.add(painelFiltro, BorderLayout.NORTH);
		this.add(painelTabela, BorderLayout.CENTER);
		this.add(painelBotoes, BorderLayout.SOUTH);

		
	}
	
	private JPanel montaPainelFiltro() {
		JPanel painelFiltro = new JPanel();
		
		lblFiltro = new JLabel("Tipo");
		cboFiltro = new JComboBox();
		btnFiltro = new JButton("Buscar");
		btnFiltro.setMnemonic(KeyEvent.VK_B);
		
		painelFiltro.add(lblFiltro);
		painelFiltro.add(cboFiltro);
		painelFiltro.add(btnFiltro);
		
		return painelFiltro;
	}
	
	private JPanel montaPainelTabela() {
		JPanel painelTabela = new JPanel();
		
		tabela = new JTable();
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroll = new JScrollPane(tabela);
		
		painelTabela.add(scroll);

		return painelTabela;
	}
	
	private JPanel montaPainelBotoes() {
		JPanel painelBotoes = new JPanel();
		
		painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));


		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setMnemonic(KeyEvent.VK_S);
		btnExcluir = new JButton("Excluir");
		btnExcluir.setMnemonic(KeyEvent.VK_X);
		
		painelBotoes.add(btnSelecionar);
		painelBotoes.add(btnExcluir);
		
		return painelBotoes;
	}
}


