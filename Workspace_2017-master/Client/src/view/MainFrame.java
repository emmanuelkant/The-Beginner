package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Janela principal do sistema.
 */

public class MainFrame extends JFrame {
	/**
	 * Contrutor.
	 */
	public MainFrame() {
		build();
	}

	/**
	 * Constrói a Janela.
	 */
	private void build() {
		setSize(400, 300);
		setIconImage();
		setMinimumSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		System.exit(0);
		
	}

	private void setIconImage() {
		URL iconURL = getClass().getResource("/images/Chrysanthemum.jpg");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
	}

}
