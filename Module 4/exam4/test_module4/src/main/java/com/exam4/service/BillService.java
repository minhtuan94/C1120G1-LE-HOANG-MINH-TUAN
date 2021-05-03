package com.exam4.service;

import com.exam4.entity.Bill;
import com.exam4.entity.Product;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface BillService extends Service<Bill> {
//    Page<Bill> getListFromTo(String from, String to, Pageable pageable);
    double getTotalMoney(Bill bill);
}
