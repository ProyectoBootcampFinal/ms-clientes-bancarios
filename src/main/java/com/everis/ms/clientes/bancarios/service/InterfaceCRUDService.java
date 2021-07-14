package com.everis.ms.clientes.bancarios.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//T = Table, K = Key
//Interface Padre
public interface InterfaceCRUDService<T, K> {

	Mono<T> create(T customer);
	
	Flux<T> findAll();
	
	Mono<T> findById(K id);
	
	Mono<T> update(T customer);
	
	Mono<Void> delete(K id);
}
