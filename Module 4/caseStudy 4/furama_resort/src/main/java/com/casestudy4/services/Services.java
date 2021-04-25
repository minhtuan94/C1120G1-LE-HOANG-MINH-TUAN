package com.casestudy4.services;

import com.casestudy4.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Services<T> {
    Page<T> findAll(Pageable pageable);

    T findById(Integer id);

    void save(T t);

    void delete(Integer id);

    List<T> findAll();

}
