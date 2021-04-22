package com.casestudy4.repository;

import com.casestudy4.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract " +
            "where contract_end_date >= ?1 " +
            "group by customer_id", nativeQuery = true)
    Page<Contract> getListUsingCustomer(String date, Pageable pageable);
}
