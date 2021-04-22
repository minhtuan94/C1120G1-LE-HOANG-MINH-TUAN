package com.casestudy4.services.impl;

import com.casestudy4.entity.Position;
import com.casestudy4.repository.PositionRepository;
import com.casestudy4.services.PositionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServicesImpl implements PositionServices {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }
}
