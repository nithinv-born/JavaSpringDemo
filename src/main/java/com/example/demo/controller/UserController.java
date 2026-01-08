package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // ---------- CREATE USER (TRANSACTION) ----------
    @PostMapping
    public User create(@Valid @RequestBody UserRequest request) {
        return service.createUser(request);
    }

    // ---------- GET USERS (PAGINATION + SORT + FILTER) ----------
    @GetMapping
    public Page<User> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        return service.getUsers(page, size, sortBy, direction, name, email);
    }

    @GetMapping("/{id}")
public User getById(@PathVariable Long id) {
    return service.getUserById(id);
}
}
