package com.hexaware.codingchangllenge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {


    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;

    private String role;

}

