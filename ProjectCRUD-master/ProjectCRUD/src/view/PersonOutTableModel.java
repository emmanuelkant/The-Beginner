package view;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.Person;

/**
 * Classe que armazenará os dados da tabela.
 * 
 * @author Emmanuel Kant
 *
 */
public class PersonOutTableModel extends AbstractTableModel {

	/**
	 * Lista que guardará todos as pessoas que está dentro do local. Perceba que
	 * a lista é {@code static}, ou seja, não importa aonde eu estarei
	 * instanciando o objeto, ela semprte terá o mesmo valor.
	 */
	private static ArrayList<Person> personList = new ArrayList<Person>();
	/** Colunas da tabela. */
	private String[] columns = new String[] { "Nome", "Saída" };

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
			return person.getOutDate();
		default:
			return -1;
		}
	}

	/**
	 * Acrecenta uma nova pessoa a lista da tabela.
	 * 
	 * @param newPerson
	 *            Objeto da pessoa a ser inserida na tabela.
	 */
	public void add(Person newPerson) {
		if (personList.contains(newPerson)) {
			personList.remove(newPerson);
		}
		newPerson.setOutDate(new Date());
		boolean itsDone = personList.add(newPerson);
		if (itsDone) {
			JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Pessoa não adicionada!");
		}
		fireTableDataChanged();
	}

	/**
	 * Deleta uma pessoa da lista.
	 * 
	 * @param personToDelete
	 *            Objeto da pessoa a ser deletada da tabela.
	 */
	public void delete(Person personToDelete) {
		personList.remove(personToDelete);
		fireTableDataChanged();
	}

	/**
	 * Método que verifica se o objeto existe nessa tabela.
	 * 
	 * @param person
	 *            Objeto a ser procurado.
	 * @return True se existe e false se não existe.
	 */
	public boolean contains(Person person) {
		return personList.contains(person);
	}

	/**
	 * Retorna quantos elementos a lista da tabela tem.
	 * 
	 * @return O tamanho da lista.
	 */
	public int size() {
		return personList.size();
	}

}
