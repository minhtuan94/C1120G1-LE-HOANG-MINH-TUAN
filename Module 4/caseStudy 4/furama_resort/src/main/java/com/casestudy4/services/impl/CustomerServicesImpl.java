package com.casestudy4.services.impl;

import com.casestudy4.entity.Customer;
import com.casestudy4.repository.CustomerRepository;
import com.casestudy4.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> search(String name, Pageable pageable) {
        return customerRepository.findAllByTitleContaining(name,pageable);
    }

    @Override
    public Page<Customer> sort(Pageable pageable) {
        return customerRepository.findByOrderByNameAsc(pageable);
    }
}
