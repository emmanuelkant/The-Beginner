package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		buildMenu();
		setSize(400, 300);
		setIconImage();
		setMinimumSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Constrói o menu.
	 */
	private void buildMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu helpMenu = new JMenu("Ajuda");
		menuBar.add(helpMenu);

		JMenuItem aboutItem = new JMenuItem("Sobre");
		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AboutDialog(MainFrame.this);
			}
		});
		helpMenu.add(aboutItem);

		JMenuItem exitItem = new JMenuItem("Sair");
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		helpMenu.add(exitItem);

		setJMenuBar(menuBar);
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
