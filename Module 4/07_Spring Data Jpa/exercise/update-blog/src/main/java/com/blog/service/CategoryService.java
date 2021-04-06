package com.blog.service;
import com.blog.entity.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void delete(Integer id);
}
