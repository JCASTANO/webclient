package com.ceiba.client.infraestructure.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.ceiba.client.domain.Employee;
import com.ceiba.client.domain.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeRepositoryRemote implements EmployeeRepository {
    
    private final WebClient webClient;
    
    public EmployeeRepositoryRemote(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    
    public Flux<Employee> get() {
        
        return webClient.get()
                        .uri("http://localhost:8090/employes")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("Error 4xx")))
                        .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("Error 5xx")))
                        .bodyToFlux(Employee.class);
    }
    
}
