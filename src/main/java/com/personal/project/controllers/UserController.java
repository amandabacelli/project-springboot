package com.personal.project.controllers;

import com.personal.project.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    public ResponseEntity<User> findAll() {
        User user = new User( 1L, "Amanda", "email@email.com", "4567788");
        return ResponseEntity.ok().body(user);
    }

}
