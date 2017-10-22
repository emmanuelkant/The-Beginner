package practicing056;

public class Ponteiros {

	public static void main(String[] args) {

//		Person p1, p2, p3, p4;
//		p1 = new Person("Jorge");
//		p2 = new Person("Mateus");
//		p3 = p1;
//		p4 = p3;
//		p3.setName("Jorge2");
//		System.out.println(p1.getName());
//		System.out.println(p3.getName());
//		System.out.println(p4.getName());

//		int i1, i2, i3;
//		i1 = 1;
//		i2 = 2;
//		i3 = i1;
//		System.out.println(i1);
//		System.out.println(i3);
//		i3 = 10;
//		System.out.println(i1);
//		System.out.println(i3);
		
		Person p1, p2, p3, p4, p5;
		p1 = new Person("Jorge");
		p2 = new Person("Mateus");
		p3 = new Person("Leandro");
		p4 = p2;
		p5 = p2;
		p3 = null;
		p2 = null;
		p4 = new Person("Ana Carolina");
		p1 = new Person("Seu Jorge");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		
	}

}
