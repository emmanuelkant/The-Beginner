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
 * Classe na janela que � mostrada ao adicionar alguem � lista de entrada.
 * 
 * @author Emmanuel Kant
 *
 */
public class EntranceRegistreDialog extends JDialog {

	private JTable table = new JTable();
	private PersonRegistreTableModel tableModel = new PersonRegistreTableModel();

	/**
	 * Construtor da frmae.
	 * 
	 * @param largeFrame
	 *            Utilizada para orienta��o da janela.
	 */
	public EntranceRegistreDialog(WorkFrame largeFrame) {
		buildComponents(largeFrame);
	}

	/**
	 * Cria os componentes dessa {@code JDialog}.
	 * 
	 * @param largeFrame
	 *            Utilizada para orienta��o da janela.
	 */
	private void buildComponents(WorkFrame largeFrame) {
		setLayout(new GridBagLayout());
		buildContent(tableModel);
		setModal(true);
		setTitle("Lista dos Cadastrados");
		setSize(650, 300);
		setMinimumSize(new Dimension(500, 300));
		setLocationRelativeTo(largeFrame);
		setDefaultCloseOperation(EntranceRegistreDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * M�todo que constroi o conteudo da janela.
	 * 
	 * @param tableModel
	 *            Modelo da Tabela que ser� criada posteriormente.
	 */
	private void buildContent(PersonRegistreTableModel tableModel) {
		JPanel panel = new JPanel(new GridBagLayout());
		buildButtons(tableModel);
		buildTable(tableModel, panel);
		add(panel, new GBC(0, 0).both());
	}

	/**
	 * M�todo que constr�i todos os bot�es da janela e suas a��es.
	 * 
	 * @param tableModel
	 *            Modelo da Tabela que ser� criada posteriormente.
	 */
	private void buildButtons(PersonRegistreTableModel tableModel) {
		JPanel panel = new JPanel(new GridBagLayout());
		JButton addButton = new JButton("Adicionar");
		JButton returnButton = new JButton("Voltar");
		// Adicionando fun��o aos bot�es.
		addButton.addActionListener(new ActionListener() {

			/**
			 * Ao clicar, adiciona a linha na lista de pessoas que est�o dentro
			 * do local.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRowCount();
				if (i == 1) {
					PersonInTableModel entranceTableModel = new PersonInTableModel();
					Person newPerson = tableModel.getPerson(table.getSelectedRow());
					ifItAlreadyOut(newPerson, table.getSelectedRow());
					entranceTableModel.add(newPerson);
					controller.Report.makeReportToIn(newPerson);
					tableModel.fireTableDataChanged();
					EntranceRegistreDialog.this.dispose();
				} else if (i == 0) {
					JOptionPane.showMessageDialog(EntranceRegistreDialog.this, "Nenhuma linha foi selecionada!");
				} else {
					JOptionPane.showMessageDialog(EntranceRegistreDialog.this,
							"S� � possivel alterar uma linha por vez!");
				}

			}
		});
		returnButton.addActionListener(new ActionListener() {

			/**
			 * Ao clicar, fecha a {@code Dialog} retorna para a tela principal.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				EntranceRegistreDialog.this.dispose();
			}
		});
		panel.add(addButton, new GBC(0, 0).both().insets(5, 5, 5, 5));
		panel.add(returnButton, new GBC(0, 2).both().insets(5, 5, 5, 5));
		add(panel, new GBC(1, 0).top());

	}

	/**
	 * M�tood que verifica se o objeto que ser� adicionado na lista de entrada
	 * j� n�o est� na lista de sa�da. Caso seja verdadeiro ele excluir� o objeto
	 * da lista de sa�da e o colocar� na lista de entrada. Isso � feito para
	 * evitar duplica��o de objetos.
	 * 
	 * @param newPerson
	 *            Objeto a ser verificado.
	 * @param selectedRow
	 *            Linha do objeto selecionado.
	 */
	protected void ifItAlreadyOut(Person newPerson, int selectedRow) {
		PersonOutTableModel outTableModel = new PersonOutTableModel();
		if (outTableModel.size() != 0) {
//			Person outPersonObject = outTableModel.getPerson(selectedRow);
			if (outTableModel.contains(newPerson)) {
				outTableModel.delete(newPerson);
			}
		}
	}

	/**
	 * M�todo que constr�i a tabela da janela.
	 * 
	 * @param tableModel
	 *            Modelo da Tabela que ser� usada para montar os dados da
	 *            tabela.
	 * @param panel
	 *            Painel da janela.
	 */
	private void buildTable(PersonRegistreTableModel tableModel, JPanel panel) {
		this.table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, new GBC(0, 0).both().insets(5, 5, 5, 5));
	}

}
