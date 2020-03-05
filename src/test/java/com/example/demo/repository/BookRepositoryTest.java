package com.example.demo.repository;

import com.example.demo.domain.Book;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.matcher.TypeSortMatcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;
import org.springframework.data.util.Streamable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;


@DataJpaTest
@ExtendWith(SpringExtension.class)
public class BookRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    BookRepository bookRepository;
    Book book = new Book();


    @BeforeEach
    public void setup() {
        bookRepository.deleteAll();
        book.setAuthor("Ben");
        book.setCreatedAt(LocalDate.now());
        book.setPrice(100.0);
        book.setSnb("123456-SNB");
        testEntityManager.persist(book);

    }

    @Test
    public void testSearch1() {
        assertThat(bookRepository.count()).isNotEqualTo(0);
    }

    @Test
    public void testSearch2() {
        assertThat(bookRepository.findBySnb("123456-SNB").isPresent()).isEqualTo(true);
        Optional<Book> book = bookRepository.findBySnb("123456-SNB");

    }

    @Test
    public void testSearch3() {
        Sort.TypedSort<Book> bookTypedSort = Sort.sort(Book.class);
        Sort sort = bookTypedSort.by(Book::getAuthor).ascending()
                .and(bookTypedSort.by(Book::getAuthor).descending());
        List<Book> books = bookRepository.findTop2ByAuthor("Ben", sort);
        assertThat(books.size()).isGreaterThan(0);
    }

    @Test
    public void testSearchStreamAblePassed() {
        Streamable<Book> bookStream = bookRepository.findByAuthor("Ben").and(bookRepository.findByPriceBetween(10, 1100));
        assertThat(bookStream.iterator().hasNext()).isEqualTo(true);
    }

    @Test
    public void testSearchStreamAbleFailed() {
        List<Book> books = bookRepository.findByAuthor("Ben").and(bookRepository.findByPriceBetween(200, 1100)).toList();
        //bookStream.get().forEach(System.out::print);
        assertThat(books.size()).isZero();
    }
}
