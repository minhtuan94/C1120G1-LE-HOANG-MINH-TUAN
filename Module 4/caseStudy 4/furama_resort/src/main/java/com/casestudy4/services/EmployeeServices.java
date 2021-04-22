package com.casestudy4.services;

import com.casestudy4.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeServices extends Services<Employee> {
    Page<Employee> search(String name, Pageable pageable);

    Page<Employee> sort(Pageable pageable);
}
