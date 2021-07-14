package com.everis.ms.clientes.bancarios.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.everis.ms.clientes.bancarios.entity.Customer;

import reactor.core.publisher.Mono;

/*
 * Interface que llama al Repositorio Reactivo de Mongo
 * */
@NoRepositoryBean
public interface InterfaceRepository<T, K> extends ReactiveMongoRepository<T, K>{

	Mono<Customer> findByIdentityNumber(String identityNumber);
}
