package com.everis.ms.clientes.bancarios.kafka.consumer;

import com.everis.ms.clientes.bancarios.entity.Customer;

public interface IKafkaConsumer {
	public void consumeJson(Customer customer);
}
