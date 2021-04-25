package com.casestudy4.services;

import com.casestudy4.entity.Contract;
import com.casestudy4.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractServices extends Services<Contract> {
    Page<Contract> getListUsingCustomer(String date, Pageable pageable);
    String getCurrentDate();
    double getTotalMoney(Contract contract);
    ContractDetail save(ContractDetail contractDetail);
}
