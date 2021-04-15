package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category findById(Integer id);
    void save(Category category);
    void delete(Integer id);
}
