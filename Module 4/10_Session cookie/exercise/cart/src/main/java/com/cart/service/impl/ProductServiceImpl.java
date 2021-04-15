package com.cart.service.impl;

import com.cart.entity.Product;
import com.cart.repository.ProductRepository;
import com.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Double totalPrice(Map<Product, Integer> cart) {
        Double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            totalPrice += entry.getKey().getPrice()*entry.getValue();
        }
        return totalPrice;
    }
}