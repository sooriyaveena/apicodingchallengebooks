package com.hexaware.codingchangllenge.mapper;

import com.hexaware.codingchangllenge.dto.BookRequest;
import com.hexaware.codingchangllenge.entity.Book;

public class BookMapper {

    public static Book toEntity(BookRequest dto) {
        Book book = new Book();
        book.setIsbn(dto.getIsbn());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPublicationYear(dto.getPublicationYear());
        return book;
    }
    public static Book toDTO(Book book) {
        return book;
    }
}