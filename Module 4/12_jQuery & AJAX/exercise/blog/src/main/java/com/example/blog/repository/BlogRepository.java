package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAll();

    Page<Blog> findBlogByCategory_Id(Integer id, Pageable pageable);

    List<Blog> findBlogByNameContains(String search);

    Page<Blog> findBlogByOrderByDateAsc(Pageable pageable);
}
