package view;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * Frame sobre.
 */
public class AboutDialog extends JDialog{
	
	/**
	 * Contrutor da classe.
	 * 
	 * @param mainFrame Frame principal do sistema
	 */
	public AboutDialog(MainFrame mainFrame){
		build(mainFrame);
	}
	
	/**
	 * Cronstrói menu.
	 * 
	 * @param mainFrame Frame para a orientação do Dialog 
	 */
	private void build(MainFrame mainFrame) {
		addComponets();
		setSize(200, 200);
		setMinimumSize(new Dimension(300, 200));
		setLocationRelativeTo(mainFrame);
		setIconImage();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private void addComponets() {
		String s = "Programa de Gestão de Clientes - Versão 1.0";
		JLabel label = new JLabel(s);
		add(label);
	}

	/**
	 * Colocar imagem da tela.
	 */
	private void setIconImage() {
		URL iconURL = getClass().getResource("/images/Chrysanthemum.jpg");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
	}
}
