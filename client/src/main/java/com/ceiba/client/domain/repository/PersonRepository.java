package com.ceiba.client.domain.repository;

import com.ceiba.client.domain.Person;

import reactor.core.publisher.Flux;

public interface PersonRepository {

	Flux<Person> get();

}