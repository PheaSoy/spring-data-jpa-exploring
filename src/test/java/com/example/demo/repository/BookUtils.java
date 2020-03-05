package com.example.demo.repository;


import com.example.demo.domain.Book;


public class BookUtils {

    Book convertToUpperCase(Book book){
        Book convertBook = new Book();
        book.setId(book.getId());
        book.setSnb(book.getSnb().toUpperCase());
        book.setPrice(book.getPrice());
        book.setCreatedAt(book.getCreatedAt());
        return convertBook;
    }
}
