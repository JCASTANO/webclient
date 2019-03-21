package com.ceiba.client.application.dto;

import java.util.List;

import com.ceiba.client.domain.Employee;
import com.ceiba.client.domain.Person;

public class PersonResponse {

	private List<Person> persons;
	private List<Employee> employees;
	
	public PersonResponse(List<Person> persons, List<Employee> employees) {
		this.persons = persons;
		this.employees = employees;
	}

	public List<Person> getPersons() {
		return persons;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
}
