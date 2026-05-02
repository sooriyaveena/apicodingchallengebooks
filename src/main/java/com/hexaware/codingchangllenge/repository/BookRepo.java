package com.hexaware.codingchangllenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.codingchangllenge.entity.Book;


public interface BookRepo extends JpaRepository<Book, String>{

    public Book findByIsbn(String isbn);
    
}
