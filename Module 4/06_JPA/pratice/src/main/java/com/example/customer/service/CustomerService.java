package com.example.customer.service;

import com.example.customer.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();

    Customer findById(Integer id);

    void save(Customer customer);

    void delete(Integer id);
}
