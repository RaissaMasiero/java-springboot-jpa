package com.mavenproject.course.resources;

import com.mavenproject.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // diz que é resurso web implementado por controlador rest
@RequestMapping(value = "/users") // nome do recurso
public class UserResource {

    @GetMapping // diz que responde a requisição get do http
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria", "maria@gmail.com", "99129931", "12345");
        return ResponseEntity.ok().body(u);
    }
}
