package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.Person;

/**
 * Classe que armazenará os dados da tabela.
 * 
 * @author Emmanuel Kant
 *
 */
public class PersonRegistreTableModel extends AbstractTableModel {

	/**
	 * Lista que guardará todos as pessoas que está dentro do local. Perceba que
	 * a lista é {@code static}, ou seja, não importa aonde eu estarei
	 * instanciando o objeto, ela semprte terá o mesmo valor.
	 */
	private static ArrayList<Person> personList = new ArrayList<Person>();
	/** Colunas da tabela. */
	private String[] columns = new String[] { "Nome", "Cpf", "Entrada", "Saída" };

	@Override
	public String getColumnName(int column) {
		return this.columns[column];
	}

	@Override
	public int getRowCount() {
		return personList.size();
	}

	@Override
	public int getColumnCount() {
		return this.columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = personList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return person.getName();
		case 1:
			return person.getCpf();
		case 2:
			return person.getEntranceDate();
		case 3:
			return person.getOutDate();
		default:
			return -1;
		}
	}

	/**
	 * Método que retorna um objeto do tipo {@code Person}.
	 * 
	 * @param selectedRow
	 *            Linha em que o objeto desejado se encontra.
	 * @return O objeto selecionado.
	 */
	public Person getPerson(int selectedRow) {
		Person person = personList.get(selectedRow);
		return person;
	}

	/**
	 * Acrecenta uma nova pessoa a lista da tabela.
	 * 
	 * @param newPerson
	 *            Objeto da pessoa a ser inserida na tabela.
	 */
	public void addPersonOnTable(Person newPerson) {
		boolean itsDone = personList.add(newPerson);
		if (itsDone) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Pessoa não cadastrada!");
		}
		fireTableDataChanged();
	}

	/**
	 * Deleta um ou mais pessoas da lista.
	 * 
	 * @param selectedRows
	 *            Posição das pessoas a serem removidas.
	 */
	public void delete(int[] selectedRows) {
		for (int i = selectedRows.length - 1; i >= 0; i--) {
			controller.Report.makeReportToDelete(getPerson(selectedRows[i]));

			PersonInTableModel inTableModel = new PersonInTableModel();
			PersonOutTableModel outTableModel = new PersonOutTableModel();
			outTableModel.delete(personList.get(selectedRows[i]));
			inTableModel.delete(personList.get(selectedRows[i]));

			personList.remove(selectedRows[i]);
		}
		fireTableDataChanged();
	}

	/**
	 * Altera o valor de alguma pessoa na lista.
	 * 
	 * @param updatedPerson
	 *            Objeto da pessoa a ser atualizada.
	 * @param selectedRow
	 *            Linha em que a pessoa desejada se encotra.
	 */
	public void update(Person updatedPerson, int selectedRow) {
		Person personToChange = personList.get(selectedRow);
		personToChange.setName(updatedPerson.getName());
		JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		fireTableDataChanged();
	}

}
