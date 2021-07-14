package com.everis.ms.clientes.bancarios.repository;

import com.everis.ms.clientes.bancarios.entity.Customer;

import reactor.core.publisher.Mono;

/*
 * Interface que hereda del InterfaceRepository
 * */
public interface InterfaceCustomerRepository extends InterfaceRepository<Customer, String>{

	Mono<Customer> findByIdentityNumber(String identityNumber);
}
