package com.esley.web_services_springboot.resources;

import com.esley.web_services_springboot.entities.Order;
import com.esley.web_services_springboot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "orders")
public class OrderResources {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity< List<Order> > findAll() {

        List<Order> orders = orderService.findAll();

        return ResponseEntity.ok().body(orders);
    }

    @GetMapping(value = "/{id}") // Para dizer que minha URL vai ter um parâmetro
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = orderService.FindbyId(id);
        return ResponseEntity.ok().body(obj);
    }
}
