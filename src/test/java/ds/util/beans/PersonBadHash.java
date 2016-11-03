package ds.util.beans;

import ds.util.beans.Person;

public class PersonBadHash extends Person {

    public PersonBadHash(int ssn) {
	super(ssn);
    }

    public PersonBadHash(String firstName, String lastName, Integer ssn) {
	super(firstName, lastName, ssn);
    }

    public int hashCode() {
	return 5;
    }
}
