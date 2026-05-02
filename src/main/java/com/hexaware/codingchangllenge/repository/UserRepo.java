package com.hexaware.codingchangllenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.codingchangllenge.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

    public User findByEmail(String email);



    
}
