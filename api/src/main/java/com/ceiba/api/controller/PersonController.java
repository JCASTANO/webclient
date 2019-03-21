package com.ceiba.api.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.api.domain.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@RequestMapping
	public List<Person> get() {
		System.out.println("spring boot persons controller " + LocalDateTime.now());
		return Arrays.asList(new Person("juan 1", "castano rincon"),new Person("juan 2", "castano rincon"));
	}
}
