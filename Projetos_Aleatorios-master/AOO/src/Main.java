import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int option;
		System.out.println("##################################");
		System.out.println("##################################");
		System.out.println("##################################");
		System.out.println("########CADASTRO DE ALUNOS########");
		System.out.println("##################################");
		System.out.println("##################################");
		System.out.println("##################################");
		System.out.println("ESCOLHA UMA OP��O PARA ACESSAR");
		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Pesquisar Aluno");
		System.out.println("3 - Excluir Aluno");
		
		do{
			option = in.nextInt();
			switch (option) {
			case 1:
				System.out.println("\nVOC� ESCOLHEU CADASTRAR ALUNO");
				break;
			case 2:
				System.out.println("\nVOC� ESCOLHEU PESQUISAR ALUNO");
				break;
			case 3:
				System.out.println("\nVOC� ESCOLHEU EXCLUIR ALUNO");
				break;
	
			default:
				System.out.println("\nVOC� DIGITOU UM N�MERO INV�LIDO");
				break;
			}
		}while(option<1 || option>3);

	}

}
