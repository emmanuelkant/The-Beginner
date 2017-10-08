package view;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe responsavel pela tela de sobre.
 * 
 * @author Roma Jhonatan
 *
 */
public class About extends JFrame {
	
	/**
	 * Costrutor da classe.
	 */
	public About(JFrame jWorkFrame){
		buildFrame(jWorkFrame);
	}
	
	/**
	 * Método que cria a janela es seus componentes.
	 * 
	 */
	private void buildFrame(JFrame jWorkFrame) {
		setLayout(new GridBagLayout());
		buildComponents();
		setTitle("Sobre");
		setSize(300, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * Constrói o conteúdo da tela.
	 */
	private void buildComponents() {
		// Instanciação.
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel labelNameProgram = new JLabel("InOutControl");
		JLabel labelVersion = new JLabel("Versão: 1.0");
		JLabel labelCreator = new JLabel("Criadores:");
		JLabel labelEma = new JLabel("Emmanuel Kant");
		JLabel labelRoma = new JLabel("Romario Jhonatan");
		// Setando na dialog.
		panel.add(labelNameProgram, new GBC(0,0).center());
		panel.add(labelVersion, new GBC(0,1).center());
		panel.add(labelCreator, new GBC(0,2).center());
		panel.add(labelEma, new GBC(0,3).center());
		panel.add(labelRoma, new GBC(0,4).center());
		add(panel);
	}

}
