package com.sxh.spring.testBean;

public class Family {
	private String familyName;
	private Person person;
	public Family(String familyName, Person person) {
		super();
		this.familyName = familyName;
		this.person = person;
	}
	@Override
	public String toString() {
		return "Family [familyName=" + familyName + ", person=" + person + "]";
	}
}
