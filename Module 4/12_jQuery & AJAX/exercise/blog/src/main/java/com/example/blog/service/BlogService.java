package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAllBlog();

    Optional<Blog> findBlogById(Integer id);

    void deleteBlog(Integer id);

    void saveBlog(Blog blog);

    Page<Blog> findBlogByCategory_Id(Integer id, Pageable pageable);

    List<Blog> findBlogByNameContains(String search, Integer number);

    Page<Blog> findBlogByOrderByDateAsc(Pageable pageable);

    List<Blog> findAllBlogByNumber(Integer number);
}
