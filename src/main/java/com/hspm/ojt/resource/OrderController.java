package com.hspm.ojt.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hspm.ojt.domain.Order;
import com.hspm.ojt.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/order/")
@CrossOrigin("http://localhost:3000")
public class OrderController {
	
	@Autowired
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> saveOrUpdate(@Valid @RequestBody Order order){
		
		Order createdOrder = orderService.saveOrUpdate(order);
		
		return new ResponseEntity<Order>(createdOrder,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<Order> orderOpt = orderService.findById(id);
		
		if(orderOpt.isEmpty())
			return new ResponseEntity<String>("Order with id = "+id+" is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Order>(orderOpt.get(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/d/{id}")
	public ResponseEntity<?> flashDelete(@PathVariable Long id){
		
		orderService.flashDelete(id);
		return new ResponseEntity<String>("order with id ="+id+" is deleted.",HttpStatus.OK);
	}

	
	@GetMapping("/all")
	public List<Order> findAll(){
		
		return orderService.findAll();
	}

}
