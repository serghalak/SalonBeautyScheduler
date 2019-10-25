package com.salon.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping
    public String getUser(){
        return "get some user ...";
    }

    @PostMapping
    public String createUser(){
        return "post create some user ...";
    }

    @PutMapping
    public String updateUser(){
        return "put update some user ...";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete delete some user ...";
    }
}
