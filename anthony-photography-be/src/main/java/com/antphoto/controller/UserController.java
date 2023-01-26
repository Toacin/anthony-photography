package com.antphoto.controller;

import com.antphoto.model.User;
import com.antphoto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        System.out.println("In the basic get for users");
        List<User> userList = repository.findAll();
        return userList;
    }

    @GetMapping("/api/users/{id}")
    public User getSingleUser(@PathVariable Integer id) {
        User user = repository.getReferenceById(id);
        return user;
    }

    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
        System.out.println(user.toString());
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        repository.save(user);
        System.out.println(user.toString());
        return user;
    }

    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User tempUser = repository.getById(id);
        if (!tempUser.equals(null)) {
            user.setId(tempUser.getId());
            repository.save(user);
        }
        return user;
    }


    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }
}