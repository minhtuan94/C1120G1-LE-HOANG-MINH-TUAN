package com.borrowbook.repository;

import com.borrowbook.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByBookCode(String code);
}
