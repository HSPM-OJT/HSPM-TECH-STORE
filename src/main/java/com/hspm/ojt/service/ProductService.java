package com.hspm.ojt.service;

import java.util.List;
import java.util.Optional;

import com.hspm.ojt.domain.Product;

public interface ProductService {
	
	//create and update
	Product saveorUpdate(Product product);
	
	List<Product> findAll();
	
	//find by id
	Optional<Product> findById(Long id);
	
	//find by ProductName
	Optional<Product> findByProductName(String productName);
	
	//Delete by id
	void deleteById(Long id);
	
	

}
