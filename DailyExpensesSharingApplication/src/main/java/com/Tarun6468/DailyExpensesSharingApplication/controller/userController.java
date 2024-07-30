package com.Tarun6468.DailyExpensesSharingApplication.controller;


import com.Tarun6468.DailyExpensesSharingApplication.model.User;
import com.Tarun6468.DailyExpensesSharingApplication.service.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class userController {
    @Autowired
    private userService userService;

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
}

