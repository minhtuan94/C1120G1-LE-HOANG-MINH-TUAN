package com.casestudy4.services.impl;

import com.casestudy4.repository.ServiceRepository;
import com.casestudy4.services.ServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class ServiceServicesImpl implements ServiceServices {

    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Page<com.casestudy4.entity.Service> search(String name, Pageable pageable) {
        return serviceRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<com.casestudy4.entity.Service> sort(Pageable pageable) {
        return serviceRepository.findByOrderByNameAsc(pageable);
    }


    @Override
    public Page<com.casestudy4.entity.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public com.casestudy4.entity.Service findById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(com.casestudy4.entity.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<com.casestudy4.entity.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void checkServiceCode(com.casestudy4.entity.Service service, Errors errors) {
        for(com.casestudy4.entity.Service ser : findAll()){
            if (ser.getCode().equals(service.getCode())){
                errors.rejectValue("code", "ser.code.existed");
                return;
            }
        }
    }

//    @Override
//    public List<com.casestudy4.entity.Service> getListServiceAvailable(String date) {
//        return serviceRepository.getListServiceAvailable(date);
//    }
}
