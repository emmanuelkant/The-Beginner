package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Aluno extends Pessoa {
	private String matricula;
	private Date dataIngresso;
	private Inscricao[] inscricoes;
	// Crinado o Scanner aqui fora eu posso usa-lo dentro de todos em ter que
	// ficar criando varios
	static Scanner in = new Scanner(System.in);
	// Mesmo caso do Scanner.
	static SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy");

	public Aluno(String nome, String cpf, Date dataNascimento, String matricula, Date dataIngresso) {
		super(nome, cpf, dataNascimento);
		this.matricula = matricula;
		this.dataIngresso = dataIngresso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public Inscricao[] getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Inscricao[] inscricoes) {
		this.inscricoes = inscricoes;
	}

	public static void cadastrarAluno(Aluno[] alunos) {
		for (int i = 0; i < 10; i++) {
			// Aqui e a parte aonde eu confiro se esta posicao esta vazia ou
			// não
			if (alunos[i] == null) {
				try {
					System.out.println("\n!!!Cadastramento de um novo aluno!!!\n");
					System.out.println("Entre com o nome do aluno");
					String nome = in.nextLine();
					nome = nome.trim();
					System.out.println("Entre com o cpf do aluno");
					String cpf = in.nextLine();
					System.out.println("Entre com a Data de Nascimento do aluno, conforme o modelo XX/XX/XXXX");
					// dataNasP significa uma data de nascimento provisoria,
					// antes de realmente entrar no objeto date
					String dataNasP = in.nextLine();
					// assim que ele tenta converter, e ocorrer alguma excessao,
					// ele ira para o catch
					Date dataNas = formatoDate.parse(dataNasP);
					System.out.println("Entre com a matricula do aluno");
					String matricula = in.nextLine();
					System.out.println("Entre com a Data de Ingresso do aluno, conforme o modelo XX/XX/XXXX");
					// Mesmo caso da data de nascimento, precios colocar dentro
					// de um try, talvez futuramente eu refatore esse codigo
					String dataIngressoP = in.nextLine();
					// mesmacoisa que a outra Date
					Date dataIngresso = formatoDate.parse(dataIngressoP);
					alunos[i] = new Aluno(nome, cpf, dataNas, matricula, dataIngresso);
					System.out.println("\nALUNO CADASTRADO COM SUCESSO NA POSICAO " + (i + 1) + "\n");
					// caso ele chegue nesse ponto significa que o aluno foi
					// cadastrado, então termine o loop do for
					break;
				} catch (ParseException e) {
					System.out.println(
							"\nOPS PARECE QUE VOCE DIGITOU ALGO ERRADO. DICA: A DATA DEVE SER NESTE FORMATO DD/MM/AAAA COM AS BARRAS\n");
					// caso haja algum erro e cai em uma execessao ele tambem
					// ira para o for
					break;
				}
			} else if (i == 9) {
				// se aluno for diferente de null, ou seja, esta populado e "i"
				// for igual a 9, entãoa lista esta cheia
				System.out.println(
						"INFELIZMENTE A LISTA DE ALUNOS ESTA CHEIA, POR FAVOR EXCLUA UM ALUNO PARA PODER CADASTRAR MAIS");
			}
		}
	}

	public static void listarALunos(Aluno[] alunos) {
		int qtdAlunos = 0;
		// for para iterar todas as posicoes de aluno, neste caso 10
		for (int i = 0; i < alunos.length; i++) {
			// aqui ele confere se o aluno está vazio ou nao, se estiver ele
			// passa, senao ele entra
			if (alunos[i] != null) {
				System.out.println("\n" + (i + 1) + "° Aluno - Nome: " + alunos[i].getNome() + "\n");
				qtdAlunos++;
			}
		}
		// O metodo anterior nao era totalmente funcional
		System.out.println("Você possui " + qtdAlunos + " alunos cadastrados\n");
	}

	public static void localizaAluno(Aluno[] alunos) {

		System.out.println("\nLocalizador de alunos. Por favor entre com o nome do aluno:");
		String nome = in.nextLine();
		// coloc tudo em maiuscula para conferir sem erros de caixa alta ou
		// baixa
		nome = nome.toUpperCase().trim();
		for (int i = 0; i < alunos.length; i++) {
			// ele so entrara caso o aluno na posicao "i" for diferente de null
			if (alunos[i] != null) {
				String nomeAluno = alunos[i].getNome();
				// tambem aumento a caixa do nome guardado em aluno para
				// conferir com que acabei de pegar
				nomeAluno = nomeAluno.toUpperCase().trim();
				// Auqi eu confiro se um nome bate com o outro
				if (nome.equals(nomeAluno)) {
					System.out.println("\nAluno: " + alunos[i].getNome() + " encontrado.");
					System.out.println("Este aluno esta na posicao " + (i + 1) + " do banco de dados.\n");
					// caso ele entre aqui significa que o nome é igual, entao
					// o
					// laco do for e quebrado
					break;
				}
			} else if (i == 9) {
				// Ele so entrara aqui caso o aluno for null e somente depois
				// que "i" for igual a 9, ou seja, na ultima iteracao
				System.out.println("\nAluno não encontrado, certifique-se que tenha escrito o nome corretamente!"
						+ " Ou que já tenha cadastrado alguns aluno.\n");
			}
		}

	}

	public static void associaAlunoTurma(Aluno[] alunos, Turma[] turma) {
		Aluno[] alunoTurma = new Aluno[10];
		int opcaoAluno, option;
		if (alunos[0] != null) {
			if (turma[0] != null) {
				System.out.println("\n!!!Associacao de aluno(s) a turma!!!\n");
				try {
					do {
						do {
							opcaoAluno = 0;
							System.out.println("Escolha um aluno para associar a turma:");
							listarALunos(alunos);
							System.out.println("Digite o numero do aluno que deseja armazenar");
							opcaoAluno = in.nextInt();
							String gabarge = in.nextLine();
							opcaoAluno--;
							for (int i = 0; i < alunoTurma.length; i++) {
								if (alunoTurma[i] == null) {
									if (alunos[opcaoAluno] != null) {
										if (alunos[opcaoAluno].getInscricoes() == null) {
											System.out.println(
													"\nO aluno escolhido nao possui inscricoes, por favor adicione inscricoes no aluno antes de continuar\n");
											return;
										}
										alunoTurma[i] = alunos[opcaoAluno];
										System.out.println("\nAluno armazenado com sucesso!\n");
										break;
									} else {
										System.out.println("\nEsse aluno nao existe. Tente novamente!\n");
										return;
									}
								} else if (i == 9) {
									System.out
											.println("\nA LISTA JA ESTA CHEIA, VOCE NAO PODE ESCOLHAR MAIS ALUNOS.\n");
								}
							}
							if (opcaoAluno < 0 || opcaoAluno > 9) {
								System.out.println("\nOpcao digitada invalida. Tente novamente.\n");
							}
						} while (opcaoAluno < 0 || opcaoAluno > 9);
						do {
							System.out.println(
									"\nDeseja associar mais algum aluno? Digite [1] para sim e [0] para nao.\n");
							option = in.nextInt();

							if (option < 0 || option > 1) {
								System.out.println("\nDIGITE APENAS 1 OU 0. TENTE DENOVO\n");
							}
						} while (option < 0 || option > 1);
					} while (option != 0);
				} catch (Exception e) {
					System.out.println(
							"\nOPS PARECE QUE VOCE DIGITOU ALGO ERRADO. DICA: DIGITE SOMENTE NUMEROS, LETRAS E CARACTERES NAO SERAO ACEITOS. RECOMECE DO ZERO!\n");
					String gabarge = in.nextLine();
					return;
				}
			} else {
				System.out.println("\nVOCE NAO POSSUI TURMAS, CRIE TURMAS PARA PODER ASSOCIAR COM ALUNOS.\n");
				return;
			}
		} else {
			System.out.println("\nVOCE NAO POSSUI ALUNOS, CRIE ALUNOS PARA PODER ASSOCIAR TURMAS.\n");
			return;
		}
		System.out.println("\n\nAGORA DIGITE A TURMA QUE VOCE DESEJA ALOCAR ESSES ALUNOS.\n\n");
		Turma.listarTurma(turma);
		do {
			boolean error;
			try {
				error = true;
				option = -1;
				System.out.println("Digite o numero da turma que deseja armazenar os alunos");
				option = in.nextInt();
				option--;
			} catch (Exception e) {
				System.out.println("\nDIGITE APENAS NUMEROS. LETRAS E CARACTERES NAO SERAO ACEITOS. TENTE DENOVO!\n");
				String gabarge = in.nextLine();
				error = false;
			}
			if (error) {
				if (option < 0 || option > 9) {
					System.out.println("\nDIGITE APENAS O NUMERO DE TURMA, TENTE NOVAMENTE!\n");
				}
			}
		} while (option < 0 || option > 9);

		if (turma[option] != null) {
			associaDeFato(turma, alunoTurma, option);
		} else {
			System.out.println("\nA turma escolhida nao esta criada, certifique-se que digitou o numero certo\n");
			return;
		}
	}

	private static void associaDeFato(Turma[] turma, Aluno[] alunoTurma, int option) {
		ItensInscricao[] itensInscricaoTurma = new ItensInscricao[10];
		int j = 0;
		for (int i = 0; i < alunoTurma.length; i++) {
			if (alunoTurma[i] != null) {
				for (Inscricao inscricaoAluno : alunoTurma[i].getInscricoes()) {
					if (inscricaoAluno != null) {
						for (ItensInscricao itensInscricaoAluno : inscricaoAluno.getItensInscricao()) {
							itensInscricaoAluno.setTurma(turma[option]);
							System.out.println("Associando item de Inscricao a turma");
							if (itensInscricaoTurma[j] == null) {
								itensInscricaoTurma[j] = itensInscricaoAluno;
								System.out.println("Guardando item de inscricao");
							}
						}
					}
				}
			}
			j++;
		}
		turma[option].setItensInscricao(itensInscricaoTurma);
		System.out.println("Associando turma a itens de Inscricao");
	}

}
