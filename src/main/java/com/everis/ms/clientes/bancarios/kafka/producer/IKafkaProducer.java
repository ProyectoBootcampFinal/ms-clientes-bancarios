package com.everis.ms.clientes.bancarios.kafka.producer;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.everis.ms.clientes.bancarios.entity.Customer;

public interface IKafkaProducer{
	
	ListenableFuture<SendResult<String, Customer>> sendJson(String topic, Customer customer);	
}
