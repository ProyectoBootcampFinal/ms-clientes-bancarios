package com.everis.ms.clientes.bancarios;

import com.everis.ms.clientes.bancarios.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DatosCustomer {

	public final static Flux<Customer> CLIENTE = Flux.just(
			new Customer("1", "MIGUEL", "DNI", "96857485", "PERSONAL", "PERU", "999999999"),
			new Customer("2", "DIEGO", "DNI", "74859674", "PERSONAL", "PERU", "888888888"));
	
}
