	package br.unip.exercicio.view;
	
	import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import javax.swing.SwingUtilities;
	
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	
	public class PainelCadastro extends JPanel {
		private JLabel lblId;
		private JLabel lblNome;
		private JTextField txtId;
		private JTextField txtNome;
		private JButton btnSalvar;
		private JButton btnCancelar;
		
		private JPanel painelCadastro;
		private JPanel painelBotao;
		
		private static PainelCadastro instance;
		
		 private PainelCadastro() {
			this.setLayout(new BorderLayout());
			
			painelCadastro = montaPainelCadastro();
			painelBotao = montaPainelBotao();
			 
			this.add(painelCadastro, BorderLayout.NORTH);
			this.add(painelBotao, BorderLayout.SOUTH);
		}
		 
		 public static PainelCadastro getInstance() {
			 if(instance == null) {
				 instance = new PainelCadastro();
			 }else {
				 System.out.println("Painel ja cadastrado!");
			 }
			 
			 return instance;
		 }
		 
		 private class SimulaDemoraAoSalvar implements Runnable{
			 @Override
			 public void run() {
				 try {
					 System.out.println("Salvando dados no banco...");
					 Thread.sleep(10000);
					 System.out.println("Salvamento concluido");
				 }catch(InterruptedException e) {
					 e.printStackTrace();
				 }finally {
					 SwingUtilities.invokeLater(new Runnable() {
						 @Override
						 public void run() {
							 btnSalvar.setEnabled(true);
						 }
					 });
				 }
			 }
		 }
		 
		 private class Salvar implements ActionListener{
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 btnSalvar.setEnabled(false);
				 
				 Thread threadDemorada = new Thread(new SimulaDemoraAoSalvar());
				 threadDemorada.start();
			 }
		 }
		 
		 
		
		
		private JPanel montaPainelCadastro() {
			JPanel painelCadastro = new JPanel();
		
			painelCadastro.setLayout(new GridLayout(2, 2));
			
			lblId = new JLabel("id");
			txtId = new JTextField();
			txtId.setEnabled(false);
			lblNome = new JLabel("Nome");
			txtNome = new JTextField();
			txtNome.setColumns(10);
			
			painelCadastro.add(lblId);
			painelCadastro.add(txtId);
			painelCadastro.add(lblNome);
			painelCadastro.add(txtNome);
			
			
			return painelCadastro;
		}
		
		private JPanel montaPainelBotao() {
			JPanel painelBotao = new JPanel();
			
			painelBotao.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(new Salvar());
			
			
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Simulando Cancelar!");
				}
			});
			btnCancelar.setMnemonic(KeyEvent.VK_C);
			
			painelBotao.add(btnCancelar);
			painelBotao.add(btnSalvar);
			
			return painelBotao;
		}
		
		
		
		
	}

	
	