package com.ceiba.api.domain;

public class Employee {

	private String name;
	private String lastName;
	
	public Employee() {}
	
	public Employee(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
}
