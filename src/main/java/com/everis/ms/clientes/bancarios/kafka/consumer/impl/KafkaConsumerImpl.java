package com.everis.ms.clientes.bancarios.kafka.consumer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.everis.ms.clientes.bancarios.entity.Customer;
import com.everis.ms.clientes.bancarios.kafka.consumer.IKafkaConsumer;
import com.everis.ms.clientes.bancarios.kafka.producer.IKafkaProducer;
import com.everis.ms.clientes.bancarios.utils.CustomerYankiUtils;

@Service
public class KafkaConsumerImpl implements IKafkaConsumer{

	@Autowired
	private IKafkaProducer kafkaProducer;
	
    @KafkaListener(topics = CustomerYankiUtils.CONSUMER_TOPIC, groupId = CustomerYankiUtils.CONSUMER_GROUP,
            containerFactory = CustomerYankiUtils.CONTAINER_FACTORY)
    public void consumeJson(Customer customer) {
        System.out.println("Consumed JSON Message: " + customer);
    }
}
