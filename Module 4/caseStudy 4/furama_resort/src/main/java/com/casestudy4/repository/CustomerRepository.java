package com.casestudy4.repository;

import com.casestudy4.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c from Customer c where concat(c.name,c.idCard,c.customerType.name) like %?1%")
    Page<Customer> findAllByTitleContaining(String title, Pageable pageable);
    Page<Customer> findByOrderByNameAsc(Pageable pageable);
}
