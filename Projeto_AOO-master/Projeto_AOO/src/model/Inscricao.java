package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inscricao {
	private String qtdLimiteCreditos;
	private String periodoReferencia;
	private Date dataRealizacao;
	private Date dataAprovacao;
	private Aluno aluno;
	private ItensInscricao[] itensInscricao;
	static Scanner in = new Scanner(System.in);
	static SimpleDateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy");

	public Inscricao(String qtdLimiteCreditos, String periodoReferencia, Date dataRealizacao, Date dataAprovacao,
			Aluno aluno, ItensInscricao[] itensInscricao) {
		this.qtdLimiteCreditos = qtdLimiteCreditos;
		this.periodoReferencia = periodoReferencia;
		this.dataRealizacao = dataRealizacao;
		this.dataAprovacao = dataAprovacao;
		this.aluno = aluno;
		this.itensInscricao = itensInscricao;
	}

	public String getQtdLimiteCreditos() {
		return qtdLimiteCreditos;
	}

	public void setQtdLimiteCreditos(String qtdLimiteCreditos) {
		this.qtdLimiteCreditos = qtdLimiteCreditos;
	}

	public String getPeriodoReferencia() {
		return periodoReferencia;
	}

	public void setPeriodoReferencia(String periodoReferencia) {
		this.periodoReferencia = periodoReferencia;
	}

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public Date getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(Date dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ItensInscricao[] getItensInscricao() {
		return itensInscricao;
	}

	public void setItensInscricao(ItensInscricao[] itensInscricao) {
		this.itensInscricao = itensInscricao;
	}

	public static ItensInscricao adicionarItemInscricao() {
		ItensInscricao insc = new ItensInscricao(0, true);
		return insc;
	}

	public void deletarItemInscricao() {

	}

	public static void realizaInscricaoAluno(Aluno[] alunos) {
		// ATENCAO AINDA NAO ESTA COMPLETO!!!!!!!!
		System.out.println("\n!!!Associar um aluno em uma nova inscricao!!!\n");
		Inscricao[] inscricoesAluno = new Inscricao[10];
		// Aqui e sim uma gambiarra hahaha. Como o program nao remove alunos
		// isso funciona perfeitamente, ate entao, eu confiro se alunos na
		// posicao zero, ou seja, na primeira posicao, existe, caso nao exista,
		// ele imprime que a lista esta vazia
		for (int i = 0; i < inscricoesAluno.length; i++) {
			if (alunos[i] != null) {
				// option define se o programa continua ou para
				int option = 0;
				// choice e a posicoa do array que o usiario vai escolher
				int choice;
				// essa variavel e utilizada para comandar o array de inscricao,
				// a
				// cada vez que ela aumenta, o array muda de posicao
				int qtdInscricoes = 0;
				// chamo o metedo para imprimir a lista de alunos, se ele chegou
				// ate
				// aqui significa que a lista nao esta vazia entao ao menos uma
				// posicao esta livre
				Aluno.listarALunos(alunos);
				try {
					System.out.print("\nEscolha um aluno digitando sua posicao: ");
					choice = in.nextInt();
					String gabarge = in.nextLine();
					choice--;
					do {
						if (alunos[choice] != null) {
							System.out.println("\nDigite o perido do referencia:");
							String periodoReferencia = in.nextLine();
							System.out.println("Digite a data de realizacao da associacao (MODELO XX/XX/XXXX):");
							String data1String = in.nextLine();
							Date dataRealizacao = formatoDate.parse(data1String);
							System.out.println("Digite a data prevista para a aprovacao (MODELO XX/XX/XXXX):");
							data1String = in.nextLine();
							Date dataAprovacao = formatoDate.parse(data1String);
							// Criacao do array de itens de Inscricoes, somente
							// crio
							// e depois coloco os valores zero e true, como o
							// aluno
							// acabou realizar uma inscricao, entao ele esta
							// ativo e
							// com sua notas zeradas
							ItensInscricao[] itensInscricao = new ItensInscricao[10];
							for (int h = 0; h < itensInscricao.length; h++) {
								itensInscricao[h] = adicionarItemInscricao();
							}
							// como essa infromacao e da parte do sistema
							// academico,
							// eu nao pergunto para o usuario, o proprio sistema
							// ja
							// define como sendo 3
							String qtdLimiteCreditos = "3";
							// Instancio a inscricao na posicao definida.
							inscricoesAluno[qtdInscricoes] = new Inscricao(qtdLimiteCreditos, periodoReferencia,
									dataRealizacao, dataAprovacao, alunos[choice], itensInscricao);
							// No array de inscricao que acabei de criar eu
							// instancio todas as
							for (int j = 0; j < itensInscricao.length; j++) {
								itensInscricao[j].setInscricao(inscricoesAluno[qtdInscricoes]);
							}
							System.out.println("\n\nINSCRICAO CRIADA COM SUCESSO!!! AGORA VOCE POSSUI "
									+ (qtdInscricoes + 1) + " INSCRICAO(OES)\n\n");

						} else {
							System.out.println("\nNao existe aluno cadastrado nessa posicao. Tente novamente.\n");
							return;
						}
						boolean error;
						do {
							// Esse try and Catch ser para caso o usuario digite
							// um
							// caractere difrente de numero inteiros
							try {
								error = true;
								option = -1;
								// Aqui eu pergunto se o usuario deseja criar
								// mais
								// alguma inscricao, caso a resposta seja
								// negativa
								// ele somente associara ao aluno o array com as
								// posicoes que ele possui populada
								System.out.println(
										"\nDESEJA FAZER MAIS UMA INSCRICAO PARA ESTE ALUNO? DIGITE [1] PARA SIM E [0] PARA NAO\n");
								option = in.nextInt();
								gabarge = in.nextLine();
							} catch (InputMismatchException e) {
								// Avisando o usuario qual foi o seu erro
								System.out.println(
										"\nPOR FAVOR DIGITE APENAS 0 OU 1. LETRAS E CARACTERES NAO SERAO ACEITOS. TENTE NOVAMENTE!\n");
								gabarge = in.nextLine();
								error = false;
							}
							// crio esse if para avisar o usuario qual foi o seu
							// erro
							if (error) {
								if (option < 0 || option > 1) {
									System.out.println("\nPOR FAVOR DIGITE APENAS 0 OU 1. TENTE NOVAMENTE!\n");
								}
							}

						} while (option < 0 || option > 1);
						// vou incrementar o numero para que na proxima iteracao
						// ele
						// acesse a proxima posicao do array
						if (option == 1) {
							// Aqui eu confiro se qtdInscricoes ja chegou no seu
							// limite, em caso afirmativo, ele associa todas as
							// inscricoes que foram criadas anteriormente; caso
							// seja
							// negativa ele incrementa mais um a variavel
							if (qtdInscricoes < 9) {
								qtdInscricoes++;
							} else {
								System.out.println(
										"\nInfeslizmente a lista ja esta cheia, voce so pode colocar ate 10 inscricoes para um aluno. "
												+ "As inscricoes criada serao associadas ao aluno agora\n");
								option = 0;
							}
						}
					} while (option != 0);
					// Aqui de fato eu associo as incricoes ao aluno na posicao
					// escolhida no inicio das iteracoes
					alunos[choice].setInscricoes(inscricoesAluno);
					for (int j = 0; j < inscricoesAluno.length; j++) {
						if (inscricoesAluno[j] != null) {
							inscricoesAluno[j].setAluno(alunos[choice]);
						}
					}
					System.out.println("\n\nSUAS INSCRICOES FORAM ASSOCIADAS COM SUCESSO.\n\n");
					System.out.println("O aluno(a) " + alunos[choice].getNome() + " agora possui " + (qtdInscricoes + 1)
							+ " Inscricao(oes)!\n\n");
					return;

				} catch (ParseException e) {
					System.out.println(
							"\nOPS PARECE QUE VOCE DIGITOU ALGO ERRADO. DICA: A DATA DEVE SER NESTE FORMATO DD/MM/AAAA COM AS BARRAS\n");
					// caso haja algum erro e cai em uma execessao ele tambem
					// ira para o for
				} catch (InputMismatchException e) {
					System.out.println(
							"\nOPS PARECE QUE VOCE DIGITOU ALGO ERRADO. DICA: DIGITE SOMENTE NUMEROS, LETRAS E CARACTERES NAO SAO ACEITOS\n");
					String gabarge = in.nextLine();
					return;
					// caso haja algum erro e cai em uma execessao ele tambem
					// ira para o for
				}

			} else if (i == 9) {
				System.out.println(
						"\nAVISO! Voce nao possui alunos cadastrados. Primeiro cadastre um aluno para continuar.\n");
			}
		}

	}

}
