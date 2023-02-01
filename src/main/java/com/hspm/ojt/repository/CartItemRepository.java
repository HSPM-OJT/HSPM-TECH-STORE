package com.hspm.ojt.repository;

import org.springframework.data.repository.CrudRepository;

import com.hspm.ojt.domain.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{

}