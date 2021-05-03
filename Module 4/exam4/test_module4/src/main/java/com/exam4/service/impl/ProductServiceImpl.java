package com.exam4.service.impl;

import com.exam4.entity.Bill;
import com.exam4.entity.Product;
import com.exam4.repository.ProductRepository;
import com.exam4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {

        productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> sort(Pageable pageable) {
        return productRepository.findByOrderByNameAsc(pageable);
    }

}
