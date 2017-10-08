package view;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.Person;

/**
 * Classe que armazenar� os dados da tabela.
 * 
 * @author Emmanuel Kant
 *
 */
public class PersonInTableModel extends AbstractTableModel {

	/**
	 * Lista que guardar� todos as pessoas que est� dentro do local. Perceba que
	 * a lista � {@code static}, ou seja, n�o importa aonde eu estarei
	 * instanciando o objeto, ela semprte ter� o mesmo valor.
	 */
	private static ArrayList<Person> personList = new ArrayList<Person>();
	/** Colunas da tabela. */
	private String[] columns = new String[] { "Nome", "Entrada" };

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
			return person.getEntranceDate();
		default:
			return -1;
		}
	}

	/**
	 * M�todo que retorna um objeto do tipo {@code Person}.
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
	public void add(Person newPerson) {
		if (!personList.contains(newPerson)) {
			newPerson.setOutDate(null);
			newPerson.setEntranceDate(new Date());
			personList.add(newPerson);
			fireTableDataChanged();
			JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Essa pessoa j� est� na lista de entrada!");
		}
		fireTableDataChanged();
	}

	/**
	 * Deleta uma pessoa da lista.
	 * 
	 * @param selectedRows
	 *            Posi��o das pessoas a serem removidas.
	 */
	public void delete(int selectedRow) {
		if (selectedRow != -1) {
			personList.remove(selectedRow);
			fireTableDataChanged();
		}
		fireTableDataChanged();
	}

	/**
	 * Deleta uma pessoa da lista.
	 * 
	 * @param selectedRows
	 *            Posi��o das pessoas a serem removidas.
	 */
	public void delete(Person toDeletePerson) {
		personList.remove(toDeletePerson);
		fireTableDataChanged();
	}

	/**
	 * M�todo que devolve o indice do objeto especificado.
	 * 
	 * @param person
	 *            Objeto a ser verificado.
	 * @return O n�mero do indice.
	 */
	public int getRowOfAPerson(Person person) {
		int rowOfThisPerson = 0;
		for (Person tempPerson : personList) {
			if (tempPerson == person) {
				return rowOfThisPerson;
			}
			rowOfThisPerson++;
		}
		return -1;
	}
}
