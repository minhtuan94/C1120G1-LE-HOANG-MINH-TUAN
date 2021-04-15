package com.phone.service;

import com.phone.model.Smartphone;

import java.util.List;

public interface SmartphoneService {
    List<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone smartphone);
    Smartphone delete(Integer id);
}
