package controller;

import model.Person;

public class Report {

	private static String report = "IN�CIO DO RELAT�RIO\n";

	public static void makeReportToIn(Person person) {

		report += "\nPessoa: " + person.getName() + "\nCPF: " + person.getCpf() + "\nEntrou �s: "
				+ person.getEntranceDate() + "\n-------------------";

	}

	public static void makeReportToOut(Person person) {

		report += "\nPessoa: " + person.getName() + "\nCPF: " + person.getCpf() + "\nSaiu �s: "
				+ person.getOutDate() + "\n-------------------";

	}

	public static void makeReportToRegistre(Person person) {

		report += "\nCADASTRO da Pessoa: " + person.getName() + "\nCPF: " + person.getCpf() + "\n-------------------";

	}
	
	public static void makeReportToUpdate(Person person) {

		report += "\nATUALIZA��O da Pessoa: " + person.getName() + "\nCPF: " + person.getCpf() + "\n-------------------";

	}
	
	public static void makeReportToDelete(Person person) {

		report += "\nDELETOU a Pessoa: " + person.getName() + "\nCPF: " + person.getCpf() + "\n-------------------";

	}
	
	public String toString(){
		return report += " FIM DO RELAT�RIO";
	}

}
