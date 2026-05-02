package com.hexaware.codingchangllenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.codingchangllenge.apiresponse.ApiResponse;
import com.hexaware.codingchangllenge.configuration.JwtUtil;
import com.hexaware.codingchangllenge.entity.User;
import com.hexaware.codingchangllenge.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService us;

   
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<User>> addUser(@RequestBody @Valid User user) {
        User saved = us.addUser(user);
        saved.setPassword(null);
        return ResponseEntity.ok(new ApiResponse<>(true, "User registered successfully", saved));
    }

 
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody User user) {
        User loggedIn = us.login(user.getEmail(), user.getPassword());
        String token = JwtUtil.generateToken(loggedIn.getEmail());
        return ResponseEntity.ok(new ApiResponse<>(true, "Login successful", token));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable int id) {
        User user = us.getUserById(id);
        user.setPassword(null);
        return ResponseEntity.ok(new ApiResponse<>(true, "User fetched", user));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable int id, @RequestBody User user) {
        User updated = us.updateUser(id, user);
        updated.setPassword(null);
        return ResponseEntity.ok(new ApiResponse<>(true, "User updated", updated));
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable int id) {
        us.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "User deleted", null));
    }
}