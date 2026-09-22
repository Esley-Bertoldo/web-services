package com.esley.web_services_springboot.resources;

import com.esley.web_services_springboot.entities.Product;
import com.esley.web_services_springboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductResources {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity< List<Product> > findAll() {

        List<Product> products = productService.findAll();

        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/{id}") // Para dizer que minha URL vai ter um parâmetro
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.FindbyId(id);
        return ResponseEntity.ok().body(product);
    }
}
