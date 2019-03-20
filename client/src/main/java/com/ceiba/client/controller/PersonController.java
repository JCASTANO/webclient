package com.ceiba.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.client.domain.Person;
import com.ceiba.client.http.PersonRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	private PersonRepository personRepository;
	
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@RequestMapping
	@ResponseBody
	public Flux<Person> get() {
		System.out.println("webflux");
		return personRepository.get();
	}
}
