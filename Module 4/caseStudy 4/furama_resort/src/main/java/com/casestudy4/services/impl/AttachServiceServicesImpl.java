package com.casestudy4.services.impl;

import com.casestudy4.entity.AttachService;
import com.casestudy4.repository.AttachRepository;
import com.casestudy4.services.AttachServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServicesImpl implements AttachServiceServices {

    @Autowired
    private AttachRepository attachRepository;


    @Override
    public Page<AttachService> findAll(Pageable pageable) {
        return attachRepository.findAll(pageable);
    }

    @Override
    public AttachService findById(Integer id) {
        return attachRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AttachService attachService) {
        attachRepository.save(attachService);
    }

    @Override
    public void delete(Integer id) {
        attachRepository.deleteById(id);
    }

    @Override
    public List<AttachService> findAll() {
        return attachRepository.findAll();
    }
}
