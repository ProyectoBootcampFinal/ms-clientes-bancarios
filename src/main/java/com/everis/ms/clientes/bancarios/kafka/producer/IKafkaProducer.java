package com.everis.ms.clientes.bancarios.kafka.producer;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.everis.ms.clientes.bancarios.entity.Wallet;

public interface IKafkaProducer{
	
	ListenableFuture<SendResult<String, Wallet>> sendJson(String topic, Wallet wallet);		
}
