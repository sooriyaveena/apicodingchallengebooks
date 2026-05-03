package com.hexaware.codingchangllenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.codingchangllenge.entity.Book;
import com.hexaware.codingchangllenge.repository.BookRepo;


@Service
public class BookService {

    @Autowired
    private BookRepo br;

    public List<Book> getAllBooks() {
        return br.findAll();
    }

    public Book getBookByIsbn(String isbn) {
        return br.findById(isbn).orElseThrow(() -> throw new ResourceNotFoundException("Book not found");
    }

    public Book addBook(Book book) {
        if (br.existsById(book.getIsbn())) {
            throw new RuntimeException("Book already exists");
        }
        return br.save(book);
    }

  
    public Book updateBook(String isbn, Book book) {
        Book b = br.findById(isbn).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setPublicationYear(book.getPublicationYear());

        return br.save(b);
    }

  
    public String deleteBook(String isbn) {
        Book b = br.findById(isbn).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        br.delete(b);
        return "Deleted Book Successfully";
    }
}
