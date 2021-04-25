package com.casestudy4.services;

import com.casestudy4.entity.Customer;
import com.casestudy4.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;

import java.util.List;

public interface ServiceServices{
    Page<Service> search(String name, Pageable pageable);

    Page<Service> sort(Pageable pageable);

    Page<Service> findAll(Pageable pageable);

    Service findById(Integer id);

    void save(Service service);

    void delete(Integer id);

//    List<Service> getListServiceAvailable(String date);

    List<Service> findAll();

    void checkServiceCode (Service service, Errors errors);
}
