package com.hspm.ojt.service;

import java.util.List;

import com.hspm.ojt.domain.CartItem;

public interface CartItemService {
	
	CartItem saveOrUpdate(CartItem cartItem);
	
	List<CartItem> findAll();

}
