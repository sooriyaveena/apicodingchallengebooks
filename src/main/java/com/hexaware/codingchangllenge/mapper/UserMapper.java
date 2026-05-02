package com.hexaware.codingchangllenge.mapper;

import com.hexaware.codingchangllenge.dto.UserRequest;
import com.hexaware.codingchangllenge.dto.UserResponse;
import com.hexaware.codingchangllenge.entity.User;

public class UserMapper {

    public static User toEntity(UserRequest dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        if (dto.getRole() != null) {
            try {
                user.setRole(User.UserRole.valueOf(dto.getRole().toUpperCase()));
            } catch (Exception e) {
                throw new RuntimeException("Invalid role");
            }
        }

        return user;
    }

    public static UserResponse toDTO(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole() != null ? user.getRole().name() : null
        );
    }
}