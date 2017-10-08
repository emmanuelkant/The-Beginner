package model;

public class ItensInscricao {
	private int nota;
	private boolean cancelado;
	private Inscricao inscricao;
	private Turma turma;
	
	public ItensInscricao(int nota, boolean cancelado) {
		this.nota = nota;
		this.cancelado = cancelado;
	}
	
	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	

}
