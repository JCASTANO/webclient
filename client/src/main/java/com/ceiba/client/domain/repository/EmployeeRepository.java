package com.ceiba.client.domain.repository;

import com.ceiba.client.domain.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeRepository {

	Flux<Employee> get();

}