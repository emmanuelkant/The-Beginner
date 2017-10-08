import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Aluno[] listStudent;
		listStudent = new Aluno[10];
		
		Scanner in = new Scanner(System.in);
		int option, controllerMenu = 1, controller = 0;
		do{
			if (controllerMenu == 1){
				System.out.println("\n##################################");
				System.out.println("##################################");
				System.out.println("##################################");
				System.out.println("########CADASTRO DE ALUNOS########");
				System.out.println("##################################");
				System.out.println("##################################");
				System.out.println("##################################");
				System.out.println("ESCOLHA UMA OPCAO PARA ACESSAR OU DIGITE UM NUMERO NEGATIVO PARA ENCERRAR O PROGRAMA.");
				System.out.println("1 - Cadastrar Aluno");
				System.out.println("2 - Pesquisar Aluno");
				System.out.println("3 - Listar Alunos");
				System.out.println("4 - Excluir Aluno");
			}
			System.out.print("\nEscolha uma opcao:");
			option = in.nextInt();
			switch (option) {
			case 1:
				System.out.println("\nVOCE ESCOLHEU CADASTRAR ALUNO");
				Aluno.singUpStudent(listStudent, controller);
				controllerMenu = 1;
				try {
					listStudent[controller].getNome();
					controller+= 1;
				} catch (NullPointerException e) {
					
				}
				Utility.finalizacao();
				break;
			case 2:
				System.out.println("\nVOCE ESCOLHEU PESQUISAR ALUNO");
				Aluno.searchStudent(listStudent);
				controllerMenu = 1;
				Utility.finalizacao();
				break;
			case 3:
				System.out.println("\nVOCE ESCOLHEU LISTAR ALUNOS");
				Aluno.makeAList(listStudent);
				controllerMenu = 1;
				Utility.finalizacao();
				break;
			case 4:
				System.out.println("\nVOCE ESCOLHEU EXCLUIR ALUNO");
				Aluno.deleteStudent(listStudent);
				controllerMenu = 1;
				Utility.finalizacao();
				break;
	
			default:
				if(option==0 || option>4){
					System.out.println("\nVOCE DIGITOU UM NUMERO INVALIDO. TENTE NOVAMENTE");
				}
				controllerMenu = 0;
				break;
			}
		}while(option>=0);
		System.out.println("\n\nPROGRAMA ENCERRADO");
	}
}
