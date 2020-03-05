package com.example.demo.repository;

import com.example.demo.domain.Book;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.Predicate;

public interface BookRepositorySpecification extends CrudRepository<Book,Integer>, JpaSpecificationExecutor<Book> {
    List<Book> findAllBook(Specification<Book> specification);
}

interface Specification<T> {
    Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
                          CriteriaBuilder builder);
}
class BookSpecification {
    public static Specification<Book> isLongerAuthorName(String name){
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                int length = 10;
                return null;

            }
        };
    }
}