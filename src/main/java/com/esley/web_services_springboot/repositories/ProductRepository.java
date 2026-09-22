package com.esley.web_services_springboot.repositories;

import com.esley.web_services_springboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
