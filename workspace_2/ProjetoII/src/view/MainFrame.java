package view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.ClientDAO;
import model.Client;

/**
 * Janela principal do sistema.
 */
public class MainFrame extends JFrame {

	/** Tabela com os clientes do sistema. */
	private JTable table;

	/**
	 * Construtor.
	 */
	public MainFrame() {
		build();
	}

	/**
	 * Constrói a janela.
	 */
	private void build() {
		setLayout(new GridBagLayout());
		buildMenu();
		setTitle("Gestão de Clientes");
		buildComponents();
		setSize(600, 400);
		setIconImage();
		setMinimumSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Constrói os componentes da janela.
	 */
	private void buildComponents() {
		buildMainPanel();
		buildButtonPanel();
	}

	/**
	 * Constrói o painel principal.
	 */
	private void buildMainPanel() {
		JPanel panel = new JPanel(new GridBagLayout());

		String[] items = { "Nome", "CPF" };
		JComboBox<String> comboBox = new JComboBox<>(items);
		panel.add(comboBox, new GBC(0, 0));

		JTextField searchField = new JTextField(20);
		panel.add(searchField, new GBC(1, 0).horizontal());

		buildTable(panel);

		add(panel, new GBC(0, 0).both().insets(10, 5, 5, 0));
	}

	/**
	 * Constrói a tabela.
	 * 
	 * @param panel
	 *            Painel principal.
	 */
	private void buildTable(JPanel panel) {
		table = new JTable();
		table.setModel(new ClientTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, new GBC(0, 1).gridwh(2, 1).both());
	}

	/**
	 * Constrói o painel de botões.
	 */
	private void buildButtonPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		JButton newButton = new JButton("Novo");
		panel.add(newButton, new GBC(0, 0).horizontal());
		newButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ClientDialog(MainFrame.this);
			}
		});

		JButton editButton = new JButton("Alterar");
		panel.add(editButton, new GBC(0, 1));
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				ClientTableModel model = (ClientTableModel) table.getModel();
				Client client = model.getRow(selectedRow);
				new ClientDialog(MainFrame.this, client, table.getSelectedRow());
			}
		});

		JButton deleteButton = new JButton("Excluir");
		panel.add(deleteButton, new GBC(0, 2));
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeClient(table.getSelectedRow());
			}
		});

		add(panel, new GBC(1, 0));
	}

	/**
	 * Constrói o menu.
	 */
	private void buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu helpMenu = new JMenu("Ajuda");
		menuBar.add(helpMenu);
		JMenuItem aboutItem = new JMenuItem("Sobre");
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutDialog(MainFrame.this);
			}
		});

		JMenuItem exitItem = new JMenuItem("Sair");
		helpMenu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * Define a imagem da logo.
	 */
	private void setIconImage() {
		URL iconURL = getClass().getResource("/images/logo.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
	}

	/**
	 * Adiciona um cliente.
	 * 
	 * @param client Cliente.
	 */
	public void addClient(Client client) {
		ClientTableModel model = (ClientTableModel) table.getModel();
		// Add on DB.
		ClientDAO.insert(client);
		model.addClient(client);
	}
	
	/**
	 * Atualiza um cliente.
	 * 
	 * @param client Cliente.
	 * @param selectedRow Linha selecionada pelo usuário.
	 */
	public void updateClient(Client client, int selectedRow) {
		ClientTableModel model = (ClientTableModel) table.getModel();
		// aqui
		model.updateClient(client, selectedRow);
	}
	
	/**
	 * Remove um cliente.
	 */
	private void removeClient(int selectedRow) {
		ClientTableModel model = (ClientTableModel) table.getModel();
		model.removeClient(selectedRow);
	}

}
