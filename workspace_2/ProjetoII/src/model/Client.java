package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cliente.
 */
public class Client {

	/** Nome do cliente. */
	private String name;

	/** CPF do cliente. */
	private String cpf;

	/** Data de nascimento do cliente. */
	private Date birthday;
	
	/** Formatador da Date*/
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Construtor.
	 * 
	 * @param name
	 *            Nome.
	 * @param cpf
	 *            CPF.
	 * @param birthday
	 *            Data de nascimento.
	 */
	public Client(String name, String cpf, String birthday) {
		this.name = name;
		this.cpf = cpf;
		setBirthday(birthday);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		Date dateFormated = null;
		try {
			dateFormated = sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		Corrigir.
//		this.birthday = Utility.dateToString(dateFormated);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
