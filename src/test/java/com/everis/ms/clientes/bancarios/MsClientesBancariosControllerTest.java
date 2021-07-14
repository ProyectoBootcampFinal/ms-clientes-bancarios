package com.everis.ms.clientes.bancarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;

import com.everis.ms.clientes.bancarios.entity.Customer;
import com.everis.ms.clientes.bancarios.repository.InterfaceCustomerRepository;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class MsClientesBancariosControllerTest {

	@Autowired 
	private InterfaceCustomerRepository repository;
	
	//UNIT TEST Encontrar Identificacion
	@Test
	public void findByIdentityNumber() {
		Customer customer1 = new Customer();
		
		customer1.setId("1");
		customer1.setName("MIGUEL");
		customer1.setIdentityType("DNI");
		customer1.setIdentityNumber("96385274");
		customer1.setCustomerType("PERSONAL");
		customer1.setAddress("PERU");
		customer1.setPhoneNumber("999999999");
		
		repository.save(customer1);
		
		Mono<Customer> found = repository.findByIdentityNumber(customer1.getIdentityNumber());
		
		StepVerifier.create(found)
		.expectNext()
		.verifyComplete();
				
		//Assertions.assertThat(found.subscribe(System.out::println));
	}
}
