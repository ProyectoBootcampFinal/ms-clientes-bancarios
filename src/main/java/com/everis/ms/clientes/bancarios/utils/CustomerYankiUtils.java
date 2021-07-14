package com.everis.ms.clientes.bancarios.utils;

public class CustomerYankiUtils {

	public static final String CONSUMER_GROUP="group-consulta-cliente";
	public static final String SERVER_CONFIG="localhost:9092";
	public static final String CONSUMER_TOPIC="topic-consulta-cliente";
	public static final String PRODUCER_TOPIC="topic-consulta-respuesta-cliente";
	public static final String CONTAINER_FACTORY="CustomerKafkaListenerFactory";
}
