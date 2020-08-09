package com.example.demo.repository;


import com.example.demo.domain.Book;


public class BookUtils {

    Book convertToUpperCase(Book book){
        Book convertBook = new Book();
        book.setId(book.getId());
        book.setPrice(book.getPrice());
        return convertBook;
    }
}
