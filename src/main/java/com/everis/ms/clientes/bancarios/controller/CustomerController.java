package com.everis.ms.clientes.bancarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.ms.clientes.bancarios.entity.Customer;
import com.everis.ms.clientes.bancarios.service.InterfaceCustomerService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * Clase Controlador 
 * */
@Slf4j
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	  @Autowired
	  private InterfaceCustomerService service;
	    
	  /** Listado de clientes. */
	  @GetMapping
	  public Flux<Customer> findAll() { 
		  log.info("CustomerController.findAll, calling");
		  return service.findAll();
	  }
	  
	  /** Buscar cliente por numero de identidad. */
	  @GetMapping("/{indentityNumber}")
	  public Mono<Customer> findByIdentityNumber(@PathVariable("indentityNumber") String indentityNumber) {
		  log.info("CustomerController.findById, id value has -> "+indentityNumber);
		  return service.findbyIdentityNumber(indentityNumber);
	  }
	  
	  /** Crear cliente. */
	  @PostMapping
	  public Mono<Customer> create(@RequestBody Customer customer) {
		  log.info("CustomerController.insert is calling");
		  return service.createCustomer(customer);
	  }
	  
	  /** Actualizar cliente por numero de identidad. */
	  @PutMapping("/{indentityNumber}")
	  public Mono<Customer> update(@RequestBody Customer customer, @PathVariable("indentityNumber") String indentityNumber) {
		  log.info("CustomerController.update is calling");
		  return service.updateCustomer(customer, indentityNumber);
	  }
	  
	  /** Eliminar cliente por numero de identidad. */
	  @DeleteMapping("/{indentityNumber}")
	  public Mono<Customer> delete(@PathVariable("indentityNumber") String indentityNumber) {
		  log.info("CustomerController.update is calling");
		  return service.deleteCustomer(indentityNumber);	    
	  }
}
