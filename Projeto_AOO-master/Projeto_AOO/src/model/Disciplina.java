package model;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Disciplina {
	private String nome;
	private int cargaHorariaSemanal;
	private Professor[] professores;
	private Turma[] turmas;

	public Disciplina(String nome, int cargaHorariaSemanal) {
		super();
		this.nome = nome;
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}

	static Scanner in = new Scanner(System.in);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}

	public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}

	public Professor[] getProfessores() {
		return professores;
	}

	public void setProfessores(Professor[] professores) {
		this.professores = professores;
	}

	public Turma[] getTurmas() {
		return turmas;
	}

	public void setTurmas(Turma[] turmas) {
		this.turmas = turmas;
	}

	public static void cadastrardisciplinas(Disciplina[] disciplina) {
		for (int i = 0; i < 10; i++) {
			if (disciplina[i] == null) {
				try {
					System.out.println("\nBem vindo ao Cadastramento de Disciplina");
					System.out.println("\nDigite o nome da Disciplina");
					String nome = in.nextLine();
					System.out.println("Digite a Carga horaria semanal a qual a disciplina sera submetida");
					int cargahora = in.nextInt();
					String garbage = in.nextLine();
					disciplina[i] = new Disciplina(nome, cargahora);
					break;
				} catch (InputMismatchException e) {
					System.out.println("\nOps Algo esta errado, tente novamente");
					break;
				}
			} else if (i == 9) {
				System.out.println("\nA lista esta cheia");
			}
		}
	}

	public static void ListarDisciplina(Disciplina[] disciplina) {
		int qtdDisciplina = 0;
		for (int i = 0; i < disciplina.length; i++) {
			if (disciplina[i] != null) {
				System.out.println((i + 1) + " Disciplina - " + disciplina[i].getNome() + "\n");

				qtdDisciplina++;
			}
		}
		System.out.println("Você possui " + qtdDisciplina + " disciplinas cadastradas\n");
	}
	
	public static void localizarDisciplina(Disciplina[] disciplina) {
		System.out.println("\nLocalizador de Disciplinas. Por favor entre com o nome da disciplina:");
		String garbage = in.nextLine();
		String nome = in.nextLine();
		nome = nome.toUpperCase().trim();
		for (int i = 0; i < disciplina.length; i++) {
			if (disciplina[i] != null) {
				String nomeDisciplina = disciplina[i].getNome();
				nomeDisciplina= nomeDisciplina.toUpperCase().trim();
				if (nome.equals(nomeDisciplina)) {
					System.out.println("\nDisciplina: " + disciplina[i].getNome() + " encontrado.");
					System.out.println("\nEsta Disciplina esta na posicao " + (i + 1) + " do banco de dados.\n");
					break;
				}
			} else if (i == 9) {
				System.out.println("\nDisciplina nao encontrada, certifique-se que tenha escrito o nome corretamente!"
						+ " Ou que ja tenha cadastrado alguma disciplina.\n");
			}
		}
		
	}
	public static void listaProfessoresDisciplina(Disciplina[] disciplina) {
		if (disciplina[0] != null) {
			if (disciplina[0].getProfessores() != null) {
				System.out.println("\n!!!Listagem de Professores de uma disciplina!!!\n");
				System.out.println("\nPor favor escolha uma disciplina para imprimir professores \n");
				ListarDisciplina(disciplina);
				int option = 0;
				do {
					try {
						option = 0;
						System.out.println("\nDigite sua opcao\n");
						option = in.nextInt();
						option--;
						// sempre que pgar um int precisa usar esse gabarge, nao sabemos o
						// porque mas precisa usar.
						String garbage = in.nextLine();
					} catch (Exception e) {
						System.out.println("\nOPS PARECE QUE VOCE DIGITOU ALGO ERRADO. LETRAS E CARACTERES NAO SERAO ACEITOS.\n");
						String garbage = in.nextLine();
						return;
					}
					if (option < 0 || option > 9) {
						System.out.println("\nOPCAO INVALIDA. TENTE NOVAMENTE\n");
					}
				} while (option < 0 || option > 9);
				if (disciplina[option] != null) {
					Professor[] professordisciplina = disciplina[option].getProfessores();
					for (int i = 0; i < professordisciplina.length; i++) {
						if (professordisciplina[i] != null) {
							System.out.println((i + 1) + " - ALUNO: " + professordisciplina[i].getNome()
									+ " esta na Disciplina " + disciplina[option].getNome());
						}
					}
				} else {
					System.out.println("\n A Disciplina QUE VOCE ESCOLHEU NAO EXISTE\n");
				}
			}else{
				System.out.println("\nVoce nao possui professores cadastrados em Disciplina. Associe professores a disciplina e volte aqui.\n");
			}
		}else{
			System.out.println("\nVoce nao possui disciplinas cadastrados. Cadastre disciplinas e volte aqui.\n");
		}
	}


}