package com.hspm.ojt.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hspm.ojt.domain.CartItem;
import com.hspm.ojt.service.CartItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cartitem")
public class CartItemController {
	
	private final CartItemService cartItemService;

	public CartItemController(CartItemService cartItemService) {
		super();
		this.cartItemService = cartItemService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> saveOrUpdate(@Valid @RequestBody CartItem cartItem){
		
		CartItem createdCartItem = cartItemService.saveOrUpdate(cartItem);
		
		return new ResponseEntity<CartItem>(createdCartItem,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public List<CartItem> findAll(){
		
		return cartItemService.findAll();
	}

}
