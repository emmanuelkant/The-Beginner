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
	 * M�todo que calcula o PIS.
	 * 
	 * @param revenue
	 *            Receita do usu�rio.
	 * @return O PIS.
	 */
	public static String calcOfPis(float revenue) {
		double pisResult = (revenue * 0.65) / 100;
		String tax = String.valueOf(formatting.format(pisResult));
		return tax;
	}

	/**
	 * M�todo que calcula o COFINS.
	 * 
	 * @param revenue
	 *            Receita do usu�rio.
	 * @return O COFINS.
	 */
	public static String calcOfCofins(float revenue) {
		double cofinsResult = (revenue * 3) / 100;
		String tax = String.valueOf(formatting.format(cofinsResult));
		return tax;
	}

	/**
	 * M�todo que calcula o CSSL.
	 * 
	 * @param revenue
	 *            Receita do usu�rio.
	 * @return O CSSL.
	 */
	public static String calcOfCssl(float revenue) {
		double csslResult = (revenue * 2.88) / 100;
		String tax = String.valueOf(formatting.format(csslResult));
		return tax;
	}

	/**
	 * M�todo que calcula o IRPJ.
	 * 
	 * @param revenue
	 *            Receita do usu�rio.
	 * @return O IRPJ.
	 */
	public static String calcOfIrpj(float revenue) {
		double irpjResult = (revenue * 4.8) / 100;
		String tax = String.valueOf(formatting.format(irpjResult));
		return tax;
	}

	/**
	 * M�todo que calcula a BC.
	 * 
	 * @param revenue
	 *            Receita do usu�rio.
	 * @return A BC.
	 */
	public static String calcOfBc(float revenue) {
		double bcResult = (revenue * 32) / 100;
		String bc = String.valueOf(formatting.format(bcResult));
		return bc;
	}

	/**
	 * M�todo que calcula o IPA.
	 * 
	 * @param valueOfBcField
	 *            O valor que est� armazenado no field da Base de C�culo.
	 * @return O Imposto Adicional.
	 */
	public static String calcOfIpa(float valueOfBcField) {
		double ipaResult = (valueOfBcField - 20000.00) * 10 / 100;
		String tax = String.valueOf(formatting.format(ipaResult));
		return tax;
	}

}
