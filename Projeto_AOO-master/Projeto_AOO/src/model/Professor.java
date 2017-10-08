package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Professor extends Pessoa {
	private double salario;
	private Date dataContratacao;
	private String matricula;
	private Turma[] turmas;
	private Disciplina disciplina;
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	static Scanner in = new Scanner(System.in);

	static SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy");

	public Professor(String nome, String cpf, Date dataNascimento, double salario, Date dataContratacao,
			String matricula) {
		super(nome, cpf, dataNascimento);
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.matricula = matricula;

	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Turma[] getTurmas() {
		return turmas;
	}

	public void setTurmas(Turma[] turmas) {
		this.turmas = turmas;
	}

	// comite
	public static void CadastrarProfessor(Professor[] professor) {
		for (int i = 0; i < 10; i++) {
			if (professor[i] == null) {
				try {
					System.out.println("\nCadastro de um novo Professor !!!");
					System.out.println("\nDigite o nome do Professor");
					String nome = in.next();
					System.out.println("Digite o cpf do professor");
					String cpf = in.next();
					System.out.println("Digite a Data de Nascimento");
					String datanas = in.next();
					Date datanasc = formatoDate.parse(datanas);

					System.out.println("Digite o salario do Professor");
					double salario = in.nextDouble();
					System.out.println("Digite a data a data de contratacao");
					String datacon = in.next();

					Date datanascont = formatoDate.parse(datacon);

					System.out.println("Digite a matricula");
					String mat = in.next();

					professor[i] = new Professor(nome, cpf, datanasc, salario, datanascont, mat);

					System.out.println("\nProfessor Cadastrado com sucesso Na posicao" + (i + 1));
					break;
				} catch (ParseException e) {
					System.out.println("Valor digitado errado");
					break;
				}
			} else if (i == 9) {
				System.out.println("A lista est� cheia, favor remover Algum professor da lista");
			}
		}
	}

	public static void listarProfessores(Professor[] professor) {
		int qtdProfessores = 0;
		for (int i = 0; i < professor.length; i++) {
			if (professor[i] != null) {
				//
				System.out.println((i + 1) + "Nome: " + professor[i].getNome());
				qtdProfessores++;

			}
		}
		System.out.println("Voce possui " + qtdProfessores + "cadastrados");

	}

	public static void localizarProfessores(Professor[] professor) {
		System.out.println("\nLocalizador de Professores. Por favor entre com o nome do professor:");
		String garbage = in.nextLine();
		String nome = in.nextLine();
		nome = nome.toUpperCase().trim();
		for (int i = 0; i < professor.length; i++) {
			if (professor[i] != null) {
				String nomeProfessor = professor[i].getNome();
				nomeProfessor = nomeProfessor.toUpperCase().trim();
				if (nome.equals(nomeProfessor)) {
					System.out.println("\nProfessor: " + professor[i].getNome() + " encontrado.");
					System.out.println("\nEste Professor esta na posicao " + (i + 1) + " do banco de dados.\n");
					break;
				}
			} else if (i == 9) {
				System.out.println("\nProfessor nao encontrado, certifique-se que tenha escrito o nome corretamente!"
						+ " Ou que ja tenha cadastrado algum Professor.\n");
			}
		}

	}

	public static void Associacao(Professor[] professor, Disciplina[] disciplina) {

		int resp = 0;
		do {
			if (professor != null && disciplina != null) {
				try {
					Professor[] prof = null;
					System.out.println("Digite o nome do Professor que deseja associar");
					String nome = in.next();
					System.out.println("Digite o nome da Disciplina que deseja associar");
					String disc = in.next();
					int i;
					for (i = 0; i < disciplina.length; i++) {
						if (disciplina[i] != null) {
							if (disc.equals(disciplina[i].getNome())) {
								disciplina[i].setProfessores(professor);
								prof = disciplina[i].getProfessores();
							}
						}
					}
					for (int a = 0; a < professor.length; a++) {

						if (professor[a] != null) {
							if (nome.equals(professor[a].getNome())) {

								professor[a].setDisciplina(disciplina[0]);

								System.out.println(
										"O Professor " + prof[a].getNome() + " foi associado com sucesso a Disciplina: "
												+ professor[a].getDisciplina().getNome());

							}
						}
					}
				} catch (NullPointerException e) {
					System.out.println("\nOps! Professor ou Disciplina nao cadastrados, Favor cadastrar primeiro ");
				}
			}
			System.out.println("\nDeseja Associar mais Algum Professor ?   [1 = sim | 2 = n�o]");
			resp = in.nextInt();
		} while (resp == 1);
	}

}
