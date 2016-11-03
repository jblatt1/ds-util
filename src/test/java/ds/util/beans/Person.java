package ds.util.beans;

public class Person {

    protected String firstName;
    protected String lastName;
    protected Integer ssn;

    public Person(int ssn) {
	this("","", ssn);
    }

    public Person(String firstName, String lastName, Integer ssn) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.ssn = ssn;
    }

    public boolean equals(Object o) {
	if(o instanceof Person) {
	    return this.ssn == ((Person) o).ssn;
	}
	return false;
    }

    public int hashCode() {
	return ssn.hashCode();
    }
}
