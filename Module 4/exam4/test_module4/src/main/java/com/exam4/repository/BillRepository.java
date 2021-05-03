package com.exam4.repository;

import com.exam4.entity.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
//    @Query(value =  "select * from bill " +
//            "where `date_buy` >= ?1 and `date_buy` <= ?2 ",
//            nativeQuery = true)
//    Page<Bill> getListFromTo(String from, String to, Pageable pageable);
//
//    @Query(value =  "select * from bill  " +
//            "order by bill.total desc " +
//            "limit ?1",
//            nativeQuery = true)
//    List<Bill> getTopContract(Integer top);
}
