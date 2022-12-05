package com.simas.demo.controller;

import com.simas.demo.entity.User;
import com.simas.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    protected UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getUser(@RequestParam Optional<String> nama) {
        if(nama.isPresent()) {
            return userService.getUserByName(nama.get());
        }
        return userService.getAllUser();
    }
    @GetMapping("/user/many")
    public String getUser(@RequestParam Map<String, String> nama) {
        return String.format("%s", nama.entrySet());
    }
    @GetMapping("/user/{nama}")
    public String getUser(@PathVariable String nama) {
        return String.format("%s", nama);
    }

    @PostMapping("/user")
    public String insertUser(@Valid @RequestBody User data) {
        return userService.insertUser(data);
    }

    @PostMapping("/consume/user")
    public String insertConsumeUser(@Valid @RequestBody User data) {
        return userService.insertUser(data);
    }


    @PutMapping("/user")
    public String updateUser(@Valid @RequestBody User data) {
        return userService.updateUser(data);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable String id) {
        return userService.deleteById(id);
    }
}
