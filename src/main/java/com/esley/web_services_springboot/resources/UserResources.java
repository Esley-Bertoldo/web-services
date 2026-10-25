package com.esley.web_services_springboot.resources;

import com.esley.web_services_springboot.entities.User;
import com.esley.web_services_springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<User> findById(@PathVariable Long id) { // @PathVariable: Captura valores presentes no caminho da URL, como o ID de um recurso.
        User user = userService.FindbyId(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {  // @RequestBody: Recebe os dados do corpo da requisição HTTP, geralmente em formato JSON.
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
