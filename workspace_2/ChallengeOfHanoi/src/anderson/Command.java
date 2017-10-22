package anderson;

public class Command {
	
	private int n; //Numero de discos.
	private int source; // Pino de origem.
	private int destination; // Pino de destino.
	private int aux; // Pino de trabalho.
	
	public Command(int n, int source, int destination, int aux){
		this.n = n;
		this.source = source;
		this.destination = destination;
		this.aux = aux;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getAux() {
		return aux;
	}

	public void setAux(int aux) {
		this.aux = aux;
	}
	
	

}
