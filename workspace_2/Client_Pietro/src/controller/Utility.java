package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

	/** Formatador da Date */
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Conversor/Formatador de {@code Date} para {@code String}.
	 * 
	 * @param date
	 *            {@code Date} para converter/formatar.
	 * @return {@code String} da data.
	 */
	public static String dateToString(Date date) {
		return sdf.format(date);
	}

	/**
	 * Conversor/Formatador de {@code Date} para {@code java.sql.Date}.
	 * 
	 * @param date
	 *            {@code Date} a ser convertida e formatada para
	 *            {@code java.sql.Date}.
	 * @return Novo objeto de um {@code java.sql.Date}.
	 */
	public static java.sql.Date dateToSql(Date date) {
		return new java.sql.Date(date.getTime());
	}

	/**
	 * Conversor/Formatador de {@code String} para {@code Date}.
	 * 
	 * @param date
	 *            {@code String} da data a ser convertida e formatada.
	 * @return {@code Date} formatada e convertida.
	 */
	public static Date stringToDate(String date) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("Invalid date to format.");
		}
		System.err.println("Date is null.");
		return null;
	}

}
