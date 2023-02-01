package com.hspm.ojt.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hspm.ojt.domain.Product;
import com.hspm.ojt.service.MapValidationErrorService;
import com.hspm.ojt.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	private final ProductService productService;
	private final MapValidationErrorService mapValidationErrorService;

	public ProductController(ProductService productService, MapValidationErrorService mapValidationErrorService) {
		super();
		this.productService = productService;
		this.mapValidationErrorService = mapValidationErrorService;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@Valid @RequestBody Product product,BindingResult bindingResult){
		ResponseEntity<?> responseErrorObject = mapValidationErrorService.validate(bindingResult);
		
		if(responseErrorObject != null)
			return responseErrorObject;
		
		Product createProduct = productService.saveorUpdate(product);
		
		return new ResponseEntity<Product>(createProduct,HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<Product> productOpt = productService.findById(id);
		
		if(productOpt.isEmpty()) {
			new ResponseEntity<String>("Product with id="+id+" is not foundt",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Product>(productOpt.get(),HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/name/{productName}")
	public ResponseEntity<?> findByProuductName(@PathVariable String productName){
		
		Optional<Product> productOpt = productService.findByProductName(productName);
		
		if(productOpt.isEmpty()) {
			new ResponseEntity<>("Product with name="+productName+" is not found",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Product>(productOpt.get(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		productService.deleteById(id);
		
		return new ResponseEntity<String>("Deleted id="+id,HttpStatus.OK);
	}
	
	
	
	
	
	

}
