package com.everis.ms.clientes.bancarios.service.impl;

import org.springframework.stereotype.Service;

import com.everis.ms.clientes.bancarios.repository.InterfaceRepository;
import com.everis.ms.clientes.bancarios.service.InterfaceCRUDService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * Clase abstracta que hereda de la interface: InterfaceCRUDService
 */
@Service
public abstract class CRUDServiceImpl<T, K> implements InterfaceCRUDService<T, K> {

	  protected abstract InterfaceRepository<T, K> getRepository();

	  @Override
	  public Mono<T> create(T customer) {
	    return getRepository().save(customer);
	  }
	
	  @Override
	  public Flux<T> findAll() {
	    return getRepository().findAll();
	  }
	
	  @Override
	  public Mono<T> findById(K id) {
	    return getRepository().findById(id);
	  }
	
	  @Override
	  public Mono<T> update(T customer) {    
	    return getRepository().save(customer);
	  }
	
	  @Override
	  public Mono<Void> delete(K id) {
	    return getRepository().deleteById(id);
	  }
}
