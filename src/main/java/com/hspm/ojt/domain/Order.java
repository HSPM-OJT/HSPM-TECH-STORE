package com.hspm.ojt.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//cartItem
	private String productName;
	private Integer price;
	private Integer qty;
	//mainOrder
	private Double subTotal;
	private Double shippingCost;
	private Double grandTotal;
	private LocalDate orderDate;
	private String customerName;
	
	@Email(message = "Customer must be Email.")
	private String customerEmail;
	private String status = "active";
	//shippingAddress
	private String street;
	private String township;
	private String city;
	private String country;
	
	@PrePersist
	void onOrderDate() {
		this.orderDate = LocalDate.now();
	}
	

}
