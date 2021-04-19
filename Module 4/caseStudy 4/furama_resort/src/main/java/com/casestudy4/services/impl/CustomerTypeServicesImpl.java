package com.casestudy4.services.impl;

import com.casestudy4.entity.CustomerType;
import com.casestudy4.repository.CustomerTypeRepository;
import com.casestudy4.services.CustomerServices;
import com.casestudy4.services.CustomerTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServicesImpl implements CustomerTypeServices {

    @Autowired
    private CustomerTypeRepository customerTypeRepository;


    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
