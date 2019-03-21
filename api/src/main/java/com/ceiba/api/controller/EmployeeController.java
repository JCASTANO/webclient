package com.ceiba.api.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.api.domain.Employee;

@RestController
@RequestMapping("/employes")
public class EmployeeController {

	@RequestMapping
	public List<Employee> get() {
		System.out.println("spring boot employes controller " + LocalDateTime.now());
		return Arrays.asList(new Employee("juan 3", "castano rincon"),new Employee("juan 4", "castano rincon"));
	}
}
