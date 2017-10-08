package view;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Person;

/**
 * Classe que é usada para dois momentos, uma para cadastrar novas pessoas e
 * outro para atualizar o cadastro de pessoas que já está cadastradas.
 * 
 * @author Emmanuel Kant
 *
 */
public class PersonDialog extends JDialog {

	/**
	 * Atributo que define se essa instancia da {@code Dialog} será utilizada
	 * para inclusão ou atualização de registros. Se continuar -1, essa
	 * instancia será para adicionar novos cadastros, caso seja direfente de -1
	 * ele utilizará essa instancia para atualizar o registro que está na linha
	 * correspondente.
	 */
	private int selectedRow = -1;
	/** Modelo da tabela de pessoas registradas. */
	private PersonRegistreTableModel tableModel = new PersonRegistreTableModel();

	/**
	 * Construtor da frame que é chamado para criar novos registros.
	 * 
	 * @param largeFrame
	 *            {@code Frame} para orientação dessa {@code Dialog}.
	 */
	public PersonDialog(Component largeFrame) {
		buildDialog(largeFrame);
	}

	/**
	 * Construtor da frame que é chamado para alterar registros já criados
	 * anteriormente.
	 * 
	 * @param largeFrame
	 *            {@code Frame} para orientação dessa {@code Dialog}.
	 * @param selectedRow
	 *            Linha que foi selecionada para ser alterada pelo usuário.
	 */
	public PersonDialog(Component largeFrame, int selectedRow) {
		this.selectedRow = selectedRow;
		buildDialog(largeFrame);
	}

	/**
	 * Método que constrói toda a {@code Dialog}.
	 * 
	 * @param largeFrame
	 *            {@code Frame} para orientação dessa {@code Dialog}.
	 */
	private void buildDialog(Component largeFrame) {
		setLayout(new GridBagLayout());
		buildComponents();
		setTitle("Janela de Terefa");
		pack();
		setResizable(false);
		setLocationRelativeTo(largeFrame);
		setModal(true);
		setDefaultCloseOperation(PersonDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Método que adiciona os componentes na janela.
	 */
	private void buildComponents() {
		// Instanciação.
		JPanel panel = new JPanel(new GridBagLayout());
		JLabel nameLabel = new JLabel("Nome:");
		JLabel cpfLabel = new JLabel("CPF:");
		JTextField nameTextField = new JTextField(20);
		JTextField cpfTextField = new JTextField(20);
		JButton saveButton = new JButton("Salvar");
		/*
		 * Coferindo se essa instancia foi criada para adicionar ou atualizar um
		 * objeto.
		 */
		if (selectedRow != -1) {
			Person toChangePerson = tableModel.getPerson(selectedRow);
			nameTextField.setText(toChangePerson.getName());
			cpfTextField.setText(toChangePerson.getCpf());
			cpfTextField.setEditable(false);
		}
		saveButton.addActionListener(new ActionListener() {

			/**
			 * Ação para quando ele clicar no botão o obejto será adicionado ou
			 * alterado.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedRow != -1) {
					// Porção do código aonde ele é alterado
					Person toChangePerson = tableModel.getPerson(selectedRow);
					if (!toChangePerson.getName().equals("ERROR") && !toChangePerson.getCpf().equals("-999")) {
						toChangePerson.setName(nameTextField.getText());
						tableModel.update(toChangePerson, selectedRow);
						controller.Report.makeReportToUpdate(toChangePerson);
						PersonDialog.this.dispose();
					}
				} else {
					// Porção do código aonde ele é criado.
					Person person = new Person(nameTextField.getText(), cpfTextField.getText(), null, null);
					if (!person.getName().equals("ERROR") && !person.getCpf().equals("-999")) {
						tableModel.addPersonOnTable(person);
						controller.Report.makeReportToRegistre(person);
						PersonDialog.this.dispose();
					}
				}
			}
		});
		// Setando na dialog.
		panel.add(nameLabel, new GBC(0, 0).left().insets(5, 5, 5, 5));
		panel.add(nameTextField, new GBC(1, 0).insets(5, 5, 5, 5));
		panel.add(cpfLabel, new GBC(0, 1).left().insets(5, 5, 5, 5));
		panel.add(cpfTextField, new GBC(1, 1).insets(5, 5, 5, 5));
		panel.add(saveButton, new GBC(1, 3).right().insets(5, 5, 5, 5));
		add(panel);
	}

}
