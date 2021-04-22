package com.casestudy4.repository;

import com.casestudy4.entity.Customer;
import com.casestudy4.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("select e from Employee e where concat(e.name,e.idCard) like %?1%")
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
    Page<Employee> findByOrderByNameAsc(Pageable pageable);
}
