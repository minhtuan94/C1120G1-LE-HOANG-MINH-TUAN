package com.casestudy4.services;

import com.casestudy4.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractServices extends Services<Contract> {
    Page<Contract> getListUsingCustomer(String date, Pageable pageable);
}
