package controller;

import java.text.DecimalFormat;

/**
 * Classe que realiza as contas.
 * 
 * @author Emmanuel Kant
 *
 */
public class Calculations {

	static DecimalFormat formatting = new DecimalFormat("#.##");

	/**
	 * Método que calcula o PIS.
	 * 
	 * @param revenue
	 *            Receita do usuário.
	 * @return O PIS.
	 */
	public static String calcOfPis(float revenue) {
		double pisResult = (revenue * 0.65) / 100;
		String tax = String.valueOf(formatting.format(pisResult));
		return tax;
	}

	/**
	 * Método que calcula o COFINS.
	 * 
	 * @param revenue
	 *            Receita do usuário.
	 * @return O COFINS.
	 */
	public static String calcOfCofins(float revenue) {
		double cofinsResult = (revenue * 3) / 100;
		String tax = String.valueOf(formatting.format(cofinsResult));
		return tax;
	}

	/**
	 * Método que calcula o CSSL.
	 * 
	 * @param revenue
	 *            Receita do usuário.
	 * @return O CSSL.
	 */
	public static String calcOfCssl(float revenue) {
		double csslResult = (revenue * 2.88) / 100;
		String tax = String.valueOf(formatting.format(csslResult));
		return tax;
	}

	/**
	 * Método que calcula o IRPJ.
	 * 
	 * @param revenue
	 *            Receita do usuário.
	 * @return O IRPJ.
	 */
	public static String calcOfIrpj(float revenue) {
		double irpjResult = (revenue * 4.8) / 100;
		String tax = String.valueOf(formatting.format(irpjResult));
		return tax;
	}

	/**
	 * Método que calcula a BC.
	 * 
	 * @param revenue
	 *            Receita do usuário.
	 * @return A BC.
	 */
	public static String calcOfBc(float revenue) {
		double bcResult = (revenue * 32) / 100;
		String bc = String.valueOf(formatting.format(bcResult));
		return bc;
	}

	/**
	 * Método que calcula o IPA.
	 * 
	 * @param valueOfBcField
	 *            O valor que está armazenado no field da Base de Cáculo.
	 * @return O Imposto Adicional.
	 */
	public static String calcOfIpa(float valueOfBcField) {
		double ipaResult = (valueOfBcField - 20000.00) * 10 / 100;
		String tax = String.valueOf(formatting.format(ipaResult));
		return tax;
	}

}
