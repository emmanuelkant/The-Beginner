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
	 *            Utilizada para orientação da janela.
	 */
	public ConsultDialog(WorkFrame largeFrame) {
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
		setTitle("Lista dos Cadastrados");
		setSize(650, 300);
		setMinimumSize(new Dimension(650, 300));
		setLocationRelativeTo(largeFrame);
		setDefaultCloseOperation(EntranceRegistreDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Método que constroi o conteudo da janela.
	 * 
	 * @param tableModel
	 *            Modelo da tabela que será criada posteriormente.
	 */
	private void buildContent(PersonRegistreTableModel tableModel) {
		JPanel panel = new JPanel(new GridBagLayout());
		buildButtons(tableModel);
		buildTable(tableModel, panel);
		add(panel, new GBC(0, 0).both());
	}

	/**
	 * Método que constrói todos os botões da janela.
	 * 
	 * @param tableModel
	 *            Modelo da Tabela que será criada posteriormente.
	 */
	private void buildButtons(PersonRegistreTableModel tableModel) {
		JPanel panel = new JPanel(new GridBagLayout());
		JButton deleteButton = new JButton("Deletar");
		JButton updateButton = new JButton("Atualizar");
		JButton returnButton = new JButton("Voltar");
		// Adicionando função aos botões.
		deleteButton.addActionListener(new ActionListener() {

			/**
			 * Ao clicar, exclui a linha ou as linhas selecionadas.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRowCount();
				if (i > 0) {
					int answer = JOptionPane.showConfirmDialog(ConsultDialog.this, "Você deseja realmente deletar esse dado?",
							"Aviso", JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) {
						answer = JOptionPane.showConfirmDialog(ConsultDialog.this, "Você excluirá também os cadastros na da relação de entrada e saída. Deseja realmente fazer isso?",
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
					JOptionPane.showMessageDialog(ConsultDialog.this, "Só é possivel alterar uma linha por vez!");
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
	 * Método que constrói a tabela da janela.
	 * 
	 * @param tableModel
	 *            Modelo da Tabela que será usada para montar os dados da
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
