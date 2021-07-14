package com.everis.ms.clientes.bancarios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.everis.ms.clientes.bancarios.entity.Customer;
import com.everis.ms.clientes.bancarios.repository.InterfaceCustomerRepository;
import com.everis.ms.clientes.bancarios.service.InterfaceCustomerService;
import com.everis.ms.clientes.bancarios.service.impl.CustomerServiceImpl;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/*
 * Test con Mockito
 * */
@ExtendWith(MockitoExtension.class)
class CustomerImplTest {

	@Mock
	InterfaceCustomerRepository repository;
	
	@Mock
	ReactiveMongoTemplate mongoTemplate; 
	
	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Mock 
	CustomerServiceImpl service;
	
	@Test
	void test() {
		when(repository.findAll()).thenReturn(DatosCustomer.CLIENTE);
		Flux<Customer> list = customerService.findAll();
		StepVerifier.create(list)
		.expectSubscription()
		.expectNextCount(2)
		.verifyComplete();
	}

}
