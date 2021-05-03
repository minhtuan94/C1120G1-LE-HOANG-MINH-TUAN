package com.exam4.service.impl;

import com.exam4.entity.ProductType;
import com.exam4.repository.ProductTypeRepository;
import com.exam4.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;


    @Override
    public Page<ProductType> findAll(Pageable pageable) {
        return productTypeRepository.findAll(pageable);
    }

    @Override
    public ProductType findById(Integer id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductType productType) {
        productTypeRepository.save(productType);
    }

    @Override
    public void delete(Integer id) {
        productTypeRepository.deleteById(id);
    }

    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
