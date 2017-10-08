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

/**
 * Classe na janela que consulta, atualiza e deleta os cadastros.
 * 
 * @author Emmanuel Kant
 *
 */
public class ConsultDialog extends JDialog {

	private JTable table = new JTable();
	private PersonRegistreTableModel tableModel = new PersonRegistreTableModel();

	/**
	 * Construtor da frame.
	 * 
	 * @param largeFrame
	 *            Utilizada para orienta��o da janela.
	 */
	public ConsultDialog(WorkFrame largeFrame) {
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
		setMinimumSize(new Dimension(650, 300));
		setLocationRelativeTo(largeFrame);
		setDefaultCloseOperation(EntranceRegistreDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * M�todo que constroi o conteudo da janela.
	 * 
	 * @param tableModel
	 *            Modelo da tabela que ser� criada posteriormente.
	 */
	private void buildContent(PersonRegistreTableModel tableModel) {
		JPanel panel = new JPanel(new GridBagLayout());
		buildButtons(tableModel);
		buildTable(tableModel, panel);
		add(panel, new GBC(0, 0).both());
	}

	/**
	 * M�todo que constr�i todos os bot�es da janela.
	 * 
	 * @param tableModel
	 *            Modelo da Tabela que ser� criada posteriormente.
	 */
	private void buildButtons(PersonRegistreTableModel tableModel) {
		JPanel panel = new JPanel(new GridBagLayout());
		JButton deleteButton = new JButton("Deletar");
		JButton updateButton = new JButton("Atualizar");
		JButton returnButton = new JButton("Voltar");
		// Adicionando fun��o aos bot�es.
		deleteButton.addActionListener(new ActionListener() {

			/**
			 * Ao clicar, exclui a linha ou as linhas selecionadas.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRowCount();
				if (i > 0) {
					int answer = JOptionPane.showConfirmDialog(ConsultDialog.this, "Voc� deseja realmente deletar esse dado?",
							"Aviso", JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) {
						answer = JOptionPane.showConfirmDialog(ConsultDialog.this, "Voc� excluir� tamb�m os cadastros na da rela��o de entrada e sa�da. Deseja realmente fazer isso?",
								"Aviso", JOptionPane.YES_NO_OPTION);
						if (answer == JOptionPane.YES_OPTION) {
							tableModel.delete(table.getSelectedRows());
						}
					}
				} else {
					JOptionPane.showMessageDialog(ConsultDialog.this, "Nenhuma linha foi selecionada!");
				}
			}
		});
		updateButton.addActionListener(new ActionListener() {

			/**
			 * Ao clicar, atualiza a linha selecionada.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRowCount();
				if (i == 1) {
					new PersonDialog(ConsultDialog.this, table.getSelectedRow());
					tableModel.fireTableDataChanged();
				} else if (i == 0) {
					JOptionPane.showMessageDialog(ConsultDialog.this, "Nenhuma linha foi selecionada!");
				} else {
					JOptionPane.showMessageDialog(ConsultDialog.this, "S� � possivel alterar uma linha por vez!");
				}
			}
		});
		returnButton.addActionListener(new ActionListener() {

			/**
			 * Ao clicar, retorna para a tela principal.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsultDialog.this.dispose();
			}
		});
		panel.add(deleteButton, new GBC(0, 0).both().insets(5, 5, 5, 5));
		panel.add(updateButton, new GBC(0, 1).both().insets(5, 5, 5, 5));
		panel.add(returnButton, new GBC(0, 2).both().insets(5, 5, 5, 5));
		add(panel, new GBC(1, 0).top());

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
