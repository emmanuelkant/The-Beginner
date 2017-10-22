package view;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Utility;
import model.Client;

public class ClientDialog extends JDialog {

	/** Janela principal do sistema. */
	private MainFrame mainFrame;
	/** Campo de nome. */
	private JTextField nameField;
	/** Campo de CPF. */
	private JTextField cpfField;
	/** Campo de data de nascimento. */
	private JTextField birthdayField;
	/** Cliente sendo editado. Null quando é adição de novo cliente. */
	private Client client;
	/** Linha da tabela selecionada pelo usuário para edição. */
	private int selectedRow;

	/**
	 * Construtor.
	 * 
	 * @param mainFrame
	 *            Janela principal.
	 */
	public ClientDialog(MainFrame mainFrame) {
		this(mainFrame, null, 0);
	}

	/**
	 * Construtor.
	 * 
	 * @param mainFrame
	 *            Janela principal.
	 * @param client Cliente.
	 * @param selectedRow Linha selecionada.
	 */
	public ClientDialog(MainFrame mainFrame, Client client, int selectedRow) {
		this.mainFrame = mainFrame;
		this.client = client;
		this.selectedRow = selectedRow;
		build();
	}

	/**
	 * Constrói a janela.
	 */
	private void build() {
		setLayout(new GridBagLayout());
		buildComponents();
		pack();
		setResizable(false);
		setTitle("Adicionar Cliente");
		setIconImage();
		setLocationRelativeTo(mainFrame);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setVisible(true);
	}

	/**
	 * Constrói os componentes da janela.
	 */
	private void buildComponents() {
		JLabel nameLabel = new JLabel("Nome:");
		add(nameLabel, new GBC(0, 0).left().insets(10, 10, 0, 0));
		nameField = new JTextField(20);
		add(nameField, new GBC(1, 0).insets(10, 10, 0, 0));

		JLabel cpfLabel = new JLabel("CPF:");
		add(cpfLabel, new GBC(0, 1).left().insets(10, 10, 0, 0));
		cpfField = new JTextField(20);
		add(cpfField, new GBC(1, 1).insets(10, 10, 0, 0));

		JLabel birthdayLabel = new JLabel("Nascimento:");
		add(birthdayLabel, new GBC(0, 2).left().insets(10, 10, 0, 0));
		birthdayField = new JTextField(20);
		add(birthdayField, new GBC(1, 2).insets(10, 10, 0, 0));

		JButton saveButton = new JButton("Salvar");
		add(saveButton, new GBC(1, 3).right().insets(10, 10, 0, 0));
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(client != null) {
					mainFrame.updateClient(getClient(), selectedRow);
				} else {
					mainFrame.addClient(getClient());
				}
				ClientDialog.this.dispose();
			}
		});
		
		if(client != null) {
			setFields();
		}
	}

	/**
	 * Configura os campos com os dados de cliente.
	 */
	private void setFields() {
		nameField.setText(client.getName());
		cpfField.setText(client.getCpf());
		cpfField.setEnabled(false);
		birthdayField.setText(Utility.dateToString(client.getBirthday()));
	}

	/**
	 * @return O cliente com as informações inseridas pelo usuário.
	 */
	private Client getClient() {
		return new Client(nameField.getText(), cpfField.getText(), Utility.stringToDate(birthdayField.getText()));
	}

	/**
	 * Define a imagem da logo.
	 */
	private void setIconImage() {
		URL iconURL = getClass().getResource("/images/logo.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
	}

}
