package com.hspm.ojt.repository;

import org.springframework.data.repository.CrudRepository;

import com.hspm.ojt.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
	
//	void flashDelete(Long id);
	
}
