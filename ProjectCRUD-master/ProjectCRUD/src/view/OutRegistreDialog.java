package view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Person;

/**
 * Classe na janela que é mostrada ao adicionar alguem à lista de saída.
 * 
 * @author Emmanuel Kant
 *
 */
public class OutRegistreDialog extends JDialog {

	private JTable table = new JTable();
	private PersonInTableModel tableModel = new PersonInTableModel();

	/**
	 * Construtor da frmae.
	 * 
	 * @param largeFrame
	 *            Utilizada para orientação da janela.
	 */
	public OutRegistreDialog(WorkFrame largeFrame) {
		buildComponents(largeFrame);
	}

	/**
	 * Cria os componentes dessa {@code JDialog}.
	 * 
	 * @param largeFrame
	 *            Utilizada para orientação da janela.
	 */
	private void buildComponents(WorkFrame largeFrame) {
		setLayout(new GridBagLayout());
		buildContent(tableModel);
		setModal(true);
		setTitle("Lista dos Internos");
		setSize(650, 300);
		setMinimumSize(new Dimension(650, 300));
		setLocationRelativeTo(largeFrame);
		setDefaultCloseOperation(OutRegistreDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Método que constroi o conteudo da janela.
	 * 
	 * @param tableModel
	 *            Modelo da Tabela que será criada posteriormente.
	 */
	private void buildContent(PersonInTableModel tableModel) {
		JPanel panel = new JPanel(new GridBagLayout());
		buildButtons(tableModel);
		buildTable(tableModel, panel);
		add(panel, new GBC(0, 0).both());
	}

	/**
	 * Método que constrói todos os botões da janela e suas ações.
	 * 
	 * @param tableModel
	 *            Modelo da Tabela que será criada.
	 */
	private void buildButtons(PersonInTableModel tableModel) {
		JPanel panel = new JPanel(new GridBagLayout());
		JButton addButton = new JButton("Adicionar");
		JButton returnButton = new JButton("Voltar");
		// Adicionando função aos botões.
		addButton.addActionListener(new ActionListener() {

			/**
			 * Ao clicar, adiciona a linha selecionada na lista de pessoas que
			 * sairam do local.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRowCount();
				if (i == 1) {
					PersonOutTableModel outTableModel = new PersonOutTableModel();
					Person newPerson = tableModel.getPerson(table.getSelectedRow());
					outTableModel.add(newPerson);
					tableModel.delete(newPerson);
					tableModel.fireTableDataChanged();
					controller.Report.makeReportToOut(newPerson);
					OutRegistreDialog.this.dispose();
				} else if (i == 0) {
					JOptionPane.showMessageDialog(OutRegistreDialog.this, "Nenhuma linha foi selecionada!");
				} else {
					JOptionPane.showMessageDialog(OutRegistreDialog.this, "Só é possivel alterar uma linha por vez!");
				}

			}
		});
		returnButton.addActionListener(new ActionListener() {

			/**
			 * Ao clicar, fecha a {@code Dialog} retorna para a tela principal.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				OutRegistreDialog.this.dispose();
			}
		});
		panel.add(addButton, new GBC(0, 0).both().insets(5, 5, 5, 5));
		panel.add(returnButton, new GBC(0, 2).both().insets(5, 5, 5, 5));
		add(panel, new GBC(1, 0).top());

	}

	/**
	 * Método que constrói a tabela da janela.
	 * 
	 * @param tableModel
	 *            Modelo da Tabela que será usada para montar os dados da
	 *            tabela.
	 * @param panel
	 *            Painel da janela.
	 */
	private void buildTable(PersonInTableModel tableModel, JPanel panel) {
		this.table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, new GBC(0, 0).both().insets(5, 5, 5, 5));
	}

}
