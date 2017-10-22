package teste;

import lista.Lista;
import lista.Produto;

public class IncrenseTest {
	
	public static void main(String[] args) {
		
		Lista lista = new Lista();
		Produto p =  new Produto();
		p.setNome("Arroz");
		Produto p2 =  new Produto();
		p2.setNome("Feijao");
		Produto p3 =  new Produto();
		p3.setNome("Carne");
		Produto p4 =  new Produto();
		p4.setNome("Farofa");
		Produto p5 =  new Produto();
		p5.setNome("Milho");
		Produto p6 =  new Produto();
		p6.setNome("Alface");
		Produto p7 =  new Produto();
		p7.setNome("Pudim");
		Produto p8 =  new Produto();
		p8.setNome("Mocotó");
		Produto p9 =  new Produto();
		p9.setNome("Macarronese");
		Produto p10 =  new Produto();
		p10.setNome("Ervilha");

		
		lista.add(p);
		System.out.println(lista.toString()); 
		lista.add(p2);
		System.out.println(lista.toString()); 
		lista.add(p3);
		System.out.println(lista.toString()); 
		lista.add(p4);
		System.out.println(lista.toString()); 
		lista.add(p5);
		System.out.println(lista.toString()); 
		lista.add(p6);
		System.out.println(lista.toString()); 
		lista.add(p7);
		System.out.println(lista.toString()); 
		lista.add(p8);
		System.out.println(lista.toString()); 
		lista.add(p9);
		System.out.println(lista.toString()); 
		lista.add(p10);
		System.out.println(lista.toString()); 
		
		Produto p11 =  new Produto();
		p11.setNome("Pimenta");
		
		lista.add(p11);
		System.out.println(lista.toString());
		
	}
}
