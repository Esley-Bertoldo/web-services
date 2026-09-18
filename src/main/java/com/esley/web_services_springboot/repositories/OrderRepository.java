package com.esley.web_services_springboot.repositories;


import com.esley.web_services_springboot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
