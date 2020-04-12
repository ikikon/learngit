package P2;

public class Person {
	private final String personName;
	public Person(String input) {
		this.personName = input;
	}
	public String getName() {
		checkRep();
		return new String(personName);
	}
	public void checkRep() {
		assert this.personName!=null;
	}
}
