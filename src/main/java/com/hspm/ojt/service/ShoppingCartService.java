package com.hspm.ojt.service;

import java.util.List;

import com.hspm.ojt.domain.ShoppingCart;

public interface ShoppingCartService {
	
	ShoppingCart saveOrUpdate(ShoppingCart shoppingCart);
	
	List<ShoppingCart> findAll();

}
