package com.everis.ms.clientes.bancarios.kafka.producer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.everis.ms.clientes.bancarios.entity.Customer;
import com.everis.ms.clientes.bancarios.entity.Wallet;
import com.everis.ms.clientes.bancarios.kafka.producer.IKafkaProducer;


@Service
public class KafkaProducerImpl implements IKafkaProducer{

    @Autowired
    private KafkaTemplate<String, Wallet> kafkaTemplate;
	
	@Override
	public ListenableFuture<SendResult<String, Wallet>> sendJson(String topic, Wallet wallet) {
		return kafkaTemplate.send(topic, wallet);
	}


}
