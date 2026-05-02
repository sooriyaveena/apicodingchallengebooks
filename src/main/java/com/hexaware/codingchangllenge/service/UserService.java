package com.hexaware.codingchangllenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.codingchangllenge.entity.User;
import com.hexaware.codingchangllenge.repository.UserRepo;



@Service
public class UserService {

    @Autowired
    private UserRepo ur;


 
    public User addUser(User user) {
    User existing = ur.findByEmail(user.getEmail());
    if (existing != null) {
        throw new RuntimeException("Email already exists");
    }
    user.setRole(User.UserRole.USER);

    return ur.save(user);
}

    public User login(String email, String password) {
        User user = ur.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Wrong Password");
        }

        return user;
    }

    public User getUserById(int id) {
        return ur.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(int id, User user) {

        User u = getUserById(id);

        u.setName(user.getName());
       u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());

        return ur.save(u);
    }

    public String deleteUser(int id) {
        User u= getUserById(id);
        ur.delete(u);
        return "Deleted Successfully";
    }
}