package com.exam4.repository;

import com.exam4.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
//    //tìm kiếm
//    @Query(value = "select p from Product p where concat(p.) like %?1%")
//    Page<Product> findAllByTitleContaining(String title, Pageable pageable);
    //sắp xếp theo tên
    Page<Product> findByOrderByNameAsc(Pageable pageable);
}
