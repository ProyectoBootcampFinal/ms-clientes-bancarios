package com.everis.ms.clientes.bancarios.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {

	  @Id
	  private String id;

	  @Field(name = "name")
	  private String name;

	  @Field(name = "identityType")
	  private String identityType;

	  @Field(name = "identityNumber")
	  private String identityNumber;

	  @Field(name = "customerType")
	  private String customerType;

	  @Field(name = "address")
	  private String address;

	  @Field(name = "phoneNumber")
	  private String phoneNumber;

	public Customer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	  
	  
	  
}
