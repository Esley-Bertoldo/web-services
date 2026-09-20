package com.esley.web_services_springboot.repositories;


import com.esley.web_services_springboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
