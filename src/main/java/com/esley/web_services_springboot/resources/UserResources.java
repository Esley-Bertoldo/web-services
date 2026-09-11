package com.esley.web_services_springboot.resources;

import com.esley.web_services_springboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Esley", "Esley32@gmail.com", "9999999", "1234");
        return ResponseEntity.ok().body(u);
    }
}
