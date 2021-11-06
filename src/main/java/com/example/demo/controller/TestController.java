package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.properties.LibraryProperties;
import com.example.demo.service.UserService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private LibraryProperties libraryProperties;

    @Autowired
    UserService userService;

    @GetMapping(value = "/index")
    public String getY() {
        return libraryProperties.getLocation();
    }
    @GetMapping(value = "/books")
    public String getBooks() {
        return libraryProperties.getBooks().toString();
    }

    @GetMapping(value = "/get/{id}")
    public String contextLoads(@PathVariable Integer id) {
        User user = userService.get(id);
        return Optional.ofNullable(user).map(User::toString).orElse("null");
    }
    @PostMapping("/create")
    public Integer createUser( @RequestBody User user) {
        return userService.createUser(user);
    }

}
