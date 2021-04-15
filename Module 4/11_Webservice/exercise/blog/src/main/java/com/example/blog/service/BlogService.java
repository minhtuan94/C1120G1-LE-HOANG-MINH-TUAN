package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();

    Blog findById(Integer id);

    void save(Blog blog);

    void delete(Integer id);
}
