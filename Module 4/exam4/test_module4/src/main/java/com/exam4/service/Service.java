package com.exam4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service<T> {
    Page<T> findAll(Pageable pageable);

    T findById(Integer id);

    void save(T t);

    void delete(Integer id);

    List<T> findAll();

}
