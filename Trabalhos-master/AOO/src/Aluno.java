import java.util.InputMismatchException;
import java.util.Scanner;

public class Aluno extends Pessoa{
	static Scanner in = new Scanner(System.in);
	private int semestre;
	private String curso;
	
	public Aluno(String nome, String endereco, String dataNascimento, int semestre, String curso) {
		super(nome, endereco, dataNascimento);
		this.semestre = semestre;
		this.curso = curso;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public static void singUpStudent(Aluno[] listStudent, int i){
		try {
		System.out.print("\nPor favor digite o Nome do Aluno:");
		String nome = in.nextLine();
		System.out.print("Por favor digite o Endereco do Aluno:");
		String endereco = in.nextLine();
		System.out.print("Por favor digite a Data de Nascimento do Aluno:");
		String dataNascimento = in.nextLine();
		System.out.print("Por favor digite o Curso do Aluno:");
		String curso = in.nextLine();
		System.out.print("Por favor digite o Semestre que o Aluno esta cursando:");
		int semestre = in.nextInt();
		String gabarge = in.nextLine();
		listStudent[i] = new Aluno(nome, endereco, dataNascimento, semestre, curso);
		System.out.println("\nO ALUNO FOI ARMAZENADO NA POSICAO DE NUMERO "+(i+1));
		} catch (InputMismatchException e) {
			System.out.println("\nOPS!!! PARECE QUE VOCE DIGITOU ALGUMA COISA ERRADA. TENTE NOVAMENTE");
			String gabarge = in.nextLine();//tenho que fazer isso, não sei muito bem porque mas parece que o Scanner armazena um valor que não era para ser armazenado
		}
	}
	public static void searchStudent(Aluno[] listStudent) {
		System.out.println("\nDIGITE A POSISAO QUE DESEJA ANALISAR (VOCE POSSUI O MAXIMO DE 10 POSICOES)");
		int i = in.nextInt();
		String garbage = in.nextLine(); 
		i -=1;
		try {
			System.out.println("\nNome do Aluno: "+listStudent[i].getNome());
			System.out.println("Endereco do Aluno: "+listStudent[i].getEndereco());
			System.out.println("Data de Nascimento do Aluno: "+listStudent[i].getDataNascimento());
			System.out.println("Este Aluno esta cursando: "+listStudent[i].getCurso()+", e esta no "+listStudent[i].getSemestre()+"° Semestre");
		} catch (NullPointerException e) {
			System.out.println("OPS!!! ESSE LUGAR ESTA VAZIO, POR FAVOR TENTE NOVAMENTE");
		}
	}
	public static void deleteStudent(Aluno[] listStudent) {
		System.out.println("\nDIGITE O CODIGO DO ALUNO QUE DESEJA DELETAR");
		int i = in.nextInt();
		String garbage = in.nextLine(); 
		try {
			i -= 1;
			listStudent[i].setNome(null);
			listStudent[i].setEndereco(null);
			listStudent[i].setDataNascimento(null);
			listStudent[i].setCurso(null);
			listStudent[i].setSemestre(0);
		} catch (Exception e) {
			System.out.println("OPS!!! ESSE LOCAL JÁ ESTA VAZIO, POR FAVOR TENTE NOVAMENTE");
		}
	}
	public static void makeAList(Aluno[] listStudent) {
		for (int i = 0; i < listStudent.length; i++) {
		}		
	}	
}
