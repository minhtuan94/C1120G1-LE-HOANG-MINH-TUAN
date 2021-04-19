package com.casestudy4.services;

import com.casestudy4.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Services<T> {
    Page<T> findAll(Pageable pageable);

    T findById(Integer id);

    void save(Customer customer);

    void delete(Integer id);
}
