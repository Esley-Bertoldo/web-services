package com.esley.web_services_springboot.resources;

import com.esley.web_services_springboot.entities.User;
import com.esley.web_services_springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserResources {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity< List<User> > findAll() {

        List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}") // Para dizer que minha URL vai ter um parâmetro
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.FindbyId(id);
        return ResponseEntity.ok().body(user);
    }
}
