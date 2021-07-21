package com.everis.ms.clientes.bancarios.service;

import com.everis.ms.clientes.bancarios.entity.Customer;

import reactor.core.publisher.Mono;

/**
 * Interface del Service con metodos externos al crud.
 * Interface hereda del InterfaceCRUD
 */

public interface InterfaceCustomerService extends InterfaceCRUDService<Customer, String> {

	Mono<Customer> findbyIdentityNumber(String identityNumber);
	
	Mono<Customer> createCustomer(Customer customer);
	  
	Mono<Customer> updateCustomer(Customer customer);
	  
	Mono<Void> deleteCustomer(String indentityNumber);
}
