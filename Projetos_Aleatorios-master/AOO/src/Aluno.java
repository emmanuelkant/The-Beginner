
public class Aluno extends Pessoa{
	private int semestre;
	private String curso;
	
	public Aluno(String nome, String endere�o, String dataNascimento, int semestre, String curso) {
		super(nome, endere�o, dataNascimento);
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
	
	
}
