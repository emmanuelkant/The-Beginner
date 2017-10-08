package view;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Report;

/**
 * Classe responsavel pela tela de loguin.
 * 
 * @author Roma Jhonatan
 *
 */
public class MainFrame extends JFrame{
	
	/**
	 * Costrutor da classe.
	 */
	public MainFrame(){
		buildFrame();
	}
	
	/**
	 * Método que cria a janela es seus componentes.
	 * 
	 */
	private void buildFrame() {		
		setLayout(new GridBagLayout());
		buildComponents();
		setTitle("Login");
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(MainFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			/**
			 * Método criado para confirmar a parada do sistema.
			 */
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane.showConfirmDialog(MainFrame.this, "Você deseja realmente fechar o programa?",
						"Aviso", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					System.out.println(new Report().toString());
					System.exit(0);
				}
			}
		});
		setVisible(true);
	}
	
	/**
	 * Constrói o conteúdo da tela.
	 */
	private void buildComponents() {
		// Instanciação.
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel labelLogin = new JLabel("Login: ");	
		JTextField textFieldLogin = new JTextField(20);
		JLabel labelPassword = new JLabel("Senha: ");		
		JPasswordField passwordField = new JPasswordField(20);		
		JButton buttonLogar = new JButton("Logar");
		//Ação do botão logar
		buttonLogar.addActionListener(new ActionListener() {
			
			/**
			 * Verifica se o login e senha estão corretos.
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String loguin, senha;
				loguin = textFieldLogin.getText();
				senha  = new String (passwordField.getPassword());
				
				if (loguin.equals("admin") && senha.equals("admin")) {
					new WorkFrame(MainFrame.this);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Login ou Senha incorreto!!!");
				}
				
			}
		});
		// Setando na dialog.
		panel.add(labelLogin, new GBC(0,0).left());
		panel.add(textFieldLogin, new GBC(1,0).right());
		panel.add(labelPassword, new GBC(0,1).left());
		panel.add(passwordField, new GBC(1,1).right());
		panel.add(buttonLogar, new GBC(1,2).right());
		add(panel);
	}
	
}
