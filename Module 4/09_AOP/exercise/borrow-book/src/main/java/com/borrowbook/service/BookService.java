package com.borrowbook.service;

import com.borrowbook.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(int id);

    Book findByCode(String code);

    void save(Book book);

    void remove(int id);

}
