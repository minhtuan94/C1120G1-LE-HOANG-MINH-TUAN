package com.casestudy4.services.impl;

import com.casestudy4.entity.ContractDetail;
import com.casestudy4.repository.ContractDetailRepository;
import com.casestudy4.services.ContractDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServicesImpl implements ContractDetailServices {

    @Autowired
    private ContractDetailRepository contractDetailRepository;


    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public ContractDetail findById(Integer id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(Integer id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
