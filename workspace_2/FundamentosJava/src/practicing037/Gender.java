package practicing037;

public enum Gender {

	MALE("male", "cabraMacho"),
	FAMALE("famale", "princesa");
	
	private final String value;
	private String value2;
	
	private Gender(String value, String value2){
		this.value = value;
		this.value2 = value2;
	}

	public String getValues() {
		return getValue() + " " + getValue2();
	}
	
	public String getValue() {
		return value;
	}
	
	public String getValue2() {
		return value2;
	}
	
}
