package com.ceiba.client.infraestructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.client.application.dto.PersonResponse;
import com.ceiba.client.application.handler.GetPersonsQueryHandler;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	private GetPersonsQueryHandler getPersonsQueryHandler;
	
	public PersonController(GetPersonsQueryHandler getPersonsQueryHandler) {
		this.getPersonsQueryHandler = getPersonsQueryHandler;
	}

	@RequestMapping
	@ResponseBody
	public Mono<PersonResponse> get() {
		System.out.println("webflux");
		return getPersonsQueryHandler.execute();
	}
}
