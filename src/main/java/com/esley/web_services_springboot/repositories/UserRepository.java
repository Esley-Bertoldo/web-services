package com.esley.web_services_springboot.repositories;


import com.esley.web_services_springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
