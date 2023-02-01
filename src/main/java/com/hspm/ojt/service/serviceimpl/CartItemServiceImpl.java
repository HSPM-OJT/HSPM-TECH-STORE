package com.hspm.ojt.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hspm.ojt.domain.CartItem;
import com.hspm.ojt.repository.CartItemRepository;
import com.hspm.ojt.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	private final CartItemRepository cartItemRepository;

	public CartItemServiceImpl(CartItemRepository cartItemRepository) {
		super();
		this.cartItemRepository = cartItemRepository;
	}

	@Override
	public CartItem saveOrUpdate(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartItemRepository.save(cartItem);
	}

	@Override
	public List<CartItem> findAll() {
		// TODO Auto-generated method stub
		return (List<CartItem>) cartItemRepository.findAll();
	}

}
