package com.example.i18n.service;

import com.example.i18n.model.Customer;

import java.util.List;
import java.util.Locale;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void delete(Integer id);

}
