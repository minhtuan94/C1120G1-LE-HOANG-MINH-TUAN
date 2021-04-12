package com.cart.service;

import com.cart.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    Double totalPrice(Map<Product,Integer> cart);
}
