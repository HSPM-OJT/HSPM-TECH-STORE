package com.hspm.ojt.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//cartItem
	private String productName;
	private Double price;
	private Integer quantity;
	//mainOrder
	private Double subTotal;
	private Double shippingCost;
	private Double grandTotal;
	private LocalDate orderDate;
	private LocalDate onUpdateOrder;
	private String customerName;
	
	@Email(message = "Email must be email.")
	private String email;
	private String phone;
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
	
	@PreUpdate
	void onUpdateOrder() {
		this.onUpdateOrder = LocalDate.now();
	}
	

}
