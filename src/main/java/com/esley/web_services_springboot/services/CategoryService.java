package com.esley.web_services_springboot.services;

import com.esley.web_services_springboot.entities.Category;
import com.esley.web_services_springboot.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return  categoryRepository.findAll();
    }

    public Category FindbyId(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }


}
