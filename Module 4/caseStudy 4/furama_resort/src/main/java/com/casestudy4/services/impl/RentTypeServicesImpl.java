package com.casestudy4.services.impl;

import com.casestudy4.entity.RentType;
import com.casestudy4.repository.RentTypeRepository;
import com.casestudy4.services.RentTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServicesImpl implements RentTypeServices {

    @Autowired
    private RentTypeRepository rentTypeRepository;


    @Override
    public List<RentType> findAllRentTypeService() {
        return rentTypeRepository.findAll();
    }
}
