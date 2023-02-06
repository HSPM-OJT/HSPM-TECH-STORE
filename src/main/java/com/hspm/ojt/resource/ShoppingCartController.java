package com.hspm.ojt.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hspm.ojt.domain.ShoppingCart;
import com.hspm.ojt.service.ShoppingCartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/shoppingcart")
public class ShoppingCartController {
	
	private final ShoppingCartService shoppingCartService;
	
	public ShoppingCartController(ShoppingCartService shoppingCartService) {
		super();
		this.shoppingCartService = shoppingCartService;
	}



	@PostMapping("/create")
	public ResponseEntity<?> saveOrUpdate(@Valid @RequestBody ShoppingCart shoppingCart){
		
		ShoppingCart createdShoppingCart = shoppingCartService.saveOrUpdate(shoppingCart);
		
		return new ResponseEntity<ShoppingCart>(createdShoppingCart,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public List<ShoppingCart> findAll(){
		
		return shoppingCartService.findAll();
	}

}