package com.hspm.ojt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hspm.ojt.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
	
//	void flashDelete(Long id);
	
}
