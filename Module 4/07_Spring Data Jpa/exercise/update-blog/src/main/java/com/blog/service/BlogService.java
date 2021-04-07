package com.blog.service;

import com.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void delete(Integer id);

    Page<Blog> search(String name,Pageable pageable);

    Page<Blog> sort(Pageable pageable);
}
