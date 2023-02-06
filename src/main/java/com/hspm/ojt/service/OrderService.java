package com.hspm.ojt.service;

import java.util.List;
import java.util.Optional;

import com.hspm.ojt.domain.Order;

public interface OrderService {
	
	Order saveOrUpdate(Order order);
	
	Optional<Order> findById(Long id);
	
	List<Order> findAll();
	
	void flashDelete(Long id);
	
	

}

