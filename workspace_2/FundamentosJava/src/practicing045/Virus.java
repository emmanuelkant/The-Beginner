package practicing045;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Virus {

	public static void main(String[] args) throws IOException {
		FileWriter es = new FileWriter("ArquivoDoPablo.txt", true);
		BufferedWriter bw = new BufferedWriter(es);
		for (long i = 0; i < 10; i++) {
			bw.write("Pablo te pegou de quatro");
			bw.newLine();
		}
		bw.close();	
	}
}
