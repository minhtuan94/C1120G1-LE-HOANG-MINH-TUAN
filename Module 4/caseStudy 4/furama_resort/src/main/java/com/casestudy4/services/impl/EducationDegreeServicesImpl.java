package com.casestudy4.services.impl;

import com.casestudy4.entity.EducationDegree;
import com.casestudy4.repository.EducationDegreeRepository;
import com.casestudy4.services.EducationDegreeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServicesImpl implements EducationDegreeServices {

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }
}
