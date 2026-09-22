package com.esley.web_services_springboot.services;

import com.esley.web_services_springboot.entities.Order;
import com.esley.web_services_springboot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return  orderRepository.findAll();
    }

    public Order FindbyId(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }


}
