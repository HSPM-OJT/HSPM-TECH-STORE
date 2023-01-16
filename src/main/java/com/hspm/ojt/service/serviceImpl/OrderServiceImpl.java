package com.hspm.ojt.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hspm.ojt.domain.Order;
import com.hspm.ojt.repository.OrderRepository;
import com.hspm.ojt.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public Order saveOrUpdate(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return (List<Order>) orderRepository.findAll();
	}

	@Override
	public Optional<Order> findById(Long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id);
	}
	
//	@Override
//	public void flashDelete(Long id) {
//		// TODO Auto-generated method stub
//		Optional<Order> orderOpt = orderRepository.findById(id);
//		
//		Order order = orderOpt.get();
//		
//		if(orderOpt.isPresent())
//			order.setStatus("deleted");
//		
//		orderRepository.save(order);
//			
//			
//	}


}
