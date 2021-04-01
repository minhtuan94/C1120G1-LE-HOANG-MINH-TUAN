package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();

    Customer findById(int id);

    void save(Customer customer);

    void delete(int id);
}
