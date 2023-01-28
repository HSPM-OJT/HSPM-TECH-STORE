package com.hspm.ojt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hspm.ojt.domain.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
	
	Optional<Product> findByProductName(String productName);

}
