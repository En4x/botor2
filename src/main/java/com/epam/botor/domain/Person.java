package com.epam.botor.domain;

public abstract class Person {

    private final String name;
    private final Gender gender;

    public Person(final String name, final Gender gender) {
        super();
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + "]";
	}
    
    

}
