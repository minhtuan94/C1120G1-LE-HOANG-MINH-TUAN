package com.casestudy4.repository;

import com.casestudy4.entity.Customer;
import com.casestudy4.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    @Query("select s from Service s where concat(s.name,s.area,s.cost) like %?1%")
    Page<Service> findAllByNameContaining(String name, Pageable pageable);

    Page<Service> findByOrderByNameAsc(Pageable pageable);

}
