package com.casestudy4.services.impl;

import com.casestudy4.entity.Division;
import com.casestudy4.repository.DivisionRepository;
import com.casestudy4.services.DivisionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServicesImpl implements DivisionServices {

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }
}
