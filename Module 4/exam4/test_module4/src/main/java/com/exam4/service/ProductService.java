package com.exam4.service;

import com.exam4.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService extends Service<Product> {
//    Page<Product> search(String name, Pageable pageable);

    Page<Product> sort(Pageable pageable);


}
