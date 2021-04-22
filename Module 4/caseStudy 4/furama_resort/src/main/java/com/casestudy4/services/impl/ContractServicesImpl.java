package com.casestudy4.services.impl;

import com.casestudy4.entity.Contract;
import com.casestudy4.repository.ContractRepository;
import com.casestudy4.services.ContractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServicesImpl implements ContractServices {

    @Autowired
    private ContractRepository contractRepository;


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void delete(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> getListUsingCustomer(String date, Pageable pageable) {
        return contractRepository.getListUsingCustomer(date, pageable);
    }
}
