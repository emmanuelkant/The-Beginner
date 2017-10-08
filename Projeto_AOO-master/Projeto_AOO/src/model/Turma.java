package model;

import java.net.SocketImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Turma {
	private int qtdVagas;
	private String codigo;
	private int[] diasSemana;
	private Date horaInicio;
	private Date horaFinal;
	private String periodoReferencia;
	private Professor professor;
	private Disciplina disciplina;
	private ItensInscricao[] itensInscricao;
	static Scanner in = new Scanner(System.in);

	static SimpleDateFormat formatoDate = new SimpleDateFormat("HH:mm");

	public Turma(int qtdVagas, String codigo, int[] diasSemana, Date horaInicio, Date horaFinal,
			String periodoReferencia, Disciplina disciplina) {
		this.qtdVagas = qtdVagas;
		this.codigo = codigo;
		this.diasSemana = diasSemana;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.periodoReferencia = periodoReferencia;
		this.disciplina = disciplina;
	}

	public int getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int[] getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(int[] diasSemana) {
		this.diasSemana = diasSemana;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getPeriodoReferencia() {
		return periodoReferencia;
	}

	public void setPeriodoReferencia(String periodoReferencia) {
		this.periodoReferencia = periodoReferencia;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public ItensInscricao[] getItensInscricao() {
		return itensInscricao;
	}

	public void setItensInscricao(ItensInscricao[] itensInscricao) {
		this.itensInscricao = itensInscricao;
	}

	public static void cadastraTurma(Turma[] turma, Disciplina[] disci) {
		int[] diasSemana = new int[10];
		for (int i = 0; i < turma.length; i++) {
			if (disci[i] != null) {
				for (int j = 0; j < diasSemana.length; j++) {
					if (turma[j] == null) {
						try {
							System.out.println("\n!!!Cadastramento de um nova turma!!!\n");
							System.out.println("Entre com o numero da turma");
							String codigo = in.nextLine();
							System.out.println("Entre com o quantidade de vagas para a turma");
							int qtdVagas = in.nextInt();
							String garbage = in.nextLine();
							System.out.println("Entre com os dias da semana");
							diasSemana = pegaDiasSemana();
							System.out.println("Entre com o per�odo referente");
							String periodoReferencia = in.nextLine();
							System.out.println("Entre com o horario de inicio");
							String horaIniciop = in.nextLine();
							Date horaInicio = formatoDate.parse(horaIniciop);
							System.out.println("Entre com o horario de termino");
							String horaFinalp = in.nextLine();
							Date horaFinal = formatoDate.parse(horaFinalp);
							System.out.println(
									"Escolha abaixo pela numera��o, qual disciplina quer vincular a essa turma");
							Disciplina.ListarDisciplina(disci);
							boolean naoPodePassar = false;
							int n;
							do {
								naoPodePassar = false;
								n = in.nextInt();
								garbage = in.nextLine();
								if (n >= 1 && n <= 10) {
									if (disci[n - 1] == null) {
										naoPodePassar = true;
										System.out.println("1ESSA POSI��O � INVALIDA. TENTE NOVAMENTE!");
									}
								} else {
									System.out.println("ESSA POSI��O � INVALIDA. TENTE NOVAMENTE!");
									naoPodePassar = true;
								}
							} while (naoPodePassar);

							turma[j] = new Turma(qtdVagas, codigo, diasSemana, horaInicio, horaFinal, periodoReferencia,
									disci[n - 1]);
							System.out.println("\nTURMA CADASTRADO COM SUCESSO NA POSICAO " + (i + 1) + "\n");

							return;

						} catch (Exception e) {
							System.out.println(
									"\nOPS PARECE QUE VOCE DIGITOU ALGO ERRADO. DICA: OS HORARIOS DEVEM SER NESTE FORMATO HH:MM COM OS DOIS PONTOS\n");
							System.out.println("APERTE ENTER PRA CONTINUAR");
							String garbage = in.nextLine();
							return;
						}
					} else if (j == 9) {
						System.out.println(
								"INFELIZMENTE A LISTA DE TURMA ESTA CHEIA, POR FAVOR EXCLUA UMA TURMA PARA PODER CADASTRAR MAIS");
					}
				}
			} else if (i == 9) {
				System.out.println(
						"INFELIZMENTE A LISTA DE DICIPLINA ESTA VAZIA, OU N�O HA DISCIPLINA DISPONIVEIS, FAVOR CRIAR UMA DICIPLINA PARA PODER CADASTRAR TURMA");
			}
		}

	}

	private static int[] pegaDiasSemana() {
		int[] simNao = new int[6];
		String[] diasSemana = new String[5];
		String n;
		diasSemana[0] = "SEGUNDA";
		diasSemana[1] = "TER�A";
		diasSemana[2] = "QUARTA";
		diasSemana[3] = "QUINTA";
		diasSemana[4] = "SEXTA";
		System.out.println("Digite 1 para SIM e 2 para N�o");
		for (int i = 0; i < diasSemana.length; i++) {
			System.out.println(diasSemana[i] + " vai ter aula?");
			do {
				n = in.nextLine();
				if (n.equals("1")) {
					simNao[i] = 1;
				}
				if (n.equals("2")) {
					break;
				}
				if (simNao[i] != 1) {
					System.out.println("OPS PARECE QUE VOCE DIGITOU ALGO ERRADO. DICA: DIGITE 1 PARA SIM E 2 PARA N�O");
				}
			} while (simNao[i] != 1);
		}
		return simNao;
	}

	public static void listarTurma(Turma[] turma) {
		int qtsTurmas = 0;
		for (int i = 0; i < turma.length; i++) {
			if (turma[i] != null) {
				System.out.println("\n" + (i + 1) + "� Turma - Codigo: " + turma[i].getCodigo() + "\n");
				qtsTurmas++;
			}
		}
		System.out.println("Voce possui " + qtsTurmas + " turmas cadastrados\n");
	}

	public static void localizarTurma(Turma[] turma) {

		System.out.println("\nLocalizador de turma. Por favor entre com o codigo de turma:");
		// String garbage = in.nextLine();
		String codigo = in.nextLine();
		codigo = codigo.toUpperCase().trim();
		for (int i = 0; i < turma.length; i++) {
			if (turma[i] != null) {
				String codigoTurma = turma[i].getCodigo();
				codigoTurma = codigoTurma.toUpperCase().trim();
				if (codigo.equals(codigoTurma)) {
					System.out.println("\nTurma com a numera��o " + turma[i].getCodigo() + " encontrada.");
					System.out.println("Esta turma esta na posicao " + (i + 1) + " do banco de dados.\n");
					break;
				}
			} else if (i == 9) {
				System.out.println(
						"\nTurma n�o encontrada, certifique-se que tenha escrito o codigo corretamente! Ou que j� tenha cadastrado alguma turma.\n");
			}
		}
	}

	public static void listaAlunosTurma(Turma[] turma) {
		if (turma[0] != null) {
			if (turma[0].getItensInscricao() != null) {
				System.out.println("\n!!!Listagem de Alunos de uma turma!!!\n");
				System.out.println("\nPor favor escolha uma turma para imprimir alunos\n");
				listarTurma(turma);
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
				if (turma[option] != null) {
					ItensInscricao[] turmaAluno = turma[option].getItensInscricao();
					for (int i = 0; i < turmaAluno.length; i++) {
						if (turmaAluno[i] != null) {
							System.out.println((i + 1) + " - ALUNO: " + turmaAluno[i].getInscricao().getAluno().getNome()
									+ " esta na turma " + turma[option].getCodigo());
						}
					}
				} else {
					System.out.println("\nA A TURMA QUE VOCE ESCOLHEU NAO EXISTE\n");
				}
			}else{
				System.out.println("\nVoce nao possui alunos cadastrados em Turma. Associe alunos a turma e volte aqui.\n");
			}
		}else{
			System.out.println("\nVoce nao possui turmas cadastradas. Cadastre turma e volte aqui.\n");
		}
	}
}
