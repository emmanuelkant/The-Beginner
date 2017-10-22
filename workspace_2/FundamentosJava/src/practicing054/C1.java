package practicing054;

public class C1<T> {
	
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		C1<String> c1 = new C1<String>();
		c1.setT("Juca Kifure");
		System.out.println(c1.getT());
	}

}
