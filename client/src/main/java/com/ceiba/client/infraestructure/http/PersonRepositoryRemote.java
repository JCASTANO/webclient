package com.ceiba.client.infraestructure.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.ceiba.client.domain.Person;
import com.ceiba.client.domain.repository.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonRepositoryRemote implements PersonRepository {
    
    private final WebClient webClient;
    
    public PersonRepositoryRemote(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    
    public Flux<Person> get() {
        
        return webClient.get()
                        .uri("http://localhost:8090/persons")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("Error 4xx")))
                        .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("Error 5xx")))
                        .bodyToFlux(Person.class);
    }
    
}
