package com.esley.web_services_springboot.services;

import com.esley.web_services_springboot.entities.Product;
import com.esley.web_services_springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return  productRepository.findAll();
    }

    public Product FindbyId(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }


}
