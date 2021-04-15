package com.example.blog.service;

import com.example.blog.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    void saveCategory(Category category);

    void deleteCategory(Integer id);

    Category findCategoryById(Integer id);
}
