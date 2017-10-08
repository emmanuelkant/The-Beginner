package view;

import java.util.Scanner;

import model.Aluno;
import model.Disciplina;
import model.Inscricao;
import model.ItensInscricao;
import model.Professor;
import model.Turma;

public class Interface {
	// assim eu nao preciso criar toda hora o Scanner
	static Scanner in = new Scanner(System.in);
	// iniciando o array de alunos que vai ser usado posteriormente
	static Aluno[] alunos = new Aluno[10];
	// iniciando o array de inscricao que vai ser usado posteriormente
	static Inscricao[] inscricoes = new Inscricao[10];
	static Professor[] professor = new Professor[10];
	static Disciplina[] disciplina = new Disciplina[10];
	static Turma[] turma = new Turma[10];

	public static void menu() {
		int option = 0;
		boolean error = true, verificaCabecalho = true;
		do {
			if (verificaCabecalho) {
				cabecalhoMenu();
				verificaCabecalho = false;
			}
			try {
				System.out.println("Escolha sua opcao:");
				String valor = in.nextLine();
				option = Integer.parseInt(valor);
			} catch (NumberFormatException e) {
				error = false;
				System.out.println("Opcao invalida. Tente Novamente.\n");
			}
			switch (option) {
			case 1:
				menuModuloAluno();
				verificaCabecalho = true;
				break;
			case 2:
				menuModuloProfessor();
				verificaCabecalho = true;
				break;
			case 3:
				menuModuloDisciplina();
				verificaCabecalho = true;
				break;
			case 4:
				menuModuloTurma();
				verificaCabecalho = true;
				break;
			case 5:
				menuModuloAssociocao();
				verificaCabecalho = true;
				break;
			case 6:
				menuModuloListar();
				verificaCabecalho = true;
				break;
			case 7:
				System.exit(0);
				System.out.println("---FIM DA EXECUCAO---");
				break;
			default:
				if (error) {
					System.out.println("Opcao invalida. Tente Novamente.\n");
				}
				break;
			}
			error = true;
			option = 0;
		} while (option != 7);
	}

	private static void menuModuloTurma() {
		int option = 0;
		boolean error = true, verificaCabecalho = true;
		do {
			if (verificaCabecalho) {
				cabecalhoMenuTurma();
				verificaCabecalho = false;
			}
			try {
				System.out.println("Escolha sua opcao:");
				String valor = in.nextLine();
				option = Integer.parseInt(valor);
			} catch (NumberFormatException e) {
				error = false;
				System.out.println("Opcao invalida. Tente Novamente.\n");
			}
			switch (option) {
			case 1:
				Turma.cadastraTurma(turma, disciplina);
				verificaCabecalho = true;
				break;
			case 2:
				Turma.listarTurma(turma);
				verificaCabecalho = true;
				break;
			case 3:
				Turma.localizarTurma(turma);
				verificaCabecalho = true;
				break;
			case 4:
				System.out.println("");
				return;
			default:
				if (error) {
					System.out.println("Opcao invalida. Tente Novamente.\n");
				}
				break;
			}
			error = true;
			option = 0;
		} while (option != 4);
	}

	private static void menuModuloDisciplina() {
		int option = 0;
		boolean error = true, verificaCabecalho = true;
		do {
			if (verificaCabecalho) {
				cabecalhoMenuDisciplina();
				verificaCabecalho = false;
			}
			try {
				System.out.println("Escolha sua opcao:");
				String valor = in.nextLine();
				option = Integer.parseInt(valor);
			} catch (NumberFormatException e) {
				error = false;
				System.out.println("Opcao invalida. Tente Novamente.\n");
			}
			switch (option) {
			case 1:
				Disciplina.cadastrardisciplinas(disciplina);
				verificaCabecalho = true;
				break;
			case 2:
				Disciplina.ListarDisciplina(disciplina);
				verificaCabecalho = true;
				break;
			case 3:
				Disciplina.localizarDisciplina(disciplina);
				verificaCabecalho = true;
				break;
			case 4:
				System.out.println("");
				return;
			default:
				if (error) {
					System.out.println("Opcao invalida. Tente Novamente.\n");
				}
				break;
			}
			error = true;
		} while (option != 4);
	}

	private static void menuModuloProfessor() {
		int option = 0;
		boolean error = true, verificaCabecalho = true;
		do {
			if (verificaCabecalho) {
				cabecalhoMenuProfessor();
				verificaCabecalho = false;
			}
			try {
				System.out.println("Escolha sua opcao:");
				String valor = in.nextLine();
				option = Integer.parseInt(valor);
			} catch (NumberFormatException e) {
				error = false;
				System.out.println("Opcao invalida. Tente Novamente.\n");
			}
			switch (option) {
			case 1:
				Professor.CadastrarProfessor(professor);
				verificaCabecalho = true;
				break;
			case 2:
				Professor.listarProfessores(professor);
				verificaCabecalho = true;
				break;
			case 3:
				Professor.localizarProfessores(professor);
				verificaCabecalho = true;
				break;
			case 4:
				System.out.println("");
				return;
			default:
				if (error) {
					System.out.println("Opcao invalida. Tente Novamente.\n");
				}
				break;
			}
			error = true;
		} while (option != 4);
	}

	private static void menuModuloAluno() {
		int option = 0;
		boolean error = true, verificaCabecalho = true;
		do {
			if (verificaCabecalho) {
				cabecalhoMenuAluno();
				verificaCabecalho = false;
			}
			try {
				System.out.println("Escolha sua opcao:");
				String valor = in.nextLine();
				option = Integer.parseInt(valor);
			} catch (NumberFormatException e) {
				error = false;
				System.out.println("Opcao invalida. Tente Novamente.\n");
			}
			switch (option) {
			case 1:
				Aluno.cadastrarAluno(alunos);
				verificaCabecalho = true;
				break;
			case 2:
				Aluno.listarALunos(alunos);
				verificaCabecalho = true;
				break;
			case 3:
				Aluno.localizaAluno(alunos);
				verificaCabecalho = true;
				break;
			case 4:
				// So pula linha mesmo
				System.out.println("");
				// retorna para o ultimo menu
				return;
			default:
				if (error) {
					System.out.println("Opcao invalida. Tente Novamente.\n");
				}
				break;
			}
			error = true;
			option = 0;
		} while (option != 4);
	}

	private static void menuModuloAssociocao() {
		int option = 0;
		boolean error = true, verificaCabecalho = true;
		do {
			if (verificaCabecalho) {
				cabecalhoMenuAssociacao();
				verificaCabecalho = false;
			}
			try {
				System.out.println("Escolha sua opcao:");
				String valor = in.nextLine();
				option = Integer.parseInt(valor);
			} catch (NumberFormatException e) {
				error = false;
				System.out.println("Opcao invalida. Tente Novamente.\n");
			}
			switch (option) {
			case 1:
				Aluno.associaAlunoTurma(alunos, turma);
				verificaCabecalho = true;
				break;
			case 2:
				Professor.Associacao(professor, disciplina);
				verificaCabecalho = true;
				break;
			case 3:
				Inscricao.realizaInscricaoAluno(alunos);
				verificaCabecalho = true;
				break;
			case 4:
				return;
			default:
				if (error) {
					System.out.println("Opcao invalida. Tente Novamente.\n");
				}
				break;
			}
			error = true;
			option = 0;
		} while (option != 5);
	}

	private static void menuModuloListar() {
		int option = 0;
		boolean error = true, verificaCabecalho = true;
		do {
			if (verificaCabecalho) {
				cabecalhoMenuListagem();
				verificaCabecalho = false;
			}
			try {
				System.out.println("Escolha sua opcao:");
				String valor = in.nextLine();
				option = Integer.parseInt(valor);
			} catch (NumberFormatException e) {
				error = false;
				System.out.println("Opcao invalida. Tente Novamente.\n");
			}
			switch (option) {
			case 1:
				Turma.listaAlunosTurma(turma);
				verificaCabecalho = true;
				break;
			case 2:
				Disciplina.listaProfessoresDisciplina(disciplina);
				verificaCabecalho = true;
				break;
			case 3:
				return;
			default:
				if (error) {
					System.out.println("Opcao invalida. Tente Novamente.\n");
				}
				break;
			}
			error = true;
			option = 0;
		} while (option != 3);
	}

	private static void cabecalhoMenu() {
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("########--SISTEMA EDUCACIONAL--#######");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("(1) - Modulo Aluno");
		System.out.println("(2) - Modulo Professor");
		System.out.println("(3) - Modulo Disciplina");
		System.out.println("(4) - Modulo Turma");
		System.out.println("(5) - Modulo Associacao");
		System.out.println("(6) - Modulo Listar");
		System.out.println("(7) - SAIR");
	}

	private static void cabecalhoMenuTurma() {
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("########--SISTEMA EDUCACIONAL--#######");
		System.out.println("########------MODULO TURMA-----#######");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("(1) - Cadastrar Turma");
		System.out.println("(2) - Listar Turmas");
		System.out.println("(3) - Localizar Turma");
		System.out.println("(4) - VOLTAR");
	}

	private static void cabecalhoMenuDisciplina() {
		System.out.println("\n######################################");
		System.out.println("######################################");
		System.out.println("########--SISTEMA EDUCACIONAL--#######");
		System.out.println("########---MODULO DISCIPLINA---#######");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("(1) - Cadastrar Disciplina");
		System.out.println("(2) - Listar Disciplinas");
		System.out.println("(3) - Localizar Disciplina");
		System.out.println("(4) - VOLTAR");
	}

	private static void cabecalhoMenuProfessor() {
		System.out.println("\n######################################");
		System.out.println("######################################");
		System.out.println("########--SISTEMA EDUCACIONAL--#######");
		System.out.println("########----MODULO PROFESSOR---#######");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("(1) - Cadastrar Professor");
		System.out.println("(2) - Listar Professores");
		System.out.println("(3) - Localizar Professor");
		System.out.println("(4) - VOLTAR");
	}

	private static void cabecalhoMenuAluno() {
		System.out.println("\n######################################");
		System.out.println("######################################");
		System.out.println("########--SISTEMA EDUCACIONAL--#######");
		System.out.println("########------MODULO ALUNO----#######");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("(1) - Cadastrar Aluno");
		System.out.println("(2) - Listar Alunos");
		System.out.println("(3) - Localizar Aluno");
		System.out.println("(4) - VOLTAR");
	}

	private static void cabecalhoMenuAssociacao() {
		System.out.println("\n######################################");
		System.out.println("######################################");
		System.out.println("########--SISTEMA EDUCACIONAL--#######");
		System.out.println("########---MODULO ASSOCIACAO---#######");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("(1) - Associar Aluno a Turma");
		System.out.println("(2) - Associar Profesor a Disciplina");
		System.out.println("(3) - Realizar a Inscricao de um Aluno");
		System.out.println("(4) - VOLTAR");
	}

	private static void cabecalhoMenuListagem() {
		System.out.println("\n######################################");
		System.out.println("######################################");
		System.out.println("########--SISTEMA EDUCACIONAL--#######");
		System.out.println("########-------LISTAGEM--------#######");
		System.out.println("######################################");
		System.out.println("######################################");
		System.out.println("(1) - Listar Alunos de uma Turma");
		System.out.println("(2) - Listar Profesores de uma discplina");
		System.out.println("(3) - VOLTAR");
	}
}
