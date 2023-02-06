package com.hspm.ojt.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hspm.ojt.domain.ShoppingCart;
import com.hspm.ojt.repository.ShoppingCartRepository;
import com.hspm.ojt.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	private final ShoppingCartRepository shoppingCartRepository;

	public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
		super();
		this.shoppingCartRepository = shoppingCartRepository;
	}

	@Override
	public ShoppingCart saveOrUpdate(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return shoppingCartRepository.save(shoppingCart);
	}

	@Override
	public List<ShoppingCart> findAll() {
		// TODO Auto-generated method stub
		return (List<ShoppingCart>) shoppingCartRepository.findAll();
	}

}