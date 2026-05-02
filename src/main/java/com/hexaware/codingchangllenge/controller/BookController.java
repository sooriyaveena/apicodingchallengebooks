package com.hexaware.codingchangllenge.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.codingchangllenge.apiresponse.ApiResponse;
import com.hexaware.codingchangllenge.entity.Book;
import com.hexaware.codingchangllenge.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bs;


    @GetMapping("/getallbooks")
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooks() {
        List<Book> books = bs.getAllBooks();
        ApiResponse<List<Book>> response = new ApiResponse<>(true, "Success", books);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getbookbyisbn/{isbn}")
    public ResponseEntity<ApiResponse<Book>> getBookByIsbn(@PathVariable String isbn) {
        Book book = bs.getBookByIsbn(isbn);
        ApiResponse<Book> response = new ApiResponse<>(true, "Book fetched", book);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addbooks")
    public ResponseEntity<ApiResponse<Book>> addBook(@RequestBody Book book) {
        Book saved = bs.addBook(book);
        ApiResponse<Book> response = new ApiResponse<>(true, "Book added", saved);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updatebook/{isbn}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@PathVariable String isbn, @RequestBody Book book) {
        Book updated = bs.updateBook(isbn, book);
        ApiResponse<Book> response = new ApiResponse<>(true, "Book updated", updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletebook/{isbn}")
    public ResponseEntity<ApiResponse<String>> deleteBook(@PathVariable String isbn) {
        bs.deleteBook(isbn);
        ApiResponse<String> response = new ApiResponse<>(true, "Book deleted", null);
        return ResponseEntity.ok(response);
    }
}