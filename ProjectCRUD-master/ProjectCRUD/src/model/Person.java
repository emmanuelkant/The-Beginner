package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Person {

	private String name;
	private long cpf;
	private Date entranceDate;
	private Date outDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	/**
	 * Construtor da classe.
	 * 
	 * @param name Nome da pessoa.
	 * @param cpf CPF da pessoa.
	 * @param entranceDate Data da entrada no local.
	 * @param outDate Data da saída do local.
	 */
	public Person(String name, String cpf, Date entranceDate, Date outDate) {
		super();
		setName(name);
		setCpf(cpf);
		setEntranceDate(entranceDate);
		setOutDate(outDate);
	}
	/**
	 * @return Nome da pessoa.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param Nome da pessoa.
	 */
	public void setName(String name) {
		this.name = name.trim().toUpperCase();
	}
	/**
	 * @return CPF da pessoa.
	 */
	public String getCpf() {
		String stringCpf = String.valueOf(this.cpf);
		return stringCpf;
	}
	/**
	 * @param CPF da pessoa.
	 */
	public void setCpf(String cpf) {
		try {
			long cpfLong = Long.parseLong(cpf);
			this.cpf = cpfLong;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O campo de CPF só aceita números, não utilize traços ou espaços ou qualquer caractere especial!");
			this.cpf = -999;
			setName("Error");
		}
		
	}
	
	public String getEntranceDate() {
		if (this.entranceDate == null){
			return "Sem Registro";
		} else {
			String stringEntranceDate = sdf.format(this.entranceDate);
			return stringEntranceDate;
		}
	}
	
	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}
	
	public String getOutDate() {
		if (this.outDate == null) {
			return "Sem Registro";
		} else {
			String stringOutDate = sdf.format(this.outDate);
			return stringOutDate;
		}
	}
	
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	
	
	

}
