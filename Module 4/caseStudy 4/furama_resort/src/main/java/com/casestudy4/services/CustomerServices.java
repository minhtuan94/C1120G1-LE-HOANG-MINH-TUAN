package com.casestudy4.services;

import com.casestudy4.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerServices extends Services<Customer> {
    Page<Customer> search(String name, Pageable pageable);

    Page<Customer> sort(Pageable pageable);
}
