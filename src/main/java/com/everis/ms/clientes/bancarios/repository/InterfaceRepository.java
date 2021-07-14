package com.everis.ms.clientes.bancarios.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/*
 * Interface que llama al Repositorio Reactivo de Mongo
 * */
@NoRepositoryBean
public interface InterfaceRepository<T, K> extends ReactiveMongoRepository<T, K>{

}
