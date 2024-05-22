package com.example.astonhibernate.controller;

import com.example.astonhibernate.entity.User;
import com.example.astonhibernate.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public String create(@RequestBody User user) {
        userService.addUser(user);
        return "Успешно";
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping()
    public String update(@RequestBody User user) {
        userService.updateUser(user);
        return "Успешно";
    }

    @DeleteMapping()
    public String delete(@RequestBody User user) {
        userService.deleteUser(user);
        return "Успешно";
    }
}
