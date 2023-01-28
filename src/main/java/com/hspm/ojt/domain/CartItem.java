package com.hspm.ojt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CartItem {
	
	//List
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long productId; //join table //product list
	private Long shoppingCartId; //join talbe
	
	private Integer quantity;
	private Double price;
	private Double subTotal;
	private Long orderId;

}
