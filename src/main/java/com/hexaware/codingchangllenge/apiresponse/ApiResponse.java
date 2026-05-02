package com.hexaware.codingchangllenge.apiresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
 
}
