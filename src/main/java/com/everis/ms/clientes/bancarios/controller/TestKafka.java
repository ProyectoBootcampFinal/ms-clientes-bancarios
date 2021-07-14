package com.everis.ms.clientes.bancarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.ms.clientes.bancarios.entity.Customer;
import com.everis.ms.clientes.bancarios.kafka.producer.IKafkaProducer;
import com.everis.ms.clientes.bancarios.utils.CustomerYankiUtils;

@RestController
@RequestMapping("kafka")
public class TestKafka {

    @Autowired
    private IKafkaProducer kafkaProducer;
	
	@GetMapping("/publish")
	public void messageTopic(@RequestParam("message") String nombre) {
		this.kafkaProducer.sendJson(CustomerYankiUtils.PRODUCER_TOPIC, new Customer("20210712",nombre));
	}

}
