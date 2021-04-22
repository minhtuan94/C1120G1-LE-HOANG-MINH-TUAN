package com.casestudy4.services;

import com.casestudy4.entity.Customer;
import com.casestudy4.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceServices extends Services<Service> {
    Page<Service> search(String name, Pageable pageable);

    Page<Service> sort(Pageable pageable);
}
