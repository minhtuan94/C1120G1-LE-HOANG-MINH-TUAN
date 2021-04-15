package com.phone.service.impl;

import com.phone.model.Smartphone;
import com.phone.repository.SmartphoneRepository;
import com.phone.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        Smartphone smartphone = smartphoneRepository.findById(id).orElse(null);
        if(smartphone == null){
            return null;
        }
        return smartphone;
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
        return smartphone;
    }

    @Override
    public Smartphone delete(Integer id) {
        Smartphone smartphone = findById(id);
        smartphoneRepository.deleteById(id);
        return smartphone;
    }
}
