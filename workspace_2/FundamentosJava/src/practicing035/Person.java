package practicing035;

public class Person {

	enum Gender {
		MALE,
		FEMALE
	};
	
	private Gender gender;
	
	public Person(Gender gender) {
		super();
		this.gender = gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Gender getGender() {
		return gender;
	}
}
