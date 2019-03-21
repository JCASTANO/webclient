package com.ceiba.client.application.handler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.client.application.dto.PersonResponse;
import com.ceiba.client.domain.Employee;
import com.ceiba.client.domain.Person;
import com.ceiba.client.domain.repository.EmployeeRepository;
import com.ceiba.client.domain.repository.PersonRepository;

import reactor.core.publisher.Mono;

@Component
public class GetPersonsQueryHandler {

	private PersonRepository personRepository;
	private EmployeeRepository employeeRepository;
	
	public GetPersonsQueryHandler(PersonRepository personRepository, EmployeeRepository employeeRepository) {
		this.personRepository = personRepository;
		this.employeeRepository = employeeRepository;
	}
	
	public Mono<PersonResponse> execute() {
		System.out.println("inicio " + LocalDateTime.now());
		Mono<List<Person>> personsPromise = this.personRepository.get().collectList();
		Mono<List<Employee>> employesPromise = this.employeeRepository.get().collectList();
		
		return personsPromise.zipWith(employesPromise, (persons,employes) -> {
			System.out.println("fin " + LocalDateTime.now());
			return new PersonResponse(persons, employes);
		});
	}
}
