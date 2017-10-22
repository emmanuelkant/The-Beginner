package practicing019;

import java.util.ArrayList;

public class Client {

	private ArrayList<Client> list = new ArrayList<Client>();
	private String name;
	private long cpf;
	private String lixo;
	
	public void m1(String name, long cpf, String lixo){
		
		Client newClient = new Client();
		
		list.add(newClient);
		
	}
	
	
}
