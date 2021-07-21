package com.everis.ms.clientes.bancarios.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.everis.ms.clientes.bancarios.entity.Customer;
import com.everis.ms.clientes.bancarios.exception.EntityNotFoundException;
import com.everis.ms.clientes.bancarios.repository.InterfaceCustomerRepository;
import com.everis.ms.clientes.bancarios.repository.InterfaceRepository;
import com.everis.ms.clientes.bancarios.service.InterfaceCustomerService;

import reactor.core.publisher.Mono;
/*
 * Clase que extiende la clase abstracta (CRUD Service Impl) y hereda los métodos del InterfaceCustomerService
 * */
@Service
public class CustomerServiceImpl extends CRUDServiceImpl<Customer, String> implements InterfaceCustomerService{
	//@Value("${msg.error.registro.notfound}")
	//private String msgNotFound;
	private String msgNotFound = "no se encontro el registro";
	
	@Autowired
	private InterfaceCustomerRepository repository;
	 
	@Autowired
	private InterfaceCustomerService service;
	  
	
	@Override
	protected InterfaceRepository<Customer, String> getRepository() {
	  return repository;
	}

	@Override
	public Mono<Customer> findbyIdentityNumber(String identityNumber) {
		// TODO Auto-generated method stub
		return repository.findByIdentityNumber(identityNumber)
				.switchIfEmpty(Mono.error( new EntityNotFoundException(msgNotFound)));
	}
	
	
	@Override
	public Mono<Customer> createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repository.insert(customer);
	}
	
	
	@Override
	public Mono<Customer> updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repository.findById(customer.getId())
				.switchIfEmpty(Mono.error( new EntityNotFoundException(msgNotFound) ))
				 .flatMap(item-> repository.save(customer));
	}
	
	
	@Override
	public Mono<Void> deleteCustomer(String indentityNumber) {
		// TODO Auto-generated method stub
		return  repository.findByIdentityNumber(indentityNumber)
				.switchIfEmpty(Mono.error(new EntityNotFoundException(msgNotFound)))
				.flatMap(item -> repository.deleteById(indentityNumber));
	}

}
