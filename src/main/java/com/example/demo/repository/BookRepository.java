package com.example.demo.repository;

import com.example.demo.domain.Book;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Streamable;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface BookRepository extends CrudRepository<Book, Integer> {


  List<Book> findTop2ByTitle(String author, Sort sort);

  Streamable<Book> findByTitle(String author);

  Streamable<Book> findByPriceBetween(double start, double end);


}
