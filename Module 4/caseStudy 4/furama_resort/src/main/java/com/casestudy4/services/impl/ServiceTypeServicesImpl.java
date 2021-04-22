package com.casestudy4.services.impl;

import com.casestudy4.entity.ServiceType;
import com.casestudy4.repository.ServiceTypeRepository;
import com.casestudy4.services.ServiceTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceTypeServicesImpl implements ServiceTypeServices {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;


    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }
}
