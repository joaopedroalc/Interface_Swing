package graphic.interfacee;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContatoFrame extends JFrame {
	
	private JTextField nomeField;
	private JTextField telefoneField;
	private JTextField emailField;
	
	public ContatoFrame() {
		super("agenda telefonica");
		
		criarMenu();
		criarFormulario();
	}
	
	private void criarMenu() {
		
		JMenu menuContato = new JMenu("Contato");
		
		NovoAction novoAction = new NovoAction();
		FecharAction fecharAction = new FecharAction();
		SalvarAction salvarAction = new SalvarAction();
		SobreAction sobreAction = new SobreAction();
		
		JMenuItem menuItemNovo = new JMenuItem("Novo");
		menuItemNovo.addActionListener(novoAction);
		menuContato.add(menuItemNovo);
		
		JMenuItem menuItemSalvar = new JMenuItem("Salvar");
		menuItemSalvar.addActionListener(salvarAction);
		menuContato.add(menuItemSalvar);
		
		JMenuItem menuItemFechar = new JMenuItem("Fechar");
		menuItemFechar.addActionListener(fecharAction);
		menuContato.add(menuItemFechar);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		
		JMenuItem menuItemSobre = new JMenuItem("Sobre...");
		menuItemSobre.addActionListener(sobreAction);
		menuAjuda.add(menuItemSobre);
		
		JMenuBar barra = new JMenuBar();
		
		setJMenuBar(barra);
		
		barra.add(menuContato);
		
		barra.add(menuAjuda);
	}
	
	private class NovoAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			nomeField.setText("");
			telefoneField.setText("");
			emailField.setText("");
		}
	}
	
	private class FecharAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	private class SalvarAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "O cadastro foi salvo com sucesso", "Cadastro",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	private class SobreAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "Interface criada por João Pedro Lima para disciplina de Paradigmas de programação", "Sobre...",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	private void criarFormulario() {
		setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("Cadastro de Contato");
		titulo.setFont(new Font("Verdana",Font.PLAIN, 16));
		
		panelTitulo.add(titulo);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(new FlowLayout());
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeField = new JTextField(40);
		
		JLabel telefoneLabel = new JLabel("Telefone");
		telefoneField = new JTextField(40);
		
		JLabel emailLabel = new JLabel("Email");
		emailField = new JTextField(40);
		
		panelCadastro.add(nomeLabel);
		panelCadastro.add(nomeField);
		panelCadastro.add(telefoneLabel);
		panelCadastro.add(telefoneField);
		panelCadastro.add(emailLabel);
		panelCadastro.add(emailField);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		
		SalvarAction salvarAction = new SalvarAction();
		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener((e) -> cadastrar());
		
		FecharAction fecharAction = new FecharAction();
		JButton botaoFechar = new JButton("Fechar");
		botaoFechar.addActionListener(fecharAction);
		
		panelBotoes.add(botaoSalvar);
		panelBotoes.add(botaoFechar);
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelCadastro, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);
	}
	
	private void cadastrar () {
		System.out.println(nomeField.getText());
		System.out.println(telefoneField.getText());
		System.out.println(emailField.getText());
	}
	
}
